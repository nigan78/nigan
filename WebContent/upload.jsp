<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.User" %>
    <%
    User user = (User)session.getAttribute("user");
    String id = user.getId();
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
        input { float:left; margin:10px; }
	<style>
        #main_header {
		margin:20px;
		text-align: center;
		}
    </style>
    <style>
        #content {
            margin: 0 auto;
            overflow: auto;
        }
        #content > #main_section {
            text-align: center;
        }
    </style>
    <style>
        #main_section > article.main_article {
		height: 225px;
		width: 400px;
		margin: 0 auto;
            margin-bottom: 10px;
            padding: 20px;
            border: 1px solid #333;
        }
    </style>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
<header id="main_header">
<div class="container-fluid">
  <a href="download"><img src="./images/새로고침.png" alt="Home" style="width:100px"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;환영합니다. <%=id %>님&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-danger" onclick="action='logout'">Log Out</button>
</div>
</header>
    <div id="content">
        <section id="main_section">
            <article class="main_article">
                <h1>File Upload</h1><br><input type="file" name="fileName">
                <input type="submit" value="Upload" style="height:40px; width:80px;">
            </article>
        </section>
    </div>
	</form>
</body>
</html>