package Controller;

import Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "CheckOutServ",urlPatterns = {"/CheckServ"})
public class CheckOutServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    Utente usr= (Utente)request.getSession().getAttribute("usrLog");
        Carrello cart=(Carrello)request.getSession().getAttribute("carrello");
        OrdineDao service= new OrdineDao();
        ArrayList<Prodotto> itemcart=cart.getListaProdotti();
                if(usr!=null){
                            for(Prodotto prod:itemcart){
                                    OrdineDao.doSaveOrdProd(usr.getIdUtente(),Integer.parseInt(prod.getIdprod()));
                            }
                            Date date=new Date();
                        service.doSave(usr.getIdUtente(),cart.getTotalPrice(),"Pagamento in corso",date);
                    RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/checkout.jsp");
                    dispatcher.forward(request,response);
                }
                else{
                        throw new MyExceptionServlet("Errore nel checkout");
                }


    }
}
