package com.example.WebWorks.RewindNotes;

import com.example.WebWorks.DBoperations.DBconnect;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/RewindNotes/GetDetails")
public class GetDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String details = "";
        boolean check = false;

        if (!request.getParameter("hp").equals("0")) {
            float hp = Float.parseFloat(request.getParameter("hp"));
            try {
                Connection conn = DBconnect.getConn();
                PreparedStatement pst = conn.prepareStatement("select * from rewinddetails where hp=? and cusid=?");
                pst.setFloat(1, hp);
                pst.setInt(2,(int)request.getSession().getAttribute("cusid"));
                ResultSet rst = pst.executeQuery();
                float swg=0;
                float weight=0;
                if (rst.next()) {
                    swg=rst.getFloat("swg");
                    weight=rst.getFloat("Weight");
                    details = swg + "||" + weight +"||"+rst.getString("Details");
                    check = true;
                }
                HttpSession sess= request.getSession();
                sess.setAttribute("rswg",swg);
                sess.setAttribute("rweight",weight);
                pst=conn.prepareStatement("select weight from stockdetails where cusid=? and SWG=?");
                pst.setInt(1,(int)request.getSession().getAttribute("cusid"));
                pst.setFloat(2,swg);
                ResultSet rs2= pst.executeQuery();
                if(rs2.next())
                {
                    details+="||"+rs2.getFloat("weight");
                }
                else
                {
                    details+="||"+"Nil";
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
            details="----"+"||"+"----"+"||"+"----"+"||----";
        }
        out.println(details);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
