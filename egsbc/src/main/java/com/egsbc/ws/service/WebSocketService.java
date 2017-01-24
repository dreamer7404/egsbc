package com.egsbc.ws.service;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.egsbc.security.CustomUserDetails;
import com.egsbc.system.UserActionHistoryVO;
import com.egsbc.system.UserVO;
import com.egsbc.system.service.UserService;
import com.egsbc.utils.Global;
import com.egsbc.ws.ChartVO;
import com.egsbc.ws.DateTimeVO;
import com.egsbc.ws.MediaTraceVO;
import com.egsbc.ws.MsgVO;
import com.egsbc.ws.SipTraceVO;
import com.egsbc.ws.TraceResVO;
import com.egsbc.ws.TraceVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value="webSocketService")
public class WebSocketService extends TextWebSocketHandler implements InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);
	
	@Resource(name="userService")
	 private UserService userService;

	@Value("${Host}") 
	private String host;
	
	@Value("${Port}") 
	private int port;
	
	@Value("${PortChart}") 
	private int portChart;
	
	@Value("${SoTimeout}") 
	private int soTimeout;
	
	@Value("${TcpDumpPath}") 
	private String tcpDumpPath;
	
	@Value("${TcpDumpFileName}") 
	private String tcpDumpFileName;
	
	Socket clientSocket = null;
	DataOutputStream outToServer = null;
	DataInputStream dataInputStream = null;
	
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	private SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA ); 
	
	
	//-------- for process ---------------
	private Process process;
	private WebSocketSession threadSession;
	private String threadCmd;
	private Thread threadProcess;
	
	/*------------------------------------------
	 *  for Trace
	 *  
	 *  session, request condition별 connection 따로한다.
	  -------------------------------------------*/
	private ExecutorService esTrace = Executors.newFixedThreadPool(30); // thread service
	private List<TraceVO> traceList = new ArrayList<TraceVO>(); // trace list
	
		
	
	public WebSocketService() {
		super();
	}

	/*
	 * 연결종료 이벤트
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		
		
		// 주의: 이미 session이 종료된 시점이라 session.close() 하면 에러발생.
		System.out.println(session.getId() + " Connect Closed.");
		
		// sesstionSet 삭제
		sessionSet.remove(session);
		
		// traceList에서 해당 session삭제
		for(int i=0; i<traceList.size(); i++){
			TraceVO traceVO = traceList.get(i);
			if(traceVO.getSession().getId() == session.getId()){
				traceList.remove(i);
			}
		}
		
		
	}

	/*
	 * 연결 이벤트
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		
		System.out.println("@Session Connected [" + session.getId() + "]");
		
		try{
			
//			webSocketSession = session;
//			webSocketSession.sendMessage(new TextMessage("connected!"));
			
			sessionSet.add(session);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/*
	 * 수신메시지 핸들
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		
		System.out.println("@Received Message : " + message.getPayload());
		
		ObjectMapper mapper = new ObjectMapper();
		MsgVO vo = new MsgVO();
		
		
		
		if(message.getPayload().length() > 0){ 
			
			vo = mapper.readValue(message.getPayload(), MsgVO.class);
			if(vo.getMsgType().equals("P")){ // ping
			
				try {
					
					String cmd = "ping "+vo.getToIP();
					
					if(!System.getProperty("os.name").contains("Windows")){
						if(vo.getFromIP().length() > 0){
							cmd +=  " -I " + vo.getFromIP();
						}
						cmd += " -c 5";
					}
					
					sendingMsgFromStream(cmd, session, "P");
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(vo.getMsgType().equals("D")){ // tcp dump
				try {
					logger.info("[TCPDUMP] msgMode: " + vo.getMsgMode());
					
					if(vo.getMsgMode().equals("S")){ // start process
						String cmd = "tcpdump -i " + vo.getIntf();
						
						if(!vo.getTransport().equals("any")){
							cmd += " " + vo.getTransport();
						}
						
						if(vo.getPort() != 0){
							cmd += " port " + vo.getPort();
						}
						
						cmd += " -s 0 -G " + vo.getDuration() + " -W 1 -w " + tcpDumpPath + tcpDumpFileName;
						logger.info("[TCPDUMP] Cmd : " + cmd);
						
						//sendingMsgFromStream(cmd, session, "D");
						
						
						
						if(threadProcess != null && threadProcess.getState() != Thread.State.TERMINATED){
							session.sendMessage(new TextMessage(mapper.writeValueAsString(new MsgVO("D", "A", ""))));
						}else{
						
							//--------------- thread -----------------------------------
							threadSession = session;
							threadCmd = cmd;
							
							threadProcess = new Thread(){
								  @Override
						            public void run() {
									  sendingMsgFromStream(threadCmd, threadSession, "D");
								  }
							};
							threadProcess.start();
							//---------------- // thread ----------------------------------
						
						}
						
						
					}else if(vo.getMsgMode().equals("K")){ // kill process
						//process.waitFor();
						process.destroy();
						
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(vo.getMsgType().equals("T")){ // trace
				
				logger.info("[TRACE] traceCmd: " + vo.getTraceCmd() + ", traceType: " + vo.getTraceType() + ", condition: " + vo.getCondition());
				
				if(vo.getTraceCmd().equals("add")){ // add & new connection
				
						final TraceVO traceVO = new TraceVO(session, vo.getTraceCmd(), vo.getTraceType(), vo.getCondition(), vo.getDuration());
					
						//--------------- thread -----------------------------------
						Runnable runnable = new Runnable() {
							@Override
							public void run() {
								ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) esTrace;
								logger.info("[TRACE] pool size => " + threadPoolExecutor.getPoolSize());
								doTrace(traceVO, Thread.currentThread());
							}
						};
						Future<?> future = esTrace.submit(runnable); 
						traceVO.setFuture(future);
						addTraceList(traceVO);
						
						
						//---------------- // thread ----------------------------------
				}else if(vo.getTraceCmd().equals("del")){ // delete & disconnect
					
					
					String key = session.getId() + vo.getTraceType() + vo.getCondition();
					TraceVO traceVO = getTrace(key);
					if(traceVO != null){
						Future<?> future = traceVO.getFuture();
						if(future.cancel(true)){ // close thread & client socket
							removeTraceList(key); // remove traceList
							
							String str = mapper.writeValueAsString(new TraceResVO("L", "ok", vo.getTraceCmd(), vo.getTraceType(), vo.getCondition()));
							session.sendMessage(new TextMessage(str));
							
						}
					}
					
				}
				
			}
		}
		
	}
	
	
	/*
	 *	sending message from stream 
	 */
	
	private void sendingMsgFromStream(String cmd, WebSocketSession session, String msgType) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		ProcessBuilder  processBuilder = null;
		
		try {
			if(System.getProperty("os.name").contains("Windows")){
				processBuilder = new ProcessBuilder("cmd", "/c", cmd);
			}else{
				processBuilder = new ProcessBuilder("/bin/bash", "-c",  cmd);
			}
			processBuilder.redirectErrorStream(true);
			process = processBuilder.start();
			
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
			
			String s = "";
			while ((s = inputStream.readLine()) != null) {
				if(!s.isEmpty()){
						session.sendMessage(new TextMessage(mapper.writeValueAsString(new MsgVO(msgType, s))));
				}
			}
			session.sendMessage(new TextMessage(mapper.writeValueAsString(new MsgVO(msgType, "E", ""))));
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * get traceVO
	 */
	private TraceVO getTrace(String key){
		for(TraceVO traceVO : traceList){
			if(traceVO.getKey().equals(key)){
				return traceVO;
			}
		}
		return null;
	}
	private TraceVO getTrace(TraceVO vo){
		for(TraceVO traceVO : traceList){
			if(traceVO.getKey().equals(vo.getKey())){
				return traceVO;
			}
		}
		return null;
	}
	
	/*
	 *	add trace list
	 */
	private void addTraceList(TraceVO vo){
		if(getTrace(vo.getKey()) == null){
			traceList.add(vo);
		}
	}
	
	/*
	 * remove trace list
	 */
	private void removeTraceList(String key){
		for(int i=0; i<traceList.size(); i++){
			TraceVO traceVO = traceList.get(i);
			if(traceVO.equals(key)){
				traceList.remove(i);
				break;
			}
		}
	}
	
	
	/*
	 *	delete trace list
	 */
	private boolean deleteTraceList(String createdTime){
		
		for(int i=0; i<traceList.size(); i++){
			TraceVO traceVO = traceList.get(i);
			
			if(traceVO.getCreatedTime().equals(createdTime)){
				Future<?> future = traceVO.getFuture();
				if(future.cancel(true)){
					traceList.remove(i);
					logger.info("[TRACE] OK! deleteTraceList! : traceList.size : " + traceList.size()); 
					return true;
				}
			}
		}
		logger.info("[TRACE] Fail! deleteTraceList : can not find key!"); 
		return false;
	}
	

	/*
	 *	do trace 
	 */
	private void doTrace(TraceVO vo, Thread currentThread) {
		
			
			Socket clientSocket = null;
			DataOutputStream outToServer = null;
			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println("[TRACE] sessionID: " + vo.getSession().getId() 
					+ ", traceCmd: " + vo.getTraceCmd()
					+ ", traceType: " + vo.getTraceType()
					+ ", condition: " + vo.getCondition()
					);
			
			try {
				
				// connect
				clientSocket = new Socket("localhost", 5000);
				
				// send
				String reqData = "req_trace|" + vo.getTraceCmd() + "|" + vo.getCondition() + "|" + vo.getDuration();
				
				outToServer = new DataOutputStream(clientSocket.getOutputStream());
				outToServer.writeUTF(reqData);    
				outToServer.flush();
				
				// read
				while(!Thread.currentThread().isInterrupted()){
					dataInputStream = new DataInputStream(clientSocket.getInputStream());
					String str = dataInputStream.readUTF();
					System.out.println("@Received from Server " + str);
					
					String[] arr = str.split("\\|");
					
					if(arr.length > 3){
						//----------- req_trace ----------------------------
						if(arr[0].equals("res_trace")){
							String traceCmd = arr[1]; // add,del
							String condition = arr[2];
							String msgMode = arr[3]; // ok,error
						
							// send msg to web
							TraceVO traceVO = new TraceVO("L", msgMode, traceCmd, formatter.format (new Date()), vo.getTraceType(), condition);
							vo.getSession().sendMessage(new TextMessage(mapper.writeValueAsString(traceVO)));
							
							// if receive error, interrupt
							if(msgMode.equals("error")){
								logger.info("[TRACE] Interrupt : received Error from SBP.");
								currentThread.interrupt();
							}
						
						//----------- sip_trace ----------------------------	
						} else if(arr[0].equals("sip_trace")){
							SipTraceVO sipTraceVO = new SipTraceVO(
									"S",
									arr[5], //method
									arr[7], // code
									arr[9], 	// call id
									arr[11], 	// time
									arr[13], // from
									arr[15], // to
									arr[17], // protocol
									arr[18], // src 
									arr[19], // srcAddress, 
									arr[21], // srcPort, 
									arr[22], // dst, 
									arr[23], // dstAddress, 
									arr[25], // dstPort, 
									arr[27], // msgLen, 
									arr[28] // msg
									);
							
							vo.getSession().sendMessage(new TextMessage(mapper.writeValueAsString(sipTraceVO)));
							
						//----------- media_trace ----------------------------		
						} else if(arr[0].equals("media_trace")){
							MediaTraceVO mediaTraceVO = new MediaTraceVO(
									"M",
									arr[2], 	// call id
									arr[4], 	// time
									arr[6], // lStatus
									arr[8], // lType
									arr[10], // rStatus
									arr[12], // rType 
									arr[14], // aIp, 
									arr[16], // aPort, 
									arr[18], // bIp, 
									arr[20], // bPort, 
									arr[22], // cIp, 
									arr[24], // cPort, 
									arr[26], // dIp, 
									arr[28], // dPort, 
									arr[30], // msgLen, 
									arr[31] // msg, 
									);
							
							vo.getSession().sendMessage(new TextMessage(mapper.writeValueAsString(mediaTraceVO)));
							
						}
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				
				// send msg to web
				String msg =  getRootCause(e).getMessage();
				if(msg != null){
					try {
						vo.getSession().sendMessage(new TextMessage(mapper.writeValueAsString(new MsgVO("L", "error", msg))));
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				
			}finally{
				
				if(clientSocket != null){
					try {
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				logger.info("[TRACE] finally.");
			}
				
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		
		Thread threadDateTime = new Thread(){
			
			ObjectMapper mapper = new ObjectMapper();
            
            @Override
            public void run() {

            	while (true){

	                 try {
	                	 
	                	 for (WebSocketSession session: sessionSet){
	                         if (session.isOpen()){
                                try{
                                	DateTimeVO vo = new DateTimeVO();
                                	vo.setMsgType("T");
                                	vo.setDateTime(formatter.format (new Date()));
                                	
                                	session.sendMessage(new TextMessage(mapper.writeValueAsString(vo)));
                                }catch (Exception ignored){
                                	logger.error("fail to send message!", ignored);
                                }
	                         }
	                	 }

	                     Thread.sleep(1000);
	                     
	                 } catch (InterruptedException e) {
	                        e.printStackTrace();
	                        break;
	                 }
	           }
            }
		};

		threadDateTime.start();
		
		
		
		
		Thread threadChart = new Thread(){
			
			private ServerSocket serverSocket = null;
			//private int port = 3000;
			ObjectMapper mapper = new ObjectMapper();
			
			@Override
            public void run() {
				
				try{
					if(serverSocket == null){
						serverSocket = new ServerSocket(portChart);
					}
				
					while(true){
						 Socket socket = null;
						 
						 try {
						 
							// accept
							 socket = serverSocket.accept();
							 logger.info("[OK] Chart Socket : connectd from " + socket.getInetAddress());
							 
							 InputStream in = socket.getInputStream();
							 
							 BufferedReader  br = new BufferedReader(new InputStreamReader(in));
							 String msg = null;
							 
							 while((msg = br.readLine()) != null){
								 
								 if(msg.length() == 0){
										logger.info("[ERROR] Chart Socket : received data length is zero!");
										continue;
									}
									 
									String[] arr = msg.split("\\|");
									if(arr.length < 8){
										logger.info("[ERROR] Chart Socket : received data length less than 8 (received length is " + arr.length);
										continue;
									}
									
									//---------- parsing ------------------------------
									 
									ChartVO vo = new ChartVO();
									vo.setMsgType("C");
									vo.setChartIndex(Short.parseShort(arr[0]));
									vo.setChartTitle(arr[1]); 
									
									int cnt = Integer.parseInt(arr[2]);
									int needCnt = 4 + (4 * cnt);
									
									if(arr.length != needCnt){
										logger.info("[ERROR] Chart Socket : received data length is Not proper length (need length is " + needCnt + ", but received length is " + arr.length);
										continue;
									}
									
									vo.setDataCnt(cnt); 
									
									int idx = 3;
									vo.setLegendArray(getStringArray(arr, idx, cnt));  	idx += cnt;
									vo.setColorArray(getStringArray(arr, idx, cnt)); 		idx += cnt;
									//vo.setDateTime(arr[idx].substring(14, 19)); 			idx += 1;
									vo.setDateTime(arr[idx]); 									idx += 1;
									vo.setDataArray(getStringArray(arr, idx, cnt));		idx += cnt;
									vo.setUnitArray(getStringArray(arr, idx, cnt));
									
									for (WebSocketSession session: sessionSet){
				                         if (session.isOpen()){
			                                try{
			                                	session.sendMessage(new TextMessage(mapper.writeValueAsString(vo)));
			                                }catch (Exception ignored){
			                                	logger.error("fail to send message!", ignored);
			                                }
				                         }
				                	 }
									
								 }
							 
						 }catch(IOException e){
//								logger.info("############# Socket ERROR(Chart 1) : " + getRootCause(e).getMessage());
						}finally{
//				        	if(socket != null){
//				        		try {
//				        			socket.close();
//				    			} catch (IOException e) {}
//				        	}
				        }	 
						 
					}
				}catch(IOException e){
					logger.info("############# Socket ERROR(Chart 2) : " + getRootCause(e).getMessage());
				}finally{
		        	if(serverSocket != null){
		        		try {
		        			serverSocket.close();
		    			} catch (IOException e) {}
		        	}
		        }
				
			}
		};
		threadChart.start();
		
	}
	
	private String getStringArray(String[] arr, int start, int cnt){
		String s = "";
		for(int i=0; i<cnt; i++){
			if(s != "") s += ",";
			s += arr[start++];
		} 
		return s;
	}
	
	
	/*
	 * request trace
	 */
	private void requestTrace() throws Exception {
		
		byte[] requestData = new byte[1];
		requestData[0] = (byte)0x65;
		
		byte[] buff = new byte[2048];
		byte[] responseData = null;
		
		try{
		
			// set socket
			clientSocket = new Socket(host, port);
	    	clientSocket.setSoTimeout(5000); //soTimeout);
	    	
	    	// send
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.write(requestData);    
			outToServer.flush();
			
			
			while(true){
			
				dataInputStream = new DataInputStream(clientSocket.getInputStream());
				String str = dataInputStream.readUTF();
				System.out.println("@Received from Server " + str);
				
				 //BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				 //String answer = reader.readLine();
	
				
				// send web
				//webSocketSession.sendMessage(new TextMessage(str));
			}
		
		
		}catch (SocketException e) { 
	        logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
        } catch (UnknownHostException e) { 
        	logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
        } catch (IOException e) { 	
        	logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
        }catch(Exception e){
        	logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
        }finally{
        	if(dataInputStream != null){
        		try {
        			dataInputStream.close();
    			} catch (IOException e) {
    				logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
    		    }
        	}
        	if(outToServer != null){
        		try {
        			outToServer.close();
    			} catch (IOException e) {
    				logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
    		    }
        	}
        	if(clientSocket != null){
        		try {
        			clientSocket.close();
    			} catch (IOException e) {
    				logger.info("############# Socket ERROR : " + getRootCause(e).getMessage());
    		    }
        	}
        }
    	
	}
	
	private static Throwable getRootCause(Throwable throwable) {
	    if (throwable.getCause() != null)
	        return getRootCause(throwable.getCause());

	    return throwable;
	}	
	
	


	
	
}
