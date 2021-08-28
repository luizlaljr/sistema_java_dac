
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mycompany.sistema.utils.Pais;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author luizlaljr
 */
@Entity
@ApiModel
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ApiModelProperty(
        value = "Ordem do autor",
        name = "ordem",
        example = "1")
    private Integer ordem;
    
    @ApiModelProperty(
        value = "Email do autor",
        name = "email",
        example = "autor@email.com")
    private String email;
    
    @ApiModelProperty(
        value = "Primeiro nome do autor",
        name = "primeiroNome",
        example = "Luiz")
    @Column(length = 64)
    private String primeiroNome;
    
    @ApiModelProperty(
        value = "Nome do meio do autor",
        name = "meioNome",
        example = "Alberto")
    @Column(length = 64)
    private String meioNome;
    
    @ApiModelProperty(
        value = "Sobrenome do autor",
        name = "sobreNome",
        example = "Junior")
    @Column(length = 64)
    private String sobreNome;
    
    @ApiModelProperty(
        value = "Afiliação do autor",
        name = "afiliacao",
        example = "SBSI")
    @Column(length = 256)
    private String afiliacao;
    
    @ApiModelProperty(
        value = "Afiliação do autor em inglês",
        name = "afiliacaoIngles",
        example = "SBSI")
    @Column(length = 256)
    private String afiliacaoIngles;
    
    @ApiModelProperty(
        value = "Pais de origem do autor")
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Pais pais;
    
    @ApiModelProperty(
        value = "Identificador digital único do autor",
        name = "orcId",
        example = "0000-0002-0123-208X")
    private String orcId;
    
    @ApiModelProperty(hidden = true)
    @JsonBackReference
    @ManyToOne
    private Artigo artigo;
    
    public Autor() {
    }

    public Autor(Long id, Integer ordem, String email, String primeiroNome, String meioNome, String sobreNome, String afiliacao, String afiliacaoIngles, Pais pais, String orcId, Artigo artigo) {
        this.id = id;
        this.ordem = ordem;
        this.email = email;
        this.primeiroNome = primeiroNome;
        this.meioNome = meioNome;
        this.sobreNome = sobreNome;
        this.afiliacao = afiliacao;
        this.afiliacaoIngles = afiliacaoIngles;
        this.pais = pais;
        this.orcId = orcId;
        this.artigo = artigo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getMeioNome() {
        return meioNome;
    }

    public void setMeioNome(String meioNome) {
        this.meioNome = meioNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getAfiliacaoIngles() {
        return afiliacaoIngles;
    }

    public void setAfiliacaoIngles(String afiliacaoIngles) {
        this.afiliacaoIngles = afiliacaoIngles;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getOrcId() {
        return orcId;
    }

    public void setOrcId(String orcId) {
        this.orcId = orcId;
    }

    public Optional<Artigo> getArtigo() {
        return Optional.ofNullable(artigo);
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", ordem=" + ordem + ", email=" + email + ", primeiroNome=" + primeiroNome + ", meioNome=" + meioNome + ", sobreNome=" + sobreNome + ", afiliacao=" + afiliacao + ", afiliacaoIngles=" + afiliacaoIngles + ", pais=" + pais + ", orcId=" + orcId + ", artigo=" + artigo + '}';
    }
    
}
