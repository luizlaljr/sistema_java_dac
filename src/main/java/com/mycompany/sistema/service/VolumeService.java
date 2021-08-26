/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Volume;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author luizlaljr
 */
public interface VolumeService {
    public Volume save(Volume volume);
    
    public void deleteById(Long volumeId);
    
    public Optional<Volume> findById(Long volumeId);
    
    public List<Volume> findAll();
}
