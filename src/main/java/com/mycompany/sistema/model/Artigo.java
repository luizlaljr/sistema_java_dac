/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.sistema.utils.Idioma;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ApiModelProperty(
        value = "Ordem do Artigo",
        name = "ordem",
        example = "1")
    private Integer ordem;
    
    @ApiModelProperty(
        value = "Idioma do artigo")
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    
    @ApiModelProperty(
        value = "Título original",
        name = "tituloOriginal",
        example = "Escabilidade e Elasticidade")
    @Column(length = 256)
    private String tituloOriginal;
    
    @ApiModelProperty(
        value = "Título em inglês",
        name = "tituloIngles",
        example = "Scalability and Elasticity")
    @Column(length = 256)
    private String tituloIngles;
    
    @ApiModelProperty(
        value = "Resumo original",
        name = "resumoOriginal",
        example = "Escabilidade e Elasticidade no processo da disponibilidade da aplicação.")
    @Column(length = 2048)
    private String resumoOriginal;
    
    @ApiModelProperty(
        value = "Resumo em inglês",
        name = "resumoIngles",
        example = "Scalability and Elasticity in the application availability process.")
    @Column(length = 2048)
    private String resumoIngles;
    
    @ApiModelProperty(
        value = "Palavras chaves originais",
        name = "palavrasChaveOriginais",
        example = "Escabilidade, Elasticidade, Disponibilidade.")
    @Column(length = 256)
    private String palavrasChaveOriginais;
    
    @ApiModelProperty(
        value = "Palavras chaves em inglês",
        name = "palavrasChaveIngles",
        example = "Scalability, Elasticity, Availability.")
    @Column(length = 256)
    private String palavrasChaveIngles;
    
    @ApiModelProperty(hidden = true)
    @JsonBackReference
    @ManyToOne
    private Volume volume;
    
    @ApiModelProperty(hidden = true)
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
