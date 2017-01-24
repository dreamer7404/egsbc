var responsiveHelper_datatable_col_reorder = undefined;
var breakpointDefinition = {
		tablet : 1024,
		phone : 480
	};

var sDom = "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-6 hidden-xs'CT>r>"+
	"t"+
	"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'><'col-sm-6 col-xs-12'>>";
var sDomNoControl =  "<'dt-toolbar'<'col-xs-12 col-sm-6'><'col-sm-6 col-xs-6 hidden-xs'>>"+
	"t"+
		"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'><'col-sm-6 col-xs-12'>>";
	
var oLanguage = { 
		"sSearch": '<span class="input-group-addon"><i class="fa fa-search"></i></span>',
		//"sEmptyTable": "데이타 없음"
};	
var sSwfPath = "/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf";
var tableTools =  {
	 "sSwfPath": "/resources/js/plugin/datatables/swf/copy_csv_xls_pdf.swf",
	 "aButtons": [
             "xls",
                {
                    "sExtends": "pdf",
                    "sTitle": "SmartAdmin_PDF",
                    "sPdfMessage": "SmartAdmin PDF Export",
                    "sPdfSize": "letter"
                }
     ],
 };	

function getSide(val){
	if(val==0) return "<span style='color:#A20000'>A</span>";
	else if (val==1) return "<span style='color:#0000A0'>B</span>";
	else if (val==2) return "<span style='color:#008040'>Both</span>";
	else return "";
}

function getSideValue(val){
	if(val==0) return "A";
	else if (val==1) return "B";
	else if (val==2) return "Both";
	else return "";
}

function getIpMode(val){
	if(val==0) return 'STATIC';
	else if(val==1) return 'DHCP';
	else return "";
}
function getIpType(val){
	if(val==0) return "IPv4"
	else if (val==1) return "IPv6"
	else return "";
}
function getIntfUsageVoIP(val){
	if(val==1 || val==3) return '<i class="fa fa-phone"></i>';
    else return "";
}
function getIntfUsageNat(val){
	if(val==2 || val==3) return '<i class="fa fa-exchange"></i>';
    else return "";
}
function getIntfType(val){
	if(val==0) return 'MGMT';
	else if(val==1) return 'SERVICE';
	else return "";
}
function getLrside(val){
	if(val==1) return 'inside';
	else if(val==2) return 'outside';
	else return "";
}

function getVipName(val){
//	if(val==0) return "Server";
//	else if(val==1) return "Realm";
	if(val==0) return "Server/Realm";
	else if(val==1) return "Trunk";
	else return "";
}
function getTransType(val){
	if(val==1) return "udp";
	else if(val==2) return "tcp";
	else if(val==3) return "tls";
	else return "";
}
function getQosType(val){
	if(val==0) return "none";
	else if(val==1) return "ippre";
	else if(val==2) return "dscp";
	else return "";
}

function getProtocol(val){
	if(val=="0") return "udp";
	else if(val==1) return "tcp";
	else if(val==3) return "all";
	else return "";
}

function getRuleType(val){
	if(val==0) return "Static";
	else if(val==1) return "Domain";
	else if(val==2) return "Prefix";
	else return "";
}
function getReverseFlag(val){
	if(val==0) return "off";
	else if(val==1) return "on";
	else return "";
}
function getReferField(val){
	if(val==0) return "To/RURI";
	else if(val==1) return "from";
	else return "";
}


function getCheck(val){
	if(val==0) return '';
	else if(val==1) return  '<i class="fa fa-check"></i>';
	else return "";
}
function getOnOff(val){
	if(val==0) return "off";
	else if(val==1) return "on";
	else return "";
}


function getServerIPType(val){
	if(val==0) return "IPv4";
	else if(val==1) return  "IPv6";
	else return "";
}

function getSrtpFlag(val){
	if(val==1) return "RTP";
	else if(val==2) return  "SRTP";
	else if(val==3) return  "ALL";
	else return "";
	
}

function getMode(val){
	if(val==0) return "Server/Realm";
	else if(val==1) return "Trunking";
	else return "";
}

function getOpMode(val){
	if(val==0) return "ACTIVE/STANDBY";
	else if(val==1) return "RR";
	else if(val==2) return "SINGLE";
	else return "";
}
function getPollFlag(val){
	if(val==1) return '<i class="fa fa-check"></i>';
	else return "";
}

function getMediaPassFlag(val){
    if(val==0){
    	return "off"
    }else if (val==1){
    	return "on"
    }else{
		return "";
	}
}
function getDatetime(data){
	return (data.length > 19)? data.substring(0,19) : data;
}

function getAlarmLevel(value){
	if (value==0) return "separately defined";
	else if(value==1) return "info";
	else if(value==2) return "minor";
	else if(value==3) return "major";
	else if(value==4) return "critical";
	else if(value==5) return "variable";
	else return "";
}

Number.prototype.formatComma = function(){
    if(this==0) return 0;
    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');
    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');
    return n;
};
 
String.prototype.formatComma = function(){
    var num = parseFloat(this);
    if( isNaN(num) ) return "0";
    return num.format();
};
