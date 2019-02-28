package Grambois.servlets;

import Grambois.dao.TextDAO;
import Grambois.services.TextService;
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = createTemplateEngine(request.getServletContext());

        WebContext context = new WebContext(request, response, request.getServletContext());



        System.out.println(TextService.getInstance().getText());
        engine.process("index", context, response.getWriter());
    }
}
