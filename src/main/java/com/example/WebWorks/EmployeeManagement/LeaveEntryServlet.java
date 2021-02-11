package com.example.WebWorks.EmployeeManagement;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EmployeeManagement/LeaveEntryServlet")
public class LeaveEntryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int persal=Integer.parseInt(request.getParameter("salary"))/30;
        int cursal=Integer.parseInt(request.getParameter("salary"))-(persal*Integer.parseInt(request.getParameter("nodays")));

        try{
            Connection conn= DBconnect.getConn();
            PreparedStatement st=conn.prepareStatement("update employeedetails set CurSalary=? where empid=? and cusid=?");
            st.setInt(1,cursal);
            st.setInt(2,Integer.parseInt(request.getParameter("empid")));
            st.setInt(3,(int)request.getSession().getAttribute("cusid"));
            st.executeUpdate();
            conn.close();
            response.sendRedirect("leaveentry.jsp");
        }
        catch (Exception ee)
        {
            request.setAttribute("error",ee);
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            rd.forward(request,response);
        }
    }
}
