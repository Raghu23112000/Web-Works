package com.example.WebWorks.RecordManagement;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/RecordManagement/GetDetails")
public class GetDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String details = "";
        boolean check = false;
        if (!req.getParameter("rid").equals("0")) {
            int recname  = Integer.parseInt(req.getParameter("rid"));
            try {
                Connection con=DBconnect.getConn();
                PreparedStatement st = con.prepareStatement("select * from recordmanagement where recname=? and cusid=?");
                st.setInt(1, recname);
                st.setInt(2,(int)req.getSession().getAttribute("cusid"));
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    details = rs.getString("recdetails") ;
                    check = true;
                }
                con.close();
            } catch (Exception e) {
                RequestDispatcher rd= req.getRequestDispatcher("../AddOnServices/errorpage.jsp");
                out.println(e);
                rd.forward(req,res);
            }
        }
        if(!check)
        {
            details="----";
        }
        out.println(details);
        out.close();
    }
}
