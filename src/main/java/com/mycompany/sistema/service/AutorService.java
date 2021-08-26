/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Autor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author luizlaljr
 */
public interface AutorService {
    public Autor save(Autor autor);
    
    public void deleteById(Long autorId);
    
    public Optional<Autor> findById(Long autorId);
    
    public List<Autor> findAll();
}
