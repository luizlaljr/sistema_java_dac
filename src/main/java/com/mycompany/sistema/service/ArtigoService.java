/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Artigo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author luizlaljr
 */
public interface ArtigoService {
    
    public Artigo save(Artigo artigo);
    
    public void deleteById(Long artigoId);
    
    public Optional<Artigo> findById(Long artigoId);
    
    public List<Artigo> findAll();
    
}
