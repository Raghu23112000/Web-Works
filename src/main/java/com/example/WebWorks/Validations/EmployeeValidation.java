package com.example.WebWorks.Validations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/EmployeeManagement/EmployeeValidation")
public class EmployeeValidation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String EmployeeName=req.getParameter("ename");
        PrintWriter out=res.getWriter();
        String Address=req.getParameter("address");
        String DateOfBirth=req.getParameter("dob");
        String PhoneNumber=req.getParameter("number");
        String Salary=req.getParameter("salary");
        Boolean CheckEmployeeName=Pattern.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",EmployeeName);
        Boolean CheckPhone=Pattern.matches("^[2-9]{1}[0-9]{9}$",PhoneNumber);
        Boolean CheckSalary=Pattern.matches("^[0-9]{1,6}$",Salary);
        if(EmployeeName.trim().isEmpty()){
            System.out.println("hello");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Employee name can't be empty');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
//            out.println("<meta http-equiv='refresh' content='3;URL=addemployee.jsp'>");//redirects after 3 seconds
//            out.println("<p style='color:red;'>User or password incorrect!</p>");

        }
        else if(CheckEmployeeName==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter proper name');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(PhoneNumber.trim().isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Phone number can't be empty');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(CheckPhone==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter proper phone number');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(Salary.trim().isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Salary can't be empty');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(Salary.charAt(0)=='0'){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Salary can't be empty');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(Salary.equals("0")){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Salary can't be zero');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(CheckSalary==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please enter proper salary');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else if(Integer.parseInt(Salary)<0){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Salary can't be negative value');");
            out.println("location='addemployee.jsp';");
            out.println("</script>");
        }
        else{
            RequestDispatcher rd=req.getRequestDispatcher("AddEmployeeServlet");
            rd.forward(req,res);
        }
    }
}
