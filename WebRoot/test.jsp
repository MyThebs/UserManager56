<%@ page language="java" import="java.util.Date" contentType="text/html;charset=utf-8"
         pageEncoding="utf-8" errorPage="error.jsp"
%>

<%@ include file="/sub/haha.jsp" %>

<jsp:include page="/WEB-INF/hehe.jsp"></jsp:include>

<jsp:forward page="login_bigdata.html"></jsp:forward>

<html>
<%!
   int m = 5;
   int fun(int a){
       return a * 4;
   }
%>
<head>Page Head</head>
<br>
<%
    int i = 9;
    i++;
    m++;
    out.println(i);
    out.println(m);
    out.println(fun(m));
    Date d = new Date();
    out.println(d);
    int[] arr = new int[5];
    //arr[5] = 6;
%>
<%=3*4%>
<br>
<body> This is my 1st JSP page;</body>
</html>