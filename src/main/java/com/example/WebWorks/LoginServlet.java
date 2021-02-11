package com.example.WebWorks;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname= request.getParameter("uname");
        PrintWriter out= response.getWriter();
        String pass=request.getParameter("pass");
        try {
            Connection conn = DBconnect.getConn();
            PreparedStatement st = conn.prepareStatement("Select * from customerlogin where Username=? AND Password=?");
            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if(rs.getInt("AdminStatus")==0) {
                    HttpSession session = request.getSession();
                    int cusid = rs.getInt("cusid");
                    int platcode = rs.getInt("PlatformCode");
                    String platstr = String.valueOf(platcode);
                    int p1 = Integer.valueOf(platstr.charAt(0) + "");
                    int p2 = Integer.valueOf(platstr.charAt(1) + "");
                    int p3 = Integer.valueOf(platstr.charAt(2) + "");
                    session.setAttribute("plat", platcode);
                    session.setAttribute("p1", p1);
                    session.setAttribute("p2", p2);
                    session.setAttribute("p3", p3);
                    String cname = rs.getString("Name");
                    session.setAttribute("cusid", cusid);
                    session.setAttribute("name", cname);
                    st = conn.prepareStatement("select * from logfile where cusid=? and logid=(select max(logid) from logfile where cusid=?)");
                    st.setInt(1, cusid);
                    st.setInt(2, cusid);
                    ResultSet rs2 = st.executeQuery();
                    rs2.next();
                    session.setAttribute("date", rs2.getString("Date"));
                    st = conn.prepareStatement("insert into logfile values(0,?,?,?,0,?)");
                    st.setInt(1, cusid);
                    st.setString(2, cname);
                    st.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
                    st.setString(4, "Logged In!");
                    st.executeUpdate();
                    response.sendRedirect("dashboard.jsp");
                }
                else{

                    response.sendRedirect("admindashboard.jsp");
                }
                //RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
                //rd.forward(request, response);
            }
            else
            {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username not found Please Register');");
                out.println("location='login.jsp';");
                out.println("</script>");
//                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//                rd.forward(request, response);
            }
            conn.close();
        }
        catch(Exception ee)
        {

            RequestDispatcher rd= request.getRequestDispatcher("/AddOnServices/errorpage.jsp");
            rd.forward(request,response);
            //response.getWriter().println(ee);
        }

    }}

