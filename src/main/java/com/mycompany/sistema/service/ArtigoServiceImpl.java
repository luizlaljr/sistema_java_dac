/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Artigo;
import com.mycompany.sistema.repository.ArtigoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luizlaljr
 */
@Service
public class ArtigoServiceImpl {
    
    @Autowired
    ArtigoRepository repository;
    
    public Artigo save(Artigo artigo){
        return repository.save(artigo);
    }
    
    public void deleteById(Long artigoId){
        repository.deleteById(artigoId);
    }
    
    public Optional<Artigo> findById(Long artigoId){
        return repository.findById(artigoId);
    }
    
    public List<Artigo> findAll(){
        return repository.findAll();
    }
    
}
