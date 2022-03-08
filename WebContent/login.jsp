<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chapter_5</title>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <!-- 초기화 -->
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
		td{padding-left:10px;}
    </style>   
	<style>
        #main_header {
		margin:20px;
		text-align: center;
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
<form action="login" method="post">
<header id="main_header">
<div class="container-fluid">
  <a href="home"><img src="./images/메인.png" alt="Login" style="width:30%"></a>
  <br>
  </div>
</header>
        <section id="main_section">
            <article class="main_article">
			<table>
			<tr><td>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아 이 디 : &nbsp;&nbsp;<input type="text" name="id" required maxlength="15" autofocus="autofocus"><br></p></td><td rowspan="2"><input type="submit" value="Login" style="height:40px; width:80px;"></td></tr>
				<tr><td><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 : <input type="password" name="pass" required maxlength="15"><br></p></td></tr>
				</table>
				<p><a href="findid">ID찾기</a> | <a href="findpw">PW찾기</a> | <a href="register">회원가입</a> | <a href="withdraw">회원탈퇴</a></p>
            </article>
        </section>
	</form>
</body>
</html>