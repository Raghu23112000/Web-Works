package com.example.WebWorks.EmployeeManagement;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.EmployeeDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/EmployeeManagement/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
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
            if(request.getParameter("button").equals("Update")) {
                PreparedStatement st = conn.prepareStatement("update employeedetails set Name=?, Address=?, DOB=?, Phone=?, Salary=?, CurSalary=? where cusid=? and empid=?");
                st.setString(1,emp.getName());
                st.setString(2,emp.getAddress());
                st.setString(3,emp.getDob());
                st.setString(4,emp.getPhone());
                st.setInt(5,emp.getSalary());
                st.setInt(6,emp.getSalary());
                st.setInt(7,emp.getCusid());
                st.setInt(8,Integer.parseInt(request.getParameter("empid")));
                st.executeUpdate();
            }
            else if(request.getParameter("button").equals("Delete"))
            {
                PreparedStatement st=conn.prepareStatement("DELETE from employeedetails where cusid=? and empid=?");
                st.setInt(1, emp.getCusid());
                st.setInt(2, Integer.parseInt(request.getParameter("empid")));
                st.executeUpdate();
            }
            conn.close();
            response.sendRedirect("editemployee.jsp");
        }
        catch (Exception ee)
        {
            request.setAttribute("error",ee);
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            rd.forward(request,response);
        }
    }
}
