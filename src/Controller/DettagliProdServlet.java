package Controller;

import Model.Prodotto;
import Model.ProdottoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DettagliProdServlet", urlPatterns = {"/DetServ"})
public class DettagliProdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                            String id=request.getParameter("idsearch");
                    Prodotto prod= ProdottoDao.doFindProdottoConId(Integer.parseInt(id));
                        if(prod!= null) {
                            List<Prodotto> one_prod = new ArrayList<>(); // perche jstl legge solo collections of Object
                            one_prod.add(prod);
                            request.setAttribute("dettprod", one_prod);
                            request.setAttribute("notify", "Dettaggli Prodotto mostrati con successo");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Dettagli.jsp");
                            dispatcher.forward(request, response);
                        }
                        else
                            throw new MyExceptionServlet("Prodotto non trovato");

    }
}
