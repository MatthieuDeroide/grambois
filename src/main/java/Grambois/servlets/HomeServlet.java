package Grambois.servlets;

import Grambois.dao.TextDAO;
import Grambois.pojos.User;
import Grambois.services.TextService;
import Grambois.services.UserService;
import Grambois.tools.PasswdUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

@WebServlet("/index")
public class HomeServlet extends GenericServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Récupération des données de connexion
        String login = request.getParameter("mail");
        String usrPasswd = request.getParameter("password");

        //Récupération de l'utilisateur
        User user = UserService.getInstance().getUser(login);

        //Verif du mot de passe
        if(PasswdUtil.validerMotDePasse(usrPasswd,user.getPwd())){
            request.getSession().setAttribute("userlogged","1");
            response.sendRedirect("admin");
        }else {
            response.sendRedirect("index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = createTemplateEngine(request.getServletContext());

        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("index", context, response.getWriter());
    }
}
