package com.example.WebWorks.EmployeeManagement;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EmployeeManagement/GetDetails")
public class GetDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String details = "";
        boolean check = false;
            int empid = Integer.parseInt(request.getParameter("empid"));
            try {
                Connection conn = DBconnect.getConn();
                PreparedStatement pst = conn.prepareStatement("select * from employeedetails where empid=? and cusid=?");
                pst.setInt(1, empid);
                pst.setInt(2,(int)request.getSession().getAttribute("cusid"));
                ResultSet rst = pst.executeQuery();
                if (rst.next()) {
                    details = rst.getString("Name") + "||" + rst.getString("Address")+"||"+rst.getString("DOB")+"||"+rst.getString("Phone")+"||"+rst.getInt("Salary")+"||"+rst.getString("CurSalary");
                    check = true;
                }
                conn.close();
            } catch (Exception ee) {
                request.setAttribute("error",ee);
                RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
                rd.forward(request,response);
            }

        if(!check)
        {
            details="----"+"||"+"----"+"||"+"----"+"||----||----||----";
        }
        out.println(details);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
