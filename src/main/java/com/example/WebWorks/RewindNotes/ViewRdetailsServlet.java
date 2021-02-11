package com.example.WebWorks.RewindNotes;

import com.example.WebWorks.AddOnServices.SWGmap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/RewindNotes/ViewRdetailsServlet")
public class ViewRdetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess= request.getSession();
        //response.getWriter().println(sess.getAttribute("rswg")+" "+sess.getAttribute("rweight"));
        float rswg=(float)sess.getAttribute("rswg");
        float rweight=(float)sess.getAttribute("rweight");
        ArrayList<Float> alter= SWGmap.getAlternate(rswg,rweight,(int)request.getSession().getAttribute("cusid"));
        if(alter==null)
        {
            alter=new ArrayList<>();
            alter.add(0.0f);
            alter.add(0.0f);
        }
        int i,j=0;
        Alternate al[]=new Alternate[alter.size()/2];
        for(i=0;i< alter.size();i+=2)
        {
            //response.getWriter().println(alter.get(i));
            al[j++]=new Alternate(alter.get(i),alter.get(i+1));
            //al[j+1].weight=alter.get(i+1);
        }
        request.setAttribute("al",al);
       // for(i=0;i<j;i++)
      //  response.getWriter().println(al[i].toString());
        RequestDispatcher rd= request.getRequestDispatcher("viewRdetails.jsp");
        rd.forward(request,response);
    }
}
