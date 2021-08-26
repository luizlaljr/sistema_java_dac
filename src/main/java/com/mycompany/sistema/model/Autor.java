
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistema.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mycompany.sistema.utils.Pais;
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
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Integer ordem;
    
    private String email;
    
    @Column(length = 64)
    private String primeiroNome;
    
    @Column(length = 64)
    private String meioNome;
    
    @Column(length = 64)
    private String sobreNome;
    
    @Column(length = 256)
    private String afiliacao;
    
    @Column(length = 256)
    private String afiliacaoIngles;
    
    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Pais pais;
    
    private String orcId;
    
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
