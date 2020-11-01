package Controller;

import Model.Categoria;
import Model.CategoriaDao;
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

@WebServlet(name = "CategoriaServlet",urlPatterns = {"/CatServ"})
public class CategoriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                int id_serach= Integer.parseInt(request.getParameter("Idcat"));
                         List<Prodotto> products= CategoriaDao.doFindProdByCatId(id_serach);
                                request.setAttribute("prodscategory",products);
                            RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/ProdCat.jsp");
                            dispatcher.forward(request,response);


    }
}
