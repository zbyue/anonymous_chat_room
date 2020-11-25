
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%-- 向客户端浏览器输出messages内容--%>
<% out.println(request.getAttribute("messages").toString()); %>
