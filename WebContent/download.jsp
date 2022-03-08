<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.User" %>
    <%@page import="vo.File" %>
    <%
    User user = (User)session.getAttribute("user");
    String id = user.getId();
    String[] list = new String[99];
    int k = 0;
    for(int i = 0; i < list.length; i++) {
    list[i] = (String)session.getAttribute("file"+i);
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
    </style>   
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
		height: auto;
		width:400px;
		margin: 0 auto;
            margin-bottom: 10px;
            padding: 20px;
            border: 1px solid #333;
        }
    </style>
</head>
<body>
<form action="Search">
<header id="main_header">
<div class="container-fluid">
  <!--javascript:location.reload() -->
  <button type="submit" class="btn btn-default" style="display:none"><span class="glyphicon glyphicon-search"></span></button>
  <a href="refresh"><img src="./images/새로고침.png" alt="Home" style="width:100px"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;환영합니다. <%=id %>님&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-default" onclick="action='upload'"><!--"location='upload.jsp'"-->Upload</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-danger" onclick="action='logout'">Log Out</button>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="search" name="search" size="30" style="height:30px; margin-top:10px;" autofocus="autofocus">
  &nbsp;<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
    
</div>
</header>
    <div id="content">
        <section id="main_section">
            <article class="main_article">
                <h1>File List</h1><br><br><br>
                <%for(int i = 0; i < clearnArray.length; i++) {%><a href="fileDown?fileName=<%= clearnArray[i]%>"> <%= clearnArray[i]%> <br><br><br><br></a> <%} %>
            </article>
        </section>
    </div>
	</form>
</body>
</html>