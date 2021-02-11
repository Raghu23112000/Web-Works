package com.example.WebWorks.StockDetails;

import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.StockDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/StockDetails/ViewStockServlet")
public class ViewStockServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockDB stock=new StockDB();
        stock.setCusid((int)request.getSession().getAttribute("cusid"));
        stock.setSwg(Float.parseFloat(request.getParameter("swg")));
        stock.setWeight(Float.parseFloat(request.getParameter("cstock"))-Float.parseFloat(request.getParameter("amountused")));
        stock.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        try {
            Connection conn = DBconnect.getConn();
            if (stock.getWeight() <= 0) {
                PreparedStatement st = conn.prepareStatement("DELETE from stockdetails where cusid=? and SWG=?");
                st.setInt(1, stock.getCusid());
                st.setFloat(2,stock.getSwg());
                st.executeUpdate();
            } else {
                PreparedStatement st = conn.prepareStatement("update stockdetails set weight=?, Date=? where cusid=? and SWG=?");
                st.setFloat(1,stock.getWeight());
                st.setString(2,stock.getDate());
                st.setInt(3,stock.getCusid());
                st.setFloat(4,stock.getSwg());
                st.executeUpdate();
            }
            conn.close();
        }
        catch (Exception ee)
        {
            RequestDispatcher rd= request.getRequestDispatcher("../AddOnServices/errorpage.jsp");
            response.getWriter().println(ee);
            rd.forward(request,response);
        }
        response.sendRedirect("viewstock.jsp");
    }
}
