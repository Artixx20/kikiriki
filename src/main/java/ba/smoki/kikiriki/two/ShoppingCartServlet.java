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
import java.util.List;

import static ba.smoki.kikiriki.two.WebShopServlet.PRODUCTS;

@WebServlet(urlPatterns = {"/cart"})
public class ShoppingCartServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
processRequest(req, resp);
    }
    private void processRequest (HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter();){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Counter SERVLET</title></head>");
            out.println("<body>");
          Long productId = Long.parseLong(request.getParameter("productId"));
          Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            out.println("<h1>Shopping Cart Servlet</h1>");
            out.println("<p>Meni je neko dao product= " + productId+ ", kolicina =" + quantity);
            String threadName = Thread.currentThread().getName();
            out.println("<p> Thread Name = "+threadName+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
