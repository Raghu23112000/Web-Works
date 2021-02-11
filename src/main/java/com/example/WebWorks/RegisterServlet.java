package com.example.WebWorks;

import com.example.WebWorks.DBoperations.CustomerDB;
import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private CustomerDB cus=new CustomerDB();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = DBconnect.getConn();
            PreparedStatement st = conn.prepareStatement("Select * from productinfo where ProductKey=?");
            st.setString(1,request.getParameter("key"));
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("ActivationStatus")==0) {
                    cus.setKey(rs.getString("ProductKey"));
                    cus.setUname(rs.getString("Email"));
                    cus.setOrg(rs.getString("Organization"));
                    cus.setPlatCode(rs.getInt("PlatformCode"));
                }
                else
                {
                    response.addHeader("location","/login.jsp");
                }
            }
            conn.close();
        }
        catch (Exception ee)
        {
            response.getWriter().println(ee);
        }
        request.setAttribute("Key",cus.getKey());
        request.setAttribute("Org",cus.getOrg());
        request.setAttribute("Email",cus.getUname());
        RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cus.setName(request.getParameter("name"));
        cus.setDOB(request.getParameter("dob"));
        cus.setPass(request.getParameter("pass"));
        cus.setAdminStatus(0);
        cus.setActiDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        try
        {
            Connection conn=DBconnect.getConn();
            PreparedStatement st = conn.prepareStatement("insert into customerlogin values(0,?,?,?,?,?,?,?,?,?)");
            st.setInt(1,cus.getPlatCode());
            st.setString(2,cus.getName());
            st.setString(3,cus.getOrg());
            st.setString(4,cus.getDOB());
            st.setString(5,cus.getUname());
            st.setString(6,cus.getPass());
            st.setString(7,cus.getKey());
            st.setString(8,cus.getActiDate());
            st.setInt(9,cus.getAdminStatus());
            st.executeUpdate();
            st=conn.prepareStatement("Select cusid from customerlogin where ProductKey=?");
            st.setString(1,cus.getKey());
            ResultSet rs=st.executeQuery();
            rs.next();
            int id=rs.getInt("cusid");
            st=conn.prepareStatement("insert into logfile values(0,?,?,?,0,?)");
            st.setInt(1,id);
            st.setString(2,cus.getName());
            st.setString(3,new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            st.setString(4,"Account Created!");
            st.executeUpdate();
            st=conn.prepareStatement("update productinfo set ActivationStatus=1 where ProductKey=?");
            st.setString(1, cus.getKey());
            st.executeUpdate();
            conn.close();

        }
        catch (Exception ee)
        {
            RequestDispatcher rd= request.getRequestDispatcher("/AddOnServices/errorpage.jsp");
            response.getWriter().println(ee);
            rd.forward(request,response);
        }
        RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
    }
}
