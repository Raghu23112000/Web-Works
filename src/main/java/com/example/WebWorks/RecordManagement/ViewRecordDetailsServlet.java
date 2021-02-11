package com.example.WebWorks.RecordManagement;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.RecordDB;

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
import java.sql.ResultSet;

@WebServlet("/RecordManagement/ViewRecordDetailsServlet")
public class ViewRecordDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RecordDB obj=new RecordDB();
        obj.setCusid((int)req.getSession().getAttribute("cusid"));
        obj.setRecordName(Integer.parseInt(req.getParameter("rid")));
        try{
            Connection con=DBconnect.getConn();
            PreparedStatement st=con.prepareStatement("select recdetails from recordmanagement where cusid=? and recname=?");
            st.setInt(1,obj.getCusid());
            st.setInt(2,obj.getRecordName());
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("recdetails"));
            }
            con.close();
        }
        catch (Exception e){
            RequestDispatcher rd= req.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            res.getWriter().println(e);
            rd.forward(req,res);
        }
        RequestDispatcher rd=req.getRequestDispatcher("viewRecordDetails.jsp");
        rd.forward(req,res);
    }
}