/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author luizlaljr
 */
@Entity
@ApiModel
public class Volume implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ApiModelProperty(
        value = "Nome do evento",
        name = "evento",
        example = "Simpósio da SBSI")
    @Column(length = 32)
    private String evento;
    
    @ApiModelProperty(
        value = "Edição do evento",
        name = "edicaoEvento",
        example = "1")
    private Integer edicaoEvento;
    
    @ApiModelProperty(
        value = "Cidade do evento",
        name = "cidadeEvento",
        example = "Rio de Janeiro")
    @Column(length = 64)
    private String cidadeEvento;
    
    @ApiModelProperty(
        value = "Data do evento",
        name = "dataEvento",
        example = "01/09/2021")
    private String dataEvento;
    
    @Column(length = 2048)
    @ApiModelProperty(
        value = "Descrição do evento em português",
        name = "descricaoPortugues",
        example = "Encontro da sociedade brasileira de SI.")
    private String descricaoPortugues;
    
    @ApiModelProperty(
        value = "Descrição do evento em inlgês",
        name = "descricaoIngles",
        example = "Meeting of the Brazilian Information Systems Society.")
    @Column(length = 2048)
    private String descricaoIngles;
    
    @ApiModelProperty(hidden = true)
    @JsonManagedReference
    @OneToMany(mappedBy = "volume")
    private List<Artigo> artigos;

    public Volume() {
    }

    public Volume(Long id, String evento, Integer edicaoEvento, String cidadeEvento, String dataEvento, String descricaoPortugues, String descricaoIngles, List<Artigo> artigos) {
        this.id = id;
        this.evento = evento;
        this.edicaoEvento = edicaoEvento;
        this.cidadeEvento = cidadeEvento;
        this.dataEvento = dataEvento;
        this.descricaoPortugues = descricaoPortugues;
        this.descricaoIngles = descricaoIngles;
        this.artigos = artigos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Integer getEdicaoEvento() {
        return edicaoEvento;
    }

    public void setEdicaoEvento(Integer edicaoEvento) {
        this.edicaoEvento = edicaoEvento;
    }

    public String getCidadeEvento() {
        return cidadeEvento;
    }

    public void setCidadeEvento(String cidadeEvento) {
        this.cidadeEvento = cidadeEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricaoPortugues() {
        return descricaoPortugues;
    }

    public void setDescricaoPortugues(String descricaoPortugues) {
        this.descricaoPortugues = descricaoPortugues;
    }

    public String getDescricaoIngles() {
        return descricaoIngles;
    }

    public void setDescricaoIngles(String descricaoIngles) {
        this.descricaoIngles = descricaoIngles;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    @Override
    public String toString() {
        return "Volume{" + "id=" + id + ", evento=" + evento + ", edicaoEvento=" + edicaoEvento + ", cidadeEvento=" + cidadeEvento + ", dataEvento=" + dataEvento + ", descricaoPortugues=" + descricaoPortugues + ", descricaoIngles=" + descricaoIngles + ", artigos=" + artigos + '}';
    }
    
}
