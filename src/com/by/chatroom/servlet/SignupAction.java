package com.by.chatroom.servlet;

import com.by.chatroom.dao.AccessDB;
import com.by.chatroom.user.UserInfoBean;
import com.by.chatroom.user.UserInfoManager;
import com.by.chatroom.user.UserSessionHandler;
import com.by.chatroom.utils.BusinessUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

@WebServlet("/SignupAction")
public class SignupAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = new String(req.getParameter("username").getBytes("ISO-8859-1"), "utf-8");
        String password = req.getParameter("password").toString();
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(600); //设置Session的过期时间为10分钟
        resp.setContentType("text/html;charset=UTF-8"); //设置返回格式和编码  设置utf-8后能正确显示中文

        try{
            String id = AccessDB.signup(username, password);
            if(id.equals("")){
                PrintWriter out = resp.getWriter();
                out.println("<script>alert('注冊失败！');" +
                        "window.location.href='index.jsp'</script>");
            }else{
                PrintWriter out = resp.getWriter();
                out.println("<script>alert('注冊成功！ 您的身份码为："+id+"  请使用身份码和密码登陆');" +
                        "window.location.href='index.jsp'</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
