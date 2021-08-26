/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.repository;

import com.mycompany.sistema.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author luizlaljr
 */
@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long>{
    
}
