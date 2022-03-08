<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="svc.MemBiz"%>
    <%
    MemBiz memBiz = new MemBiz();
	String[] allID = memBiz.allID();
	for(int i = 0; i < allID.length; i++){ 
		session.setAttribute("ID"+i, allID[i]);
		}
    String[] list = allID;
    int k = 0;
    for(int i = 0; i < list.length; i++) {
    list[i] = (String)session.getAttribute("ID"+i);
    if(list[i]==null) {
    }
    else {
        k = k+1;
    }
    }
    String[] clearnArray = new String[k];
    for(int s = 0; s<k; s++) {
        clearnArray[s] = list[s];
    }
    %>
<!DOCTYPE html>
<html>
<head>
    <title>Chapter_5</title>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Coiny" rel="stylesheet" type="text/css" />
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
    <style>
        * { margin: 0; padding: 0; }
        body { font-family: 'Times New Roman', serif; }
        a { text-decoration: none; }
        img { border: 0; }
		#right{text-align:right;}
		#right input{padding:5px;}
		#px{font-size:40px;}
    </style>   
	<style>
        #main_header {
		margin:20px;
		text-align: left;
		}
    </style>
    <style>
	#main_section {
            text-align: center;
        }
    </style>
    <style>
        #main_section article {
		height: auto;
		width:400px;
		margin: 0 auto;
            margin-bottom: 10px;
			box-sizing: border-box;
            padding: 20px;
            border: 1px solid #333;
        }
    </style>
</head>
<body>
<form action="reg" method="post">
<header id="main_header">
<div class="container-fluid">
  <a href="home"><img src="./images/Home.PNG" alt="Login" style="width:100px"></a>
  <br>
  </div>
</header>
        <section id="main_section">
            <article class="main_article">
			<span id="px">회원 가입</span><br><br>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아 이 디 : &nbsp;&nbsp;<input type="text" name="id" required maxlength="15" autofocus="autofocus"><br></p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 : <input type="password" name="pass" required maxlength="15"><br></p>
				<p>전화번호 : &nbsp;&nbsp;<input type="tel" name="tel1" required maxlength="3" style="width:36px;">
				- <input type="tel" name="tel2" required maxlength="4" style="width:48px;">
				- <input type="tel" name="tel3" required maxlength="4" style="width:48px;"><br></p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;별 명 : &nbsp;&nbsp;<input type="text" name="nickname" required maxlength="15"><br></p>
				<p id="right"><input type="submit" value="Submit">&nbsp;&nbsp;<input type="reset" value="Reset"></p>
				<p>이미 가입된 ID명 : &nbsp;&nbsp;<%for(int i = 0; i < clearnArray.length; i++) {%><%= clearnArray[i]%>,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%} %></p>
            </article>
        </section>
	</form>
</body>
</html>