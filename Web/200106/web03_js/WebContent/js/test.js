document.writeln("javascript를 이용한 출력");
document.writeln("javascript는 \"대소문자\" 구분한다.<br>");
document.write("<font color='red'>javascript를 이용한 출력</font> ");
document.write("\\ \\ \\ \\");


function clib(){
		var name = document.getElementById("id").value;
		alert(name);
	}

function hello() {
	clib();
	alert(document.getElementById("id").value);
}

