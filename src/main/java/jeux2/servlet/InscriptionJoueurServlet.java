/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux2.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jeux2.entity.Joueur;
import jeux2.service.InscriptionService;
import jeux2.spring.AutowireServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "InscriptionJoueurServlet", urlPatterns = {"/InscriptionJoueurServlet"})
public class InscriptionJoueurServlet extends AutowireServlet {

    @Autowired
    private InscriptionService inscriptionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Joueur j = new Joueur();
        j.setLogin((String) req.getParameter("login"));
        j.setMdp((String) req.getParameter("mdp"));

        Boolean etatInscription = inscriptionService.inscription(j);

        req.setAttribute("etatInscription", etatInscription);

        if (etatInscription == false) {
            req.getRequestDispatcher("inscrition.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("indexInit.html").forward(req, resp);
        }
    }
}
