package com.by.chatroom.dao;

//STEP 1. Import required packages
import java.sql.*;

public class AccessDB {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    public static String checkUser(String id, String pwd){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement... id: "+id);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nick_name, pwd, create_time FROM user WHERE id = "+id;
            ResultSet rs = stmt.executeQuery(sql);

            String nickname = "";
            String password = "";
            while(rs.next()){
                nickname = rs.getString("nick_name");
                password = rs.getString("pwd");
                break;
            }
            System.out.println("check user ...");
            if(password.equals(pwd)) {
                System.out.println("nickname: "+nickname);
                return nickname;
            }
            else{
                System.out.println("check failed: pwd"+pwd);
                return "";
            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return "";
    }

    public static String signup(String nickname, String pwd){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement... nickname: "+nickname);
            stmt = conn.createStatement();
            String sql;
            sql = "insert into user (nick_name, pwd)  values (\'"+nickname+"\',\'"+pwd+"\');";
            stmt.executeUpdate(sql);

            System.out.println("insert user ...");


        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        conn = null;
        stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement... nickname: "+nickname);
            stmt = conn.createStatement();
            String sql;
            sql = "select id from user where nick_name = \'"+nickname+"\' and pwd = \'"+pwd+"\';";
            ResultSet rs = stmt.executeQuery(sql);

            String id = "";
            while(rs.next()){
                id = rs.getString("id");
            }
            System.out.println("query new user id:"+id);
            return id;

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return "";
    }

/*
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String nickname = "zz";
        String pwd = "2333";
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "insert into user (nick_name, pwd)  values (\'"+nickname+"\',\'"+pwd+"\');";
            stmt.executeUpdate(sql);


            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                //int id  = rs.getInt("id");
                String age = rs.getString("nick_name");
                String first = rs.getString("pwd");
                String last = rs.getString("create_time");

                //Display values
                //System.out.print("ID: " + id);
                System.out.print(", nickname: " + age);
                System.out.print(", pwd: " + first);
                System.out.println(", create time: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        conn = null;
        stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement... nickname: "+nickname);
            stmt = conn.createStatement();
            String sql;
            sql = "select id from user where nick_name = \'"+nickname+"\' and pwd = \'"+pwd+"\';";
            ResultSet rs = stmt.executeQuery(sql);

            String id = "";
            while(rs.next()){
                id = rs.getString("id");
            }
            System.out.println("query new user id :"+id);

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main*/
}//end