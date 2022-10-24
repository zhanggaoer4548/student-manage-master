<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>/css/main.css">

<style>
        img {
            width: 200px;
        
        }

        .imgBox {
            position: relative;
        }

        .imgText{
            display: block;
            width: 50px;
            height: 100px;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -25px;
            margin-top: -20px;
        }

        .sidebar{
          margin-top: -1px;
          background-color: gray;
        }

        .nav-sidebar a{
          color: black;
          font-size: 20px;
          font-weight: bold;
      
          background-color: gray;
        }

    

</style>