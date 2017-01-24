package com.egsbc.utils;

public class Global {
	
	/*
	 *  connection
	 */
	//public static final String SERVER = "192.168.1.151";
//	public static final String SERVER = "localhost";
//	public static final int PORT = 2000;
//	public static final int IPC_TIMEOUT = 3000;
	
	/*
	 *  byte length of data type 
	 */
	public static final int SHO_LEN = 2;
	public static final int INT_LEN = 4;
	public static final int STR_LEN = 64;
	
	public static final int HEAD_DATA_LEN = 20;
	public static final int ERR_DATA_LEN = 326;
	
	/*
	 * exception
	 */
	public static final int ERR_SOCKET = -1;					// SocketException
	public static final int ERR_UNKNOWNHOST = -2; 		// UnknownHostException 
	public static final int ERR_IO = -3;							// IOException Exception
	public static final int ERR = -4; 								// Exception
	
	public static final int ERR_FILE_SAVE_FAILURE	= -11;
	public static final int ERR_FILE_SIZE_ZERO		= -12;
	public static final int ERR_FILE_NO_ATTACH 	= -13;
	
	
	
	/*
	 * IPC Class Code
	 */
	public static final int IPC_UNKNOWN 		= 0x0000;		
	
	public static final int IPC_PRODUCT 		= 0x1001;		
	public static final int IPC_COMPONENT 	= 0x1002;		
	public static final int IPC_PACKAGE 			= 0x1003;		
	public static final int IPC_PROCESS 			= 0x1004;		
	public static final int IPC_INTF_LIST 		= 0x1005;		
	public static final int IPC_ERROR_CODE 	= 0x1006;		
	public static final int IPC_SYSTEM 			= 0x1007;	
	public static final int IPC_RESOURCE 			= 0x1008;	
	public static final int IPC_DATABASE 			= 0x1009;	
	public static final int IPC_NTP 					= 0x1010;	
	
	public static final int IPC_NETWORK 		= 0x2001;		
	
	public static final int IPC_TRANSPORT_SIG 		= 0x3001;	
	public static final int IPC_TRANSPORT_MEDIA 	= 0x3002;	
	public static final int IPC_TRANSPORT_NAT 		= 0x3003;	
	public static final int IPC_TRANSPORT_NAT_SERVICE 		= 0x3013;
	
	public static final int IPC_SIP_REALM 				= 0x4001;	
	public static final int IPC_SIP_SERVER 				= 0x4002;	
	public static final int IPC_SIP_TRUNK 				= 0x4003;	
	public static final int IPC_SIP_REALM_GROUP 	= 0x4011;	
	public static final int IPC_SIP_SERVER_GROUP 	= 0x4012;	
	public static final int IPC_SIP_TRUNK_GROUP 	= 0x4013;	
	public static final int IPC_SIP_SERVICE 			= 0x4004;	
	public static final int IPC_SIP_SERVICE_RULE 	= 0x4014;	// routing rule
	public static final int IPC_SIP_EASY_REALMSERVER = 0x4015;	// easy realmServer
	public static final int IPC_SIP_EASY_TRUNKING = 0x4016;	// easy Trunking
	
	public static final int IPC_NAT_SERVICE 							= 0x4005;	
	public static final int IPC_NAT_ENTRY 								= 0x4006;	
	public static final int IPC_NAT_CONTROL_REG_ACCOUNT 	= 0x5001;	
	public static final int IPC_NAT_CONTROL_REG_USER 		= 0x5002;	
	
	public static final int IPC_SECURITY_ACL 				= 0x6001;	
	public static final int IPC_SECURITY_GEO_IP			= 0x6002;	
	
	public static final int IPC_SECURITY_POLICY_OVERVIEW					= 0x6011;	
	public static final int IPC_SECURITY_POLICY_UAGENT						= 0x6012;	
	public static final int IPC_SECURITY_POLICY_GEOIP							= 0x6013;	
	public static final int IPC_SECURITY_POLICY_CALL_PATTERN				= 0x6014;	
	public static final int IPC_SECURITY_POLICY_CALL_OVERSEAS			= 0x6015;	
	public static final int IPC_SECURITY_POLICY_CALL_OVERSEAS_USER	= 0x6016;	
	public static final int IPC_SECURITY_POLICY_CALL_GAPPING			= 0x6017;	
	public static final int IPC_SECURITY_POLICY_IM_SIGNATURE_HDR	= 0x6018;	
	public static final int IPC_SECURITY_POLICY_IM_SIGNATURE_VAL		= 0x6019;	
	
	public static final int IPC_SECURITY_SPAM_OVERVIEW	= 0x6021;	
	public static final int IPC_SECURITY_SPAM_CALL			= 0x6022;	
	public static final int IPC_SECURITY_SPAM_IM				= 0x6023;	
	
	public static final int IPC_ADVANCED_SIP_STACK 		= 0x7001;	
	public static final int IPC_ADVANCED_SIP_TIMER 		= 0x7002;	
	public static final int IPC_ADVANCED_SIP_SERVICE 	= 0x7003;	
	public static final int IPC_ADVANCED_SIP_LOG 		= 0x7004;	
	public static final int IPC_ADVANCED_SIP_CERT 		= 0x7005;
	public static final int IPC_ADVANCED_SIP_CERT_CHECK 		= 0x7006;	
	
	
	/*
	 * User Status
	 */
	public static final short USER_STATUS_LOGOUT 							= 0;
	public static final short USER_STATUS_LOGIN 								= 1;
	public static final short USER_STATUS_SCREEN_LOCK 					= 2;
	public static final short USER_STATUS_TEMP_BLOCKED_BY_LIMIT	= 3;
	public static final short USER_STATUS_FORCED_BLOCKED 			= 4;
	
	
	/*
	 * Command histroy
	 */
	public static final short HISTORY_LOGIN 									= 	1;
	public static final short HISTORY_LOGOUT								= 	2;
	public static final short HISTORY_TEMP_BLOCKED					= 	3;
	public static final short HISTORY_FORCED_BLOCKED 				= 	4;
	public static final short HISTORY_RELEASE_FORCED_BLOCKED = 	5;
	public static final short HISTORY_COMMAND 							= 	6;

	
}
