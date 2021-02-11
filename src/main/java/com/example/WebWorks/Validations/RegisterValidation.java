package com.example.WebWorks.Validations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/RegisterValidation")
public class RegisterValidation extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String OwnerName=req.getParameter("name").trim();
        PrintWriter out= res.getWriter();
        String PhoneNum=req.getParameter("phone").trim();
        String Password=req.getParameter("pass");
        String RePassword=req.getParameter("repass");
        Boolean CheckName=Pattern.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",OwnerName);
        Boolean CheckPhone=Pattern.matches("^[2-9]{1}[0-9]{9}$",PhoneNum);
        Boolean CheckPassword=Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",Password);
        if(OwnerName.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Owner name can't be empty');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(CheckName==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Enter a Proper Name');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(PhoneNum.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Phone Number is empty');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(CheckPhone==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Enter a Valid phone Number');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(Password.isEmpty()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password cannot be empty');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(CheckPassword==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Password does not meet the requirements');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else if(Password.equals(RePassword)==false){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Retype the password properly');");
            out.println("location='registration.jsp';");
            out.println("</script>");
        }
        else{
            RequestDispatcher rd=req.getRequestDispatcher("RegisterServlet");
            rd.forward(req,res);
        }


    }
}
