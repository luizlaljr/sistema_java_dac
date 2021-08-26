/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.sistema.utils.Idioma;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author luizlaljr
 */
@Entity
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Integer ordem;
    
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    
    @Column(length = 256)
    private String tituloOriginal;
    
    @Column(length = 256)
    private String tituloIngles;
    
    @Column(length = 2048)
    private String resumoOriginal;
    
    @Column(length = 2048)
    private String resumoIngles;
    
    @Column(length = 256)
    private String palavrasChaveOriginais;
    
    @Column(length = 256)
    private String palavrasChaveIngles;
    
    @JsonBackReference
    @ManyToOne
    private Volume volume;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "artigo")
    private List<Autor> autores;

    public Artigo() {
    }

    public Artigo(Long id, Integer ordem, Idioma idioma, String tituloOriginal, String tituloIngles, String resumoOriginal, String resumoIngles, String palavrasChaveOriginais, String palavrasChaveIngles, List<Autor> autores) {
        this.id = id;
        this.ordem = ordem;
        this.idioma = idioma;
        this.tituloOriginal = tituloOriginal;
        this.tituloIngles = tituloIngles;
        this.resumoOriginal = resumoOriginal;
        this.resumoIngles = resumoIngles;
        this.palavrasChaveOriginais = palavrasChaveOriginais;
        this.palavrasChaveIngles = palavrasChaveIngles;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloIngles() {
        return tituloIngles;
    }

    public void setTituloIngles(String tituloIngles) {
        this.tituloIngles = tituloIngles;
    }

    public String getResumoOriginal() {
        return resumoOriginal;
    }

    public void setResumoOriginal(String resumoOriginal) {
        this.resumoOriginal = resumoOriginal;
    }

    public String getResumoIngles() {
        return resumoIngles;
    }

    public void setResumoIngles(String resumoIngles) {
        this.resumoIngles = resumoIngles;
    }

    public String getPalavrasChaveOriginais() {
        return palavrasChaveOriginais;
    }

    public void setPalavrasChaveOriginais(String palavrasChaveOriginais) {
        this.palavrasChaveOriginais = palavrasChaveOriginais;
    }

    public String getPalavrasChaveIngles() {
        return palavrasChaveIngles;
    }

    public void setPalavrasChaveIngles(String palavrasChaveIngles) {
        this.palavrasChaveIngles = palavrasChaveIngles;
    }

    public Optional<Volume> getVolume() {
        return Optional.ofNullable(volume);
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Artigo{" + "id=" + id + ", ordem=" + ordem + ", idioma=" + idioma + ", tituloOriginal=" + tituloOriginal + ", tituloIngles=" + tituloIngles + ", resumoOriginal=" + resumoOriginal + ", resumoIngles=" + resumoIngles + ", palavrasChaveOriginais=" + palavrasChaveOriginais + ", palavrasChaveIngles=" + palavrasChaveIngles + ", volume=" + volume + ", autores=" + autores + '}';
    }
    
}
