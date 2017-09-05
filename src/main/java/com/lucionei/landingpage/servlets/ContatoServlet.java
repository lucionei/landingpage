package com.lucionei.landingpage.servlets;

import com.lucionei.landingpage.dao.ContatoDao;
import com.lucionei.landingpage.model.Contato;
import com.lucionei.landingpage.utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucionei
 */
@WebServlet("/api/contatos")
public class ContatoServlet extends HttpServlet {

    private final ContatoDao dao = new ContatoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            resp.getWriter().append(dao.findAll().toString());
        } catch (Exception ex) {
            resp.sendError(406, "Erro ao consultar contatos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contato contato = new Contato();
        contato.parse(Utils.parseMap(req));
        try {
            dao.insert(contato);
        } catch (Exception ex) {
            resp.sendError(406, "Erro ao inserir Contato");
        }

    }

}
