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
@WebServlet("/RecordManagement/UpdateRecordDetailsServlet")
public class UpdateRecordDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RecordDB obj=new RecordDB();
        obj.setRecordName(Integer.parseInt(req.getParameter("rid")));
        obj.setRecordDetails(req.getParameter("recdetails"));
        obj.setCusid((int)req.getSession().getAttribute("cusid"));
        try{
            Connection con= DBconnect.getConn();
            if(req.getParameter("button").equals("Update")) {
                PreparedStatement st = con.prepareStatement("update recordmanagement set recdetails=? where cusid=? and recname=?");
                st.setString(1,obj.getRecordDetails());
                st.setInt(2,obj.getCusid());
                st.setInt(3,obj.getRecordName());
                st.executeUpdate();
                con.close();
            }
            else if(req.getParameter("button").equals("Delete"))
            {
                PreparedStatement st=con.prepareStatement("DELETE from recordmanagement where cusid=? and recname=?");
                st.setInt(1,obj.getCusid());
                st.setInt(2,obj.getRecordName());
                st.executeUpdate();
            }
            con.close();
            res.sendRedirect("updateRecordDetails.jsp");
        }
        catch(Exception e){
            RequestDispatcher rd= req.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            res.getWriter().println(e);
            rd.forward(req,res);
        }
    }
}
