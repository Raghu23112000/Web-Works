package com.example.WebWorks.EmployeeManagement;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.EmployeeDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/EmployeeManagement/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDB emp=new EmployeeDB();
        emp.setName(request.getParameter("ename"));
        emp.setAddress(request.getParameter("address"));
        emp.setCusid((int)request.getSession().getAttribute("cusid"));
        emp.setPhone(request.getParameter("number"));
        emp.setSalary(Integer.parseInt(request.getParameter("salary")));
        emp.setDob(request.getParameter("dob"));
        try{
            Connection conn= DBconnect.getConn();
            PreparedStatement st=conn.prepareStatement("insert into employeedetails values(0,?,?,?,?,?,?,?)");
            st.setInt(1,emp.getCusid());
            st.setString(2,emp.getName());
            st.setString(3,emp.getAddress());
            st.setString(4,emp.getDob());
            st.setString(5,emp.getPhone());
            st.setInt(6,emp.getSalary());
            st.setInt(7,emp.getSalary());
            st.executeUpdate();
            conn.close();
        }
        catch (Exception ee)
        {
            request.setAttribute("error",ee);
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            rd.forward(request,response);
        }
        response.sendRedirect("addemployee.jsp");
    }
}
