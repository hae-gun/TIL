## 웹 표준

* 웹표준을 지키지 않은 HTML

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웹 표준을 지키지 않은 문서</title>
	</head>
	<body>
	
		<p>
			<i>이탤릭체</i><br>
			<em>i tag 보다 em tag권장</em><br> 
			<strong> b tag 보단 strong tag 권장</strong> <br><br><br>
			이제 <b><font size = "4" color="red">웹표준</font></b>의 <strong>역할</strong>은 
			아주 <b><font size = "4" color="red">중요</font></b>합니다.
			디자인은 디자자인으로.
		</p>
	
	
	</body>
</html>
```

* 웹표준을 지킨 HTML

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웹 표준을 지킨 문서</title>
		<style type="text/css">
			
			.accent{
				font-size: 20px;
				color: #1a1aff;
				font-weight: bold;
			}
			
			body,p { /* 다중지정 */
				background-color: #ffffb3;
			}
			
			h1{
				color: purple;
			}
			
			h1.blue{
				color: blue;
			}
			
			h2.blue{
				color: #009933;
				font-style: italic;
					}
					
			h2#aa {
				/* margin: 100px 200px 400px 30%; /*  top right bottom left 순서로 margin줌 2개 쓰면 t,b >100px l,r> 50px */ 
				margin-bottom: 100px;
				margin-top: 30px;
				color: #808000; 우선순위 /* id > class > 선택자 */
			}
		</style>	
	<!-- class 이름 : . clasName{	속성: 값; 속성2: 값; .........	} 다중
						#idName{	속성: 값; 속성2: 값; .........	} 고유한 특징 제어
	-->
	</head>
	<body> <!-- 선택자 -->
		<h1>선택자 다중 지정 연습</h1>
		<h1 class="blue">선택자 다중 지정 연습2</h1>
		<h1>선택자 다중 지정 연습3</h1>
		<h2 class="blue">선택자 다중 지정 연습3</h2>
		<h3>선택자 다중 지정 연습3</h3>
		<h2 class="blue" id="aa">선택자 다중 지정 연습3</h2>
		<h1>선택자 다중 지정 연습3</h1>
		<p>
			이제 <span class="accent">웹표준</span>의 역할은 아주 <span class="accent">중요</span>합니다.
			span은 제어용. class name 이용.
		</p>
		
	</body>
</html>
```

> Style은 따로 나눠 id, class를 주어 표시.

# CSS

## 우선순위

> id > class > 선택자.

* margin 이 겹칠때는 가장 큰 margin으로 적용

### Inline 방식

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CSS</title>
		<style type="text/css">
		
			/* inline 방식 */
			.navi{ 
				background: #ffffb3;
				margin-top: 30px;
				width: 500px;
				height: 60px;
			}	
			
			.navi ul{
				list-style: none;
				height: 40px;
				padding-top: 10px;
				padding-bottom: 5px;
			}
			
			.navi ul li {
				float: left;
				font-size: 15px;
				margin-left: 20px;
			}
			
			a{
				text-decoration: none;
			}
			
			
			
			
		</style>
	
	</head>
	<body>
```

> head 안에서 style tag를 이용하여 설정.

### Outline 방식

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CSS</title>
		<link rel="stylesheet" href="../../css/Test.css" type="text/css" > <!-- text/css 순서중요 -->
	</head>
	<body>
		<nav class="navi">
			<ul>
				<li><a href="#">애완견종류</a></li>
				<li><a href="#">입양하기</a></li>
				<li><a href="#">건강돌보기</a></li>
				<li><a href="#">더불어살기</a></li>
			</ul>
		</nav>
	</body>
</html>
```

```css
@charset "UTF-8";


body {
	
	background-color: pink;
}
.navi {
	background: yellow;
	margin-top: 30px;
	width: 960px;
	height: 100px;
}

.navi ul {
	list-style: none;
	height: 40px;
	padding-top: 10;
	padding-bottom: 5px;
}

.navi ul li {
	float: left;
	font-size: 15px;
	margin-left: 20px;
}

a {
	text-decoration: none;
}


```

> css파일을 따로 분리하여 head 안에서 link tag를 이용한다.
>
> <link rel="stylesheet" href="css파일위치" type="text/css" >





* a tag안에서 mailto:메일주소 사용하면 메일보내기 가능.

tag에 on으로 시작되는 것들 : 이벤트처리.