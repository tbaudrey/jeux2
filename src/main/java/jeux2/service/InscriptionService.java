/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux2.service;

import java.util.List;
import jeux2.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {

    @Autowired
    private JoueurCrudService joueurCrudService;

    public Boolean inscription(Joueur j) {

        List<Joueur> listeUtilisateurs = (List<Joueur>) joueurCrudService.findAll();
        if (!listeUtilisateurs.isEmpty()){
            for (Joueur j2 : listeUtilisateurs) {
                if (j.getLogin().equals(j2.getLogin())) {
                    return false;
                }
            }
        }
        joueurCrudService.save(j);
        return true;
    }

}
