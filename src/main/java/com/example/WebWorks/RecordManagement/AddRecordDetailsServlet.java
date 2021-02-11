package com.example.WebWorks.RecordManagement;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.RecordDB;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RecordManagement/AddRecordDetailsServlet")
public class AddRecordDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RecordDB obj=new RecordDB();

        obj.setRecordName(Integer.parseInt(req.getParameter("rid")));
        obj.setRecordDetails(req.getParameter("recdetails"));
        obj.setCusid((int)req.getSession().getAttribute("cusid"));
        try{
            Connection con= DBconnect.getConn();
            PreparedStatement st=con.prepareStatement("insert into recordmanagement values(0,?,?,?)");
            st.setInt(1,obj.getRecordName());
            st.setString(2,obj.getRecordDetails());
            st.setInt(3,obj.getCusid());
            st.executeUpdate();
            System.out.println(obj.getRecordName()+" "+obj.getCusid()+" "+obj.getRecordDetails());
            con.close();
        }
        catch(Exception e){
            RequestDispatcher rd= req.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            rd.forward(req,res);
        }
        RequestDispatcher rd=req.getRequestDispatcher("addRecordDetails.jsp");
        rd.forward(req,res);
    }
}
