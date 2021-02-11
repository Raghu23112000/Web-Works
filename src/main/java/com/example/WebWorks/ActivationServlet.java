package com.example.WebWorks;

import com.example.WebWorks.AddOnServices.MailUtil;
import com.example.WebWorks.DBoperations.DBconnect;
import com.example.WebWorks.DBoperations.ProductDB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

@WebServlet("/ActivationServlet")
public class ActivationServlet extends HttpServlet {
    static String generte(String a)
    {
        if(a==null)
            return "0";
        return a;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String PlatCode="";
        ProductDB prod=new ProductDB();
        prod.setKey(UUID.randomUUID().toString());
        prod.setOrg(request.getParameter("cname"));
        if(request.getParameter("platform").equals("Other"))
        {
            prod.setPlat(request.getParameter("platname"));
            PlatCode+=(generte(request.getParameter("record"))+generte(request.getParameter("employee"))+generte(request.getParameter("stock")));
            //response.getWriter().println(PlatCode);
        }
        else
        {
            PlatCode+="222";
            prod.setPlat(request.getParameter("platform"));
        }
        prod.setEmail(request.getParameter("email"));
        prod.setPlatCode(Integer.parseInt(PlatCode));
        try {
            Connection conn = DBconnect.getConn();
            PreparedStatement st = conn.prepareStatement("insert into productinfo values(0,?,?,?,?,?,?)");
            st.setInt(1,prod.getPlatCode());
            st.setString(2,prod.getPlat());
            st.setString(3,prod.getOrg());
            st.setString(4,prod.getKey());
            st.setInt(5,0);
            st.setString(6,prod.getEmail());
            st.executeUpdate();
            conn.close();
//            MailUtil.sendMail(prod.getEmail(), prod.getKey());
        }
        catch(Exception ee)
        {
            RequestDispatcher rd= request.getRequestDispatcher("/AddOnServices/errorpage.jsp");
            response.getWriter().println(ee);
            rd.forward(request,response);
        }

        RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}
