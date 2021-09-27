/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.controller;

import com.mycompany.sistema.model.Volume;
import com.mycompany.sistema.service.VolumeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author luizlaljr
 */
@RestController
@RequestMapping("/sistema/volumes/")
public class VolumeController {
    
    @Autowired
    private VolumeServiceImpl volumeService;
    
    @ApiOperation(value = "Retorna a lista de volumes")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista de volumes foi retornada"),
        @ApiResponse(code = 404, message = "Nenhum volume foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<Volume>> findAll(){
        
        List<Volume> volumes = volumeService.findAll();
        
        if(volumes.isEmpty()){
            return ResponseEntity.notFound().build();
        }        
        return ResponseEntity.ok(volumeService.findAll());
    }
    
    @ApiOperation(value = "Salva um volume")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "O volume foi salvo"),
        @ApiResponse(code = 422, message = "O volume não pode ser salvo"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PostMapping
    @ResponseBody
    public ResponseEntity<Volume> save(@RequestBody Volume volume){
        
        
        try {
            Volume volumeCreated = volumeService.save(volume);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(volumeCreated.getId().toString()).build().toUri();
            return ResponseEntity.created(uri).body(volumeCreated);
            
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
    
    @ApiOperation(value = "Retorna um volume específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O volume foi retornado"),
        @ApiResponse(code = 404, message = "O volume não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Volume> show(@PathVariable("id") Long id){
        Optional<Volume> volume = volumeService.findById(id);
        if(volume.isPresent()){
            return ResponseEntity.ok(volume.get());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Atualiza um volume específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O volume foi atualizado"),
        @ApiResponse(code = 404, message = "O volume não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PutMapping(path = "{id}", produces = "application/json")
    public ResponseEntity<Volume> update(@PathVariable("id") Long id, @RequestBody Volume volumeNovo){
        
        Optional<Volume> volumeAntigo = volumeService.findById(id);
        
        if(volumeAntigo.isPresent()){
            
            Volume volume = volumeAntigo.get();
            volume.setEvento(volumeNovo.getEvento());
            volume.setEdicaoEvento(volumeNovo.getEdicaoEvento());
            volume.setCidadeEvento(volumeNovo.getCidadeEvento());
            volume.setDataEvento(volumeNovo.getDataEvento());
            volume.setDescricaoPortugues(volumeNovo.getDescricaoPortugues());
            volume.setDescricaoIngles(volumeNovo.getDescricaoIngles());
       
            Volume volumeAtualizado = volumeService.save(volume);
            return ResponseEntity.ok(volumeAtualizado);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Remove um volume específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O volume foi removido"),
        @ApiResponse(code = 404, message = "O volume não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @DeleteMapping(path="{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        
        Optional<Volume> volume = volumeService.findById(id);
        
        if(!volume.isPresent()){
            return ResponseEntity.notFound().build();
        }
        volumeService.deleteById(id);
        return ResponseEntity.ok().body("Volume de id " + id + " removido");
        
    }
}
