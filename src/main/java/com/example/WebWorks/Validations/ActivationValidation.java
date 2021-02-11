package com.example.WebWorks.Validations;

import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/ActivationValidation")
public class ActivationValidation extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out=res.getWriter();
        String Email=req.getParameter("email").trim();
        String CompanyName=req.getParameter("cname").trim();
        String Platform=req.getParameter("platform");
        Boolean CheckEmail=Pattern.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",Email);
        int failure=0;
        if(Email.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Email field cant be empty');");
            out.println("location='activation.jsp';");
            out.println("</script>");
           // RequestDispatcher rd= req.getRequestDispatcher("../activation.jsp");
           // rd.forward(req,res);
            failure=1;
        }
        else if(CheckEmail==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Enter proper email');");
            out.println("location='activation.jsp';");
            out.println("</script>");
            failure=1;
        }
        else if(CompanyName.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Company Name cant be empty');");
            out.println("location='activation.jsp';");
            out.println("</script>");
            failure=1;
        }
        if(failure==0){
            System.out.println(Platform);
            if(Platform.equals("Other")){
                String PlatformName=req.getParameter("platname").trim();
                String RecordService=req.getParameter("record");
                String EmployeeService=req.getParameter("employee");
                String StockService=req.getParameter("stock");
                Boolean CheckPlatformName=Pattern.matches("^[a-zA-Z\\s]*$",PlatformName);
                if(PlatformName.isEmpty()){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Platform Name cant be Empty');");
                    out.println("location='activation.jsp';");
                    out.println("</script>");
                    failure=1;
                }
                else if(CheckPlatformName==false){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Enter Proper Platform Name');");
                    out.println("location='activation.jsp';");
                    out.println("</script>");
                    failure=1;
                }
                else if(RecordService==null && EmployeeService==null && StockService==null){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Select atleast one service');");
                    out.println("location='activation.jsp';");
                    out.println("</script>");
                    failure=1;
                }
            }
            if(failure==0){
                RequestDispatcher rd= req.getRequestDispatcher("ActivationServlet");
                rd.forward(req,res);
            }
            else{
                System.out.println("Nothing happens");
            }
        }
        else{
            System.out.println("Nothing happens");
        }

    }
}
