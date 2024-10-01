package ba.smoki.kikiriki.three;

import ba.smoki.kikiriki.two.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ba.smoki.kikiriki.two.WebShopServlet.PRODUCTS;

@WebServlet(urlPatterns = {"/cart"})
public class ShoppingCartServlet  extends HttpServlet {

    public static final String KORPA = "KORPA";

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
            out.println("<head><title>Shopping Cart SERVLET</title></head>");
            out.println("<body>");
            HttpSession session = request.getSession();
session.getAttribute(KORPA);
ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute(KORPA);
if(shoppingCart == null){
    shoppingCart = new ShoppingCart();
    session.setAttribute(KORPA, shoppingCart);
}
String[] productIdArray = request.getParameterValues("productId");
          List<Long> productIds = Stream.of(productIdArray).map(param -> Long.parseLong(param)).collect(Collectors.toList());
          String[] quantityArray = request.getParameterValues("quantity");
         List<Integer> quantities = Stream.of(quantityArray).map(quantity -> quantity.isEmpty() ? 0 : Integer.parseInt(quantity)).collect(Collectors.toList());
List<Product> products = (List<Product>) getServletContext().getAttribute(PRODUCTS);
for(int i=0; i<products.size(); i++){
     Long productId = productIds.get(i);
Integer quantity = quantities.get(i);
     Product product = products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElseThrow();
   if (quantity !=0){
       shoppingCart.addCartItem(product, quantity);
   }

}
if (!shoppingCart.getShoppingCartItems().isEmpty()){
    out.println("<h1>Artikli u korpi!</h1>");
    out.println("<table>");

    out.println("<tr bgcolor='lightgray'>");
    out.println("<th>Naziv</th>");
    out.println("<th>Jedinicna cena</th>");
    out.println("<th>Kolicina</th>");
    out.println("<th>Ukupna cena</th>");
    out.println("</tr>");
    for(ShoppingCartItem item: shoppingCart.getShoppingCartItems()){
out.println("<tr>");
out.println("<td>" + item.getProduct().getName()+"</td>");
out.println("<td>" + item.getProduct().getPrice()+"</td>");
out.println("<td>" + item.getQuantity()+"</td>");
out.println("<td>" + item.getTotalPrice()+"</td>");
out.println("<tr>");


    }

    out.println("</table>");
    BigDecimal total= shoppingCart.getShoppingCartItems().stream().map(ShoppingCartItem::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
out.println("<h2>Total: " + total+"</h2>");
}else{
    out.println("<h1>Nema proizvoda u korpi!</h1>");


}
            out.println("</body>");
            out.println("</html>");
        }
    }
}
