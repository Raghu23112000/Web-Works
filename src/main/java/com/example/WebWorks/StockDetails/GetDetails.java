package com.example.WebWorks.StockDetails;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/StockDetails/GetDetails")
public class GetDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String details = "";
        boolean check = false;
        if (!request.getParameter("swg").equals("0")) {
            float swg = Float.parseFloat(request.getParameter("swg"));
            try {
                Connection conn = DBconnect.getConn();
                PreparedStatement pst = conn.prepareStatement("select * from stockdetails where SWG=? and cusid=?");
                pst.setFloat(1, swg);
                pst.setInt(2,(int)request.getSession().getAttribute("cusid"));
                ResultSet rst = pst.executeQuery();
                if (rst.next()) {
                    details = rst.getFloat("SWG") + "||" + rst.getFloat("Weight");
                    check = true;
                }
                conn.close();
            } catch (Exception ee) {
                RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
                response.getWriter().println(ee);
                rd.forward(request,response);
            }
        }
        if(!check)
        {
            details="----"+"||"+"----";
        }
        out.println(details);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
