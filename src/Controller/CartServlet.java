package Controller;

import Model.Carrello;
import Model.Prodotto;
import Model.ProdottoDao;
import Model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = {"/CartServ"})
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utente user=(Utente)request.getSession().getAttribute("usrLog");
        ProdottoDao prodDao= new ProdottoDao();
        Carrello cart= (Carrello) request.getSession().getAttribute("carrello");
        HttpSession session=request.getSession();
        RequestDispatcher requestDispatcher;
        if(cart==null){
                    cart=new Carrello();
                    if(user!=null)
                            cart.setIdutente(user.getIdUtente());

                    synchronized (session){
                                    session.setAttribute("carrello",cart);
                    }
        }

        if(request.getParameter("addCart")!=null){
            Prodotto prod=prodDao.doFindProdID(Integer.parseInt(request.getParameter("idHidden")));
            if(prod!=null) {
                    //if(user!=null)
                        cart.addProd(prod);
            }
        }

        else if(request.getParameter("removeCart")!=null){
            Prodotto prod=prodDao.doFindProdID(Integer.parseInt(request.getParameter("idHidden")));
                if(prod!=null) {
                    if(user!=null)
                            cart.removeProd(prod);
                }
        }

        else if(request.getParameter("showCart")!=null){
                      String address="/WEB-INF/jsp/carrello.jsp";
                      requestDispatcher=request.getRequestDispatcher(address);
                      requestDispatcher.forward(request,response);
        }
        else{
                    String address=request.getHeader("referer");        // opzionale per rindirazzare l'utente al pagine dove stava
                    response.sendRedirect(address);
        }

    }
}
