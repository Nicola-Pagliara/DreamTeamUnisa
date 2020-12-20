package Controller;

import Model.Carrello;
import Model.OrdineDao;
import Model.Prodotto;
import Model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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

                }

    }
}
