<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="com.by.chatroom.user.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Vector<UserInfoBean> vector = UserInfoManager.getInstance().getList();
    int amount = 0; //在线人数
%>
<meta charset="utf-8">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td height="32" align="center"><font color="#f0f0ff">匿名聊天室</font></td>
    </tr>
    <%
        if (vector != null && vector.size() > 0) {
            String username = "";
            amount = vector.size();
    %>
    <tr>
        <td height="30" align="center"><font color="#f0f0ff">当前在线[</font><font color="#FF5722"><%=amount%>
        </font><font color="#f0f0ff">]人</font>
        </td>
    </tr>
    <tr>
        <!-- href="#" 链接到当前页面 如果去掉的话，链接的onclick会失效的-->
        <td height="23" align="center"><a href="#" onClick="setChatObject('所有人');"><font color="#f0f0ff">所有人</font></a></td>
    </tr>
    <%
            for (int i = 0; i < amount; i++) {
                username = vector.elementAt(i).username;
    %>
    <tr>
        <td height="23" align="center"><a href="#" onclick="setChatObject('<%=username%>')"><font color="#f0f0ff"><%=username%></font>
        </a></td>
    </tr>
    <%
            }
        }
    %>
</table>