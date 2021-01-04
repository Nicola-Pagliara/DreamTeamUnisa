package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Model.*;

@WebServlet(name = "RegistrazioneServlet",urlPatterns = {"/RegServlet"})
public class RegistrazioneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                              doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String surname=request.getParameter("surname");
        //String cf=request.getParameter("Cf");
        String hashpass= request.getParameter("password");
        //String email= request.getParameter("email");
        String passConf= request.getParameter("passconferma");
        //String cap= request.getParameter("cap");
        String username=request.getParameter("username");
        if(hashpass.length()<=8 || hashpass.matches("! @")){
            throw new MyExceptionServlet("formato password non valido");
        }
                             /* if(cap.length()<5)
                                            throw  new MyExceptionServlet("formato cap errato");*/
        if(!hashpass.equals(passConf)){
            throw new MyExceptionServlet("Password e Conferma diversi");
        }
                                /*if(cf.length()<16 || !(cf!= null && cf.matches("!")))
                                        throw new MyExceptionServlet("Codice fiscale non valido");*/

        /*if (!(email != null && email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$")))
            throw new MyExceptionServlet("Email non valida.");
        // aggiungere controllo sui form lasciati vuoti dal utente
        // aggiungere ulteriore controlli sui formati dello username
        // aggiungere parte dinamica del Js with AJAX per aggiungere provincie una volta messa la città
        //Valutare aggiunta formatazzione dati JSON
            */

        UtenteDao service= new UtenteDao();
        Utente  new_user= new Utente();
        new_user.setNome(name);
         new_user.setCognome(surname);
        new_user.setUsername(username);
        new_user.setPassword(hashpass);
        new_user.setAdmin(false);
        //new_user.setCF(cf);
        //new_user.setEmail(email);
        //new_user.setCAP(Integer.parseInt(cap));
        service.doSave(new_user);
        request.getSession().setAttribute("usrLog",new_user);

        RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/jsp/RegistrazioneSuccesso.jsp");
        dispatcher.forward(request,response);
    }
}
