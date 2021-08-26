/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.controller;

import com.mycompany.sistema.model.Artigo;
import com.mycompany.sistema.model.Volume;
import com.mycompany.sistema.service.ArtigoServiceImpl;
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
@RequestMapping("/sistema/volume/{idVolume}/artigo")
public class ArtigoController {
    
    @Autowired
    private VolumeServiceImpl volumeService;
    
    @Autowired
    private ArtigoServiceImpl artigoService;    
    
    @ApiOperation(value = "Retorna a lista de artigos")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista de artigos foi retornada"),
        @ApiResponse(code = 404, message = "O artigo não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<Artigo>> findAll(){
        
        List<Artigo> artigos = artigoService.findAll();
        
        if(artigos.isEmpty()){
            return ResponseEntity.notFound().build();
        }        
        return ResponseEntity.ok(artigoService.findAll());
    }
    
    @ApiOperation(value = "Salva um artigo")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O artigo foi salvo"),
        @ApiResponse(code = 422, message = "O artigo não pode ser salvo"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PostMapping
    @ResponseBody
    public ResponseEntity<Artigo> save(@PathVariable("idVolume") Long idVolume, @RequestBody Artigo artigo){
        
        try {
            Optional<Volume> volumeUri = volumeService.findById(idVolume);
            Volume volume = volumeUri.get();
            artigo.setVolume(volume);
            
            Artigo artigoCreated = artigoService.save(artigo);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(artigoCreated.getId().toString()).build().toUri();
            return ResponseEntity.created(uri).body(null);
            
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
    
    @ApiOperation(value = "Retorna um artigo específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O artigo foi retornado"),
        @ApiResponse(code = 404, message = "O artigo não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(path = "/{idArtigo}", produces = "application/json")
    public ResponseEntity<Artigo> show(@PathVariable("idArtigo") Long idArtigo){
        Optional<Artigo> artigo = artigoService.findById(idArtigo);
        if(artigo.isPresent()){
            return ResponseEntity.ok(artigo.get());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Atualiza um artigo específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O artigo foi atualizado"),
        @ApiResponse(code = 404, message = "O artigo não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PutMapping(path = "/{idArtigo}", produces = "application/json")
    public ResponseEntity<Artigo> update(@PathVariable("idVolume") Long idVolume, @PathVariable("idArtigo") Long idArtigo, @RequestBody Artigo artigoNovo){
        
        Optional<Artigo> artigoAntigo = artigoService.findById(idArtigo);
        
        if(artigoAntigo.isPresent()){
            
            Artigo artigo = artigoAntigo.get();
            artigo.setOrdem(artigoNovo.getOrdem());
            artigo.setIdioma(artigoNovo.getIdioma());
            artigo.setTituloOriginal(artigoNovo.getTituloOriginal());
            artigo.setTituloIngles(artigoNovo.getTituloIngles());
            artigo.setResumoOriginal(artigoNovo.getResumoOriginal());
            artigo.setPalavrasChaveOriginais(artigoNovo.getPalavrasChaveOriginais());
            artigo.setPalavrasChaveIngles(artigoNovo.getPalavrasChaveIngles());
            
            Artigo artigoAtualizado = artigoService.save(artigo);
            return ResponseEntity.ok(artigoAtualizado);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Remove um artigo específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O artigo foi removido"),
        @ApiResponse(code = 404, message = "Nenhum artigo foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @DeleteMapping(path="/{idArtigo}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("idArtigo") Long id){
        
        Optional<Artigo> artigo = artigoService.findById(id);
        
        if(!artigo.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(null);
        
    }
}
