package Controller;

import Model.Prodotto;
import Model.ProdottoDao;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchAjaxServlet")
public class SearchAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdottoDao prodottoDao= new ProdottoDao();
        ArrayList<Prodotto> prodotti= prodottoDao.SearchProdByName(request.getParameter("ricerca"));
        JsonArray jsonProdotti=new JsonArray();
        JsonObject prodotto;
        for(int i=0;i<prodotti.size();i++)
        {
            prodotto=new JsonObject();
            prodotto.addProperty("Id_Prodotto", prodotti.get(i).getIdprod());
            prodotto.addProperty("Nome", prodotti.get(i).getNome());
            prodotto.addProperty("Prezzo", prodotti.get(i).getPrezzo());
            jsonProdotti.add(prodotto);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().append(jsonProdotti.toString());
    }

    }

