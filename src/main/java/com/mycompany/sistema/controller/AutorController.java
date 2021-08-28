/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.controller;

import com.mycompany.sistema.model.Artigo;
import com.mycompany.sistema.model.Autor;
import com.mycompany.sistema.service.ArtigoServiceImpl;
import com.mycompany.sistema.service.AutorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/sistema/volume/{idVolume}/artigo/{idArtigo}/autor")
public class AutorController {
    @Autowired
    private AutorServiceImpl autorService;
    
    @Autowired
    private ArtigoServiceImpl artigoService;
    
    @ApiOperation(value = "Retorna a lista de autores")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Lista de autores foi retornada"),
        @ApiResponse(code = 404, message = "Nenhum autor foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<Autor>> findAll(){
        
        List<Autor> autors = autorService.findAll();
        
        if(autors.isEmpty()){
            return ResponseEntity.notFound().build();
        }        
        return ResponseEntity.ok(autorService.findAll());
    }
    
    @ApiOperation(value = "Salva um autor")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O autor foi salvo"),
        @ApiResponse(code = 422, message = "O autor não pode ser salvo"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PostMapping
    @ResponseBody
    public ResponseEntity<Autor> save(@PathVariable("Id do Volume") Long idVolume, @PathVariable("Id do Artigo") Long idArtigo, @RequestBody Autor autor){
        
        try {
            Optional<Artigo> artigoUri = artigoService.findById(idArtigo);
            Artigo artigo = artigoUri.get();
            autor.setArtigo(artigo);
            
            Autor autorCreated = autorService.save(autor);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(autorCreated.getId().toString()).build().toUri();
            return ResponseEntity.created(uri).body(autorCreated);
            
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
    
    @ApiOperation(value = "Retorna um autor específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O autor foi retornado"),
        @ApiResponse(code = 404, message = "O autor não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @GetMapping(path = "/{idAutor}", produces = "application/json")
    public ResponseEntity<Autor> show(@PathVariable("Id do Volume") Long idVolume, @PathVariable("Id do Artigo") Long idArtigo, @PathVariable("idAutor") Long idAutor){
        Optional<Autor> autor = autorService.findById(idAutor);
        if(autor.isPresent()){
            return ResponseEntity.ok(autor.get());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(value = "Atualiza um autor específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O autor foi atualizado"),
        @ApiResponse(code = 404, message = "O autor não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Autor> update(@PathVariable("Id do Volume") Long idVolume, @PathVariable("Id do Artigo") Long idArtigo, @PathVariable("id") Long id, @RequestBody Autor autorNovo){
        Optional<Autor> autorAntigo = autorService.findById(id);
        if(autorAntigo.isPresent()){
            Autor autor = autorAntigo.get();
            autor.setOrdem(autorNovo.getOrdem());
            autor.setEmail(autorNovo.getEmail());
            autor.setPrimeiroNome(autorNovo.getPrimeiroNome());
            autor.setMeioNome(autorNovo.getMeioNome());
            autor.setSobreNome(autorNovo.getSobreNome());
            autor.setAfiliacao(autorNovo.getAfiliacao());
            autor.setAfiliacaoIngles(autorNovo.getAfiliacaoIngles());
            autor.setPais(autorNovo.getPais());
            autor.setOrcId(autorNovo.getOrcId());
            
            Autor autorAtualizado = autorService.save(autor);
            return ResponseEntity.ok(autorAtualizado);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @ApiOperation(value = "Remove um volume específico")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "O autor foi removido"),
        @ApiResponse(code = 404, message = "O autor não foi encontrado"),
        @ApiResponse(code = 500, message = "Houve algum problema no servidor"),
    })
    @DeleteMapping(path="/{id}")    
    public ResponseEntity<String> deleteById(@PathVariable("idVolume") Long idVolume, @PathVariable("idArtigo") Long idArtigo, @PathVariable("id") Long id){
        
        Optional<Autor> autor = autorService.findById(id);
        
        if(!autor.isPresent()){
            return ResponseEntity.notFound().build();
        }
        autorService.deleteById(id);
        return ResponseEntity.ok().body("Autor de id " + id + " removido");
        
    }
}
