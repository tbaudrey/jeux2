/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux2.service;

import org.springframework.data.repository.CrudRepository;
import jeux2.entity.Joueur;

/**
 *
 * @author tom
 */
public interface JoueurCrudService extends CrudRepository<Joueur, Long>{
    
}
