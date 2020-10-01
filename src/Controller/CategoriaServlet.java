/*package Controller;

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
                                ArrayList<Categoria> categorie= (ArrayList<Categoria>) getServletContext().getAttribute("categorie");
                                ProdottoDao service= new ProdottoDao();
                         List<Prodotto> products= service.;
                                Categoria sel_cat= categorie.get(id_serach); /* perche nel DB abbiamo auto_increment
                                request.setAttribute("categoria", sel_cat);
                                request.setAttribute("prodcat",products);
                            RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/Jsp/ProdCat.jsp");
                            dispatcher.forward(request,response);


    }
}
*/