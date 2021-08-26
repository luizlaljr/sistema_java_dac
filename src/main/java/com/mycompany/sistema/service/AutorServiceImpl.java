/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Autor;
import com.mycompany.sistema.repository.AutorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luizlaljr
 */
@Service
public class AutorServiceImpl implements AutorService{
    @Autowired
    AutorRepository repository;
    
    public Autor save(Autor autor){
        return repository.save(autor);
    }
    
    public void deleteById(Long autorId){
        repository.deleteById(autorId);
    }
    
    public Optional<Autor> findById(Long autorId){
        return repository.findById(autorId);
    }
    
    public List<Autor> findAll(){
        return repository.findAll();
    }
}
