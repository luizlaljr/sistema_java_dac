/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.service;

import com.mycompany.sistema.model.Volume;
import com.mycompany.sistema.repository.VolumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luizlaljr
 */
@Service
public class VolumeServiceImpl implements VolumeService{
    @Autowired
    VolumeRepository repository;
    
    public Volume save(Volume volume){
        return repository.save(volume);
    }
    
    public void deleteById(Long volumeId){
        repository.deleteById(volumeId);
    }
    
    public Optional<Volume> findById(Long volumeId){
        return repository.findById(volumeId);
    }
    
    public List<Volume> findAll(){
        return repository.findAll();
    }
}
