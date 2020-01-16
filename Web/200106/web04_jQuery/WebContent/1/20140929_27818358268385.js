//濡쒓렇�� �뺣낫 �섍린湲�
function fn_vil(url){
	var decID = '${loginVO.id}';
	var name = '${loginVO.name}';
	var email = '${loginVO.email}';
	var loginKind = '${loginVO.loginKind}';

	var loginForm = document.createElement("form");
	loginForm.setAttribute("method", "post");
	loginForm.setAttribute("name", "loginForm");
	loginForm.setAttribute("action",url);
	loginForm.setAttribute("target","_blank");
	document.body.appendChild(loginForm); 

	var decIDField = document.createElement("input");
	decIDField.setAttribute("type","hidden");
	decIDField.setAttribute("name","decID");
	decIDField.setAttribute("id","decID");
	decIDField.setAttribute("value",decID);
	loginForm.appendChild(decIDField);

	var nameField = document.createElement("input");
	nameField.setAttribute("type","hidden");
	nameField.setAttribute("name","name");
	nameField.setAttribute("value",name);
	loginForm.appendChild(nameField);

	var emailField = document.createElement("input");
	emailField.setAttribute("type","hidden");
	emailField.setAttribute("name","email");
	emailField.setAttribute("value",email);
	loginForm.appendChild(emailField);

	var loginKindField = document.createElement("input");
	loginKindField.setAttribute("type","hidden");
	loginKindField.setAttribute("name","loginKind");
	loginKindField.setAttribute("value",loginKind);
	loginForm.appendChild(loginKindField);

	loginForm.submit();  
 }
// 濡쒓렇�몄젙蹂� �섍린湲� end

//濡쒓렇�� �뺣낫 �섍린湲� ( �덉갹 )
function fn_vil1(url){
        
	var decID = '${loginVO.id}';
	var name = '${loginVO.name}';
	var email = '${loginVO.email}';
	var loginKind = '${loginVO.loginKind}';

	var loginForm1 = document.createElement("form");
	loginForm.setAttribute("method", "post");
	loginForm.setAttribute("name", "loginForm");
	loginForm.setAttribute("action","");
	loginForm.setAttribute("target","new");
	document.body.appendChild(loginForm); 

	var decIDField = document.createElement("input");
	decIDField.setAttribute("type","hidden");
	decIDField.setAttribute("name","decID");
	decIDField.setAttribute("id","decID");
	decIDField.setAttribute("value",decID);
	loginForm.appendChild(decIDField);

	var nameField = document.createElement("input");
	nameField.setAttribute("type","hidden");
	nameField.setAttribute("name","name");
	nameField.setAttribute("value",name);
	loginForm.appendChild(nameField);

	var emailField = document.createElement("input");
	emailField.setAttribute("type","hidden");
	emailField.setAttribute("name","email");
	emailField.setAttribute("value",email);
	loginForm.appendChild(emailField);

	var loginKindField = document.createElement("input");
	loginKindField.setAttribute("type","hidden");
	loginKindField.setAttribute("name","loginKind");
	loginKindField.setAttribute("value",loginKind);
	loginForm.appendChild(loginKindField);

	loginForm1.submit();  

        window.open(url, "new");
 }
// 濡쒓렇�몄젙蹂� �섍린湲� ( �덉갹 ) end

//濡쒓렇�� �뺣낫 �섍린湲�
function fn_vil_login(url){
   var decID = "";
   var name = "";
   var email = "";
   var loginKind = "";

   if( '${loginVO.id}'  != '' && '${loginVO.name}' !=''){
		decID = '${loginVO.id}';
		name = '${loginVO.name}';
		email = '${loginVO.email}';
		loginKind = '${loginVO.loginKind}';

        /*
        decID = decID.replace("loginVO.id}","").replace("${","");
        name = name .replace("loginVO.name}","").replace("${","");
        email = email.replace("loginVO.email}","").replace("${","");
        loginKind = loginKind  .replace("loginVO.loginKind}","").replace("${","");
        */
	}

	var loginForm = document.createElement("form");
	loginForm.setAttribute("method", "post");
	loginForm.setAttribute("name", "loginForm");
	loginForm.setAttribute("action",url);
	loginForm.setAttribute("target","_blank");
	document.body.appendChild(loginForm); 

	var decIDField = document.createElement("input");
	decIDField.setAttribute("type","hidden");
	decIDField.setAttribute("name","decID");
	decIDField.setAttribute("id","decID");
	decIDField.setAttribute("value",decID);
	loginForm.appendChild(decIDField);

	var nameField = document.createElement("input");
	nameField.setAttribute("type","hidden");
	nameField.setAttribute("name","name");
	nameField.setAttribute("value",name);
	loginForm.appendChild(nameField);

	var emailField = document.createElement("input");
	emailField.setAttribute("type","hidden");
	emailField.setAttribute("name","email");
	emailField.setAttribute("value",email);
	loginForm.appendChild(emailField);

	var loginKindField = document.createElement("input");
	loginKindField.setAttribute("type","hidden");
	loginKindField.setAttribute("name","loginKind");
	loginKindField.setAttribute("value",loginKind);
	loginForm.appendChild(loginKindField);

	loginForm.submit();
}

function fn_vil2(url,target){
	if(target == '_blank'){
		window.open(url);
	}else{
		document.location.href = url;
	}
}


$(document).ready(function() {
    /**
	* 寃뚯떆�� 諛붾줈 媛�湲�
    */
    $(".board > a").click(function(){ 
        var url=$("section.mainContents > .board > menu > li > .on").attr("data-value");
        location.href=url;
    });

    $(".board1 > a").click(function(){ 
        var url=$("section.mainContents > .board1 > menu > li > .on").attr("data-value");
        location.href=url;
    });


});

/**
	* 湲곗긽泥� �좎뵪 媛��몄삤湲�, �좎쭨 �붿씪 泥섎━
	* x: gridx 媛�
	* y: gridy 媛�
	* 醫뚰몴媛� �뺤씤 - http://web.kma.go.kr/weather/lifenindustry/sevice_rss.jsp 
*/

var arr = [ "留묒쓬", "援щ쫫議곌툑", "援щ쫫留롮쓬", "�먮┝", "�뚮굹湲�", "鍮�", "媛��붾퉬", "�쒕븣鍮�", "��", "媛��붾늿", "�쒕븣��", "鍮꾨삉�붾늿", "媛��붾퉬�먮뒗��", "�쒕븣鍮꾨삉�붾늿", "�덈삉�붾퉬", "媛��붾늿�먮뒗鍮�", "�쒕븣�덈삉�붾퉬", "泥쒕뫁踰덇컻", "�곕Т", "�덇컻", "諛뺣Т", "�⑹궗" ];

function getWeather(x,y){
	$.ajax({
		  type : "POST"
		, data : {
			"x" : x, "y" : y
		}
		, url : "/weather.html"
		, success : function(data){
				var result = data;
				//console.log(result);
				var text,id,img;
				var path="./image/common/icon/";
				
				for(var i=0;i<result.length;i++){
					
					text = result[i].wfKor.replace(/ /g, '');                
	                id=jQuery.inArray(text, arr)+1;	                
	                if(id<10){
	                	if(id<4&&result[i].hour>17){
	                		img=path+"nb0"+id+"_n.png";
	                	}else{
	                		img=path+"nb0"+id+".png";
	                	}                	
	                }else{
	                	img=img+"nb"+id+".png";
	                }
					//console.log(i,img);
	                
					if(i==0){
						$("#weather0").text(result[i].temp+"C");
						$("#weather00").text(result[i].temp+"C");
						$("#weather1").attr('src',img);
						$("#weather1").attr('alt',result[i].wfKor);
		                $("#weather2").text(result[i].wfKor);
						
					}else if(result[i].day==1 && result[i].hour==12){
						//console.log(i,text);
						$("#weather3").attr('src',img);
						$("#weather3").attr('alt',result[i].wfKor);
						$("#weather4").text(result[i].wfKor);
					}else if(result[i].day==2 && result[i].hour==12){
						//console.log(i,text);
						$("#weather5").attr('src',img);
						$("#weather5").attr('alt',result[i].wfKor);
						$("#weather6").text(result[i].wfKor);
					}
				}
                
			}
		 , error : function(data, status, err){
			//alert("�쒕쾭���� �듭떊�� �ㅽ뙣�덉뒿�덈떎.");
			return;
		} 
	});

	// �좎쭨 �붿씪 泥섎━
	var dt = new Date();
	var temp = dt.getDate();
	var arr2 = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
	var month = dt.getMonth()+1;

	if(month<10) month="0"+month;
	var day = dt.getDate();

	if(day<10) day="0"+day;
	var week = arr2[dt.getDay()];
	dt.setDate(temp+1);

	var month2 = dt.getMonth()+1;
	if(month2<10) month2="0"+month2;
	var day2 = dt.getDate();

	if(day2<10) day2="0"+day2;
	var week2 = arr2[dt.getDay()];
	dt.setDate(temp+2);
	var month3 = dt.getMonth()+1;

	if(month3<10) month3="0"+month3;
	var day3 = dt.getDate();

	if(day3<10) day3="0"+day3;
	var week3 = arr2[dt.getDay()];
	var txt=month + '. ' + day + '. ' + week;
	var txt2=month2 + '. ' + day2 + '. ' + week2;
	var txt3=month3 + '. ' + day3 + '. ' + week3;

	$("#txt").text(txt);
	$("#txt2").text(txt2);
	$("#txt3").text(txt3);

	/**
	*  �명꽣 臾멸뎄 �ㅼ젙
	*/
	var footer="";
	var br="<br>";
	var ft1=$("#ft1").val();
	var ft2=$("#ft2").val();
	var ft3=$("#ft3").val();
	var ft4=$("#ft4").val();
	var ft5=$("#ft5").val();
	var ft6=$("#ft6").val();

	if(ft1!=""){
	 footer=footer+ft1+br;
	}
	if(ft2!=""){
	 footer=footer+ft2+br;
	}
	footer=footer+ft3;
	/* footer 異붽� �곸뿭*/

/**	if(ft3!=""){
	 footer=footer+ft3+br;
	}
	if(ft4!=""){
	 footer=footer+ft4+br;
	}
	if(ft5!=""){
	 footer=footer+ft5+br;
	}
	 footer=footer+ft6;
*/
	$("footer p").html(footer);
}

/**
* �쇰컲 濡쒓렇��
*/

function fn_login(){	
	var idVal = $("#id").val();
	var pwVal = $("#pw").val();
/*	
    if (idVal =="") {
        alert("�꾩씠�붾� �낅젰�섏꽭��");
        return false;
    } else if (pwVal =="") {
        alert("鍮꾨�踰덊샇瑜� �낅젰�섏꽭��");
        return false;
    }
*/	


		$("#tmpLoginForm").remove();
		$("#tmpLoginFrame").remove();

		//var invilLoginUrl = "https://www.invil.com/front/uat/uia/vilLogin.do";
		var invilLoginUrl = "http://cms.invil.org/uat/uia/frontLogin.do";
		$("body").append("<form id='tmpLoginForm' action='" + invilLoginUrl  + "' method='post' target='tmpLoginFrame'><input type='hidden' name='id' value='" + idVal + "' /><input type='hidden' name='password' value='" + pwVal + "' /><input type='hidden' name='loginKind' value='gen' /></form>");
		$("body").append("<iframe id='tmpLoginFrame' name='tmpLoginFrame' style='display:none;' ></iframe>");

		$("#tmpLoginForm").submit();

/*
		$.ajax({
			  type : "POST"
			, data : {
				"idVal" : idVal, 
				"pwVal" : pwVal,
				"loginKind" : ""
			}
			, url : "/frontLogin.html"
			, success : function(data){
					var result = data;			
					if(result.confirm=="success"){
						location.reload();
					}else{
						alert("濡쒓렇�� �뺣낫媛� ���몄뒿�덈떎.");
					}
		      
			}
			 , error : function(data, status, err){
				//alert("�쒕쾭���� �듭떊�� �ㅽ뙣�덉뒿�덈떎.");
				return;
			} 
		});
*/
}
document.domain = "invil.org"; 

function fn_usrLogin(){
//    queryString = "<%=request.getQueryString()%>";
	callBack = document.loginForm.callBack.value; 
/*	if (callBack == ""){
		callBack = window.location.pathname+"?"+queryString;
	} */
	document.loginForm.callBack.value = callBack;
	 
	w = 465;
	h = 627;
	LeftPosition=(screen.width-w)/2;
	TopPosition=(screen.height-h)/2;
	
	window.open('', "loginPop",  "width="+w+",height="+h+",top="+TopPosition+",left="+LeftPosition+", scrollbars=no");	
	document.loginForm.target = "loginPop";	
	document.loginForm.method = "post";
	document.loginForm.action = "http://cms.invil.org/uat/uia/egovLoginUsr.do";
	document.loginForm.submit();
	//window.open("<c:url value='/uat/uia/egovLoginUsr.do' />",  "loginPop",  "width="+w+",height="+h+",top="+TopPosition+",left="+LeftPosition+", scrollbars=no");
}

function fn_href(n){
	var url = "";
	var target = "";

	switch(n){
		case 1: // 留덉씠�몃퉴
                        fn_vil('https://www.invil.com/front/myinvil/idx/listMyvIdxSession.do');
			//fn_vil2('http://www.invil.com/front/myinvil/idx/listMyvIdxSession.do','_blank');
		break;
		case 2:	//硫붿씪
			fn_vil('http://www.invil.com/front/csc/tiv/viewCscTiv.do');
			//fn_vil2("http://www.invil.com/front/csc/tiv/viewCscTiv.do",'_blank');
		break;
		case 3: // 怨좉컼�쇳꽣
			fn_vil('http://www.invil.com/front/csc/idx/listCscMain.do');
			//fn_vil2('http://www.invil.com/front/csc/idx/listCscMain.do','_blank');
		break;
		case 4: // ENGLISH
			//fn_vil('http://www.invil.org/english/action.do?url=/english/main');
			//fn_vil2("http://www.invil.org/english/action.do?url=/english/main",'blank');
		break;
		case 5: // �뺣낫�붾쭏�꾩궗�낆냼媛�
			fn_vil('http://www.invil.org/intro/info/introView.do');
			//fn_vil2('http://www.invil.org/intro/info/introView.do','blank');
		break;
		case 6: // 媛쒖씤�뺣낫泥섎━諛⑹묠
			fn_vil('http://www.invil.org/policy/policy.do?policyFlag=02');
			//fn_vil2('http://www.invil.org/policy/policy.do?policyFlag=02','blank');
		break;
		case 7: // �댁슜�쎄�
			fn_vil('http://www.invil.org/policy/policy.do');
			//fn_vil2('http://www.invil.org/policy/policy.do','blank');
		break;
		case 8: // 怨좉컼�쇳꽣
			fn_vil('http://www.invil.com/front/csc/idx/listCscMain.do');
			//fn_vil2('http://www.invil.com/front/csc/idx/listCscMain.do','blank');
		break;
		case 9: // 愿묎퀬�쒗쑕
			fn_vil('http://www.invil.com/front/csc/ptn/viewCscPtn.do');
			//fn_vil2('http://www.invil.com/front/csc/ptn/viewCscPtn.do','blank');
		break;
		case 10: // 愿�由ъ옄�먭쾶
			fn_vil('http://www.invil.com/front/csc/tiv/viewCscTiv.do');
			//fn_vil2('http://www.invil.com/front/csc/tiv/viewCscTiv.do','blank');
		break;
		case 11: // �몃퉴諛곗���
			fn_vil('http://www.invil.org/edu/eduMainList.do');
			//fn_vil2('http://www.invil.org/edu/eduMainList.do','blank');
		break;
		case 12: // 留덉쓣李얘린
			fn_vil('http://www.invil.org/map/InvilVillageSearchMain.do?tab_page=1');
			//fn_vil2('http://www.invil.org/map/InvilVillageSearchMain.do?tab_page=1','blank');
		break;
		case 13: // �뚯썝媛���
			fn_vil('http://www.invil.com/front/mbr/egovMbrUserJoin01.do');
			//fn_vil2("http://www.invil.com/front/mbr/egovMbrUserJoin01.do",'blank');
		break;
		case 14: // �꾩씠��/鍮꾨쾲李얘린
			//url = "http://www.invil.com/front/uat/uia/egovLoginUsr.do?callBackType=url&callBack=http://www.invil.com/front/mbr/egovMbrUserJoin01.do";
			var url_loginPop = "https://www.invil.com/front/uat/uia/egovLoginUsr.do";
			openWindow(url_loginPop+"?callBackType=url&callBack="+document.location.href, "", "loginPop", 465, 627, false);
			return;
		break;
		case 15: // �몃퉴�댁뒪
                        fn_vil('http://www.invil.org/news/main/mainList.do');
			//fn_vil2('http://www.invil.org/news/main/mainList.do','blank');
		break;
		case 16: // �붿긽�곷큺
			fn_vil('http://family.invil.org/');
			//fn_vil2("http://family.invil.org/",'blank');
		break;
		case 17: // �몃퉴�뱀쭊
			fn_vil('http://www.invil.org/webzine/webzineDetail.do');
			//fn_vil2('http://www.invil.org/webzine/webzineDetail.do','blank');
		break;
		case 18: // �몃퉴硫붿떊��
			fn_vil('http://www.invil.org/etc/msn.do');
			//fn_vil2('http://www.invil.org/etc/msn.do','blank');
		break;
		case 19: // �대깽��
			fn_vil('http://www.invil.org/event/eventList.do');
			//fn_vil2('http://www.invil.org','blank');
		break;
		case 20: //�ㅼ떆�붽만 留곹겕
			$.getScript('/js/20150107_7945087072947356.js', function(){
				maplink();
			});
		break;
		case 21: // �쇳븨紐�
			fn_vil('http://www.invil.com');
			//fn_vil2("http://www.invil.org/event/eventList.do",'blank');
		break;
		case 22: // 
			url ="";
		break;
		case 100:
			url="/index.html";
		break;
	}
	/*
	if(n==16 || n==13 || n==14 || n==4 || n==2){
	  window.open(url, "_blank");  
	}
	*/
}


//�듯빀寃���(web)
function fn_totalSearch() {	
	if ($("#query").val() == "") {
		alert("寃��됱뼱瑜� �낅젰�� 二쇱꽭��.");
		$("#query").focus();
	} else {
		document.topForm.target = "_blank";
		document.topForm.method = "post";
		document.topForm.action = "http://www.invil.org/search/TotSearchController.do";
	   	document.topForm.submit();
	   	
	   	$("#topquery").val("");
	}
}

/* �ъ씠�몃㏊*/
function fn_sitemap(val) {
	var sitemap = document.getElementById("sitemap");

	if (val == "on") {
		sitemap.style.display = "";
	}
	if (val == "off") {
		sitemap.style.display = "none";
	}
}

function openWindow(url, encData, winname, width, height, scroll) {	
	try {
        var winx = (screen.width - width ) / 2;
        var winy = (screen.height- height) / 2;
        var settings  = "height=    " +height+", ";
            settings += "width=     " +width +", ";
            settings += "top=       " +winy  +", ";
            settings += "left=      " +winx  +", ";
            settings += "scrollbars=" +scroll+", ";
            settings += "resizable =no";
        
        //EncLink(url, encData, winname, settings);
         var newWin = window.open(url, winname , settings);
         
         openWindowArray[openWindowArray.length] = newWin; //�덈룄�� �ㅽ뵂 媛앹껜 異붽�
         
         self.opener=self;
         
         //�앹뾽�섏씠吏�濡� focus �대룞
         if (window.focus) {
        	 newWin.focus();
         }
         
         if (!newWin.closed) {
        	 newWin.focus();
         }         
    }
    catch(e) {    	
    	//�ㅻ쪟 二쇱꽍 泥섎━..
        //e.addLocation("openWindow", "/dbcsc/cms/js/co/CmsWindow.js"); 
        //throw e;
    }
}
//�곷Ц�섏씠吏� ���됰컯�� �대깽��
function fn_change() {
     if($("#langSel").val() == "english") {
        fn_href(4);
    }
}

function isMobilechk(){

	var filter = "win16|win32|win64|mac|macintel";
	if( navigator.platform ){
		if( filter.indexOf(navigator.platform.toLowerCase())<0 ){
			return true;
		}else{
			return false;
		}
	}


}
