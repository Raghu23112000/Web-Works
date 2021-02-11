package com.example.WebWorks.RewindNotes;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.RewindDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RewindNotes/AddRdetailsServlet")
public class AddRdetailsServlet extends HttpServlet {
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
        try{
            Connection conn= DBconnect.getConn();
            PreparedStatement st=conn.prepareStatement("insert into rewinddetails values(0,?,?,?,?,?)");
            st.setInt(1,rewind.getCusid());
            st.setFloat(2,rewind.getHp());
            st.setFloat(3,rewind.getSwg());
            st.setFloat(4,rewind.getWeight());
            st.setString(5,rewind.getDet());
            st.executeUpdate();
            conn.close();
        }
        catch(Exception ee)
        {
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            response.getWriter().println(ee);
            rd.forward(request,response);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addRdetails.jsp");
        requestDispatcher.forward(request,response);
    }
}
