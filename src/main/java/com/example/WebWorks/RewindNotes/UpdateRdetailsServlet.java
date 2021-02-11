package com.example.WebWorks.RewindNotes;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.RewindDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RewindNotes/UpdateRdetailsServlet")
public class UpdateRdetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RewindDB rewind=new RewindDB();
        rewind.setHp(Float.parseFloat(request.getParameter("hp")));
        rewind.setSwg(Float.parseFloat(request.getParameter("swg")));
        rewind.setWeight(Float.parseFloat(request.getParameter("amount")));
        rewind.setDet(request.getParameter("rdetails"));
        rewind.setCusid((int)request.getSession().getAttribute("cusid"));
        try
        {
            Connection conn=DBconnect.getConn();
            if(request.getParameter("button").equals("Update")) {
                PreparedStatement st = conn.prepareStatement("update rewinddetails set swg=?, weight=?, Details=? where cusid=? and hp=?");
                st.setFloat(1, rewind.getSwg());
                st.setFloat(2, rewind.getWeight());
                st.setString(3, rewind.getDet());
                st.setInt(4, rewind.getCusid());
                st.setFloat(5, rewind.getHp());
                st.executeUpdate();
            }
            else if(request.getParameter("button").equals("Delete"))
            {
                PreparedStatement st=conn.prepareStatement("DELETE from rewinddetails where cusid=? and hp=?");
                st.setInt(1, rewind.getCusid());
                st.setFloat(2, rewind.getHp());
                st.executeUpdate();
            }
            conn.close();
            response.sendRedirect("updateRdetails.jsp");
        }
        catch (Exception ee)
        {
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            response.getWriter().println(ee);
            rd.forward(request,response);
        }
    }
}
