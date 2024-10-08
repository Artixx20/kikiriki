package ba.smoki.kikiriki.two;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/counter"})
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest (HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter();){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Counter SERVLET</title></head>");
            out.println("<body>");

            ServletContext servletContext = getServletContext();
            Brojac globalinBrojac = (Brojac) servletContext.getAttribute("globalni_brojac");
            if (globalinBrojac == null){
                globalinBrojac = new Brojac();
                servletContext.setAttribute("globalni_brojac", globalinBrojac);
            }
            globalinBrojac.increment();
            out.println("<p> Ukupno poseta = " + globalinBrojac.getCount() + "</p>");
           HttpSession session = request.getSession();
           Brojac brojac =(Brojac) session.getAttribute("brojac");
           if (brojac == null){
               brojac = new Brojac();
               session.setAttribute("brojac", brojac);
           }
           brojac.increment();
           out.println("<p> Poseta tvoja: " +brojac.getCount()+ "</p>");
           out.println("<p>Session ID= " + session.getId()+ "</p>");
          String cookie = request.getCookies()[0].getValue();
            out.println("<p>Cookie ID= " + cookie  + "</p>");
            String threadName = Thread.currentThread().getName();
            out.println("<p> Thread Name = "+threadName+"</p>");
           out.println("</body>");
           out.println("</html>");
        }
    }
}
