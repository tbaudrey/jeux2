/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeux2.entity.Joueur;
import jeux2.service.JoueurCrudService;
import jeux2.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AutowireServlet {

    @Autowired
    private JoueurCrudService joueurCrudService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Joueur> listeJoueurs = new ArrayList<>();
        listeJoueurs = (List<Joueur>) joueurCrudService.findAll();

        Boolean estLogger = false;

        if (!listeJoueurs.isEmpty()) {
            for (Joueur j : listeJoueurs) {
                if (j.getLogin().equals(req.getParameter("login"))) {
                    if (j.getMdp().equals(req.getParameter("mdp"))) {
                        req.getSession().setAttribute("login", req.getParameter("login"));
                        req.getSession().setAttribute("mdp", req.getParameter("mdp"));
                        estLogger = true;
                    }
                }
            }
        }
        req.setAttribute("estLogger", estLogger);
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
