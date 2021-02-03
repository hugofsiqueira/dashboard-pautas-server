package com.cooperativa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Votacao {

    private Date dataInicio;
    private Long duracaoMinutos;
    private Resultado resultado;

    public Votacao() {
        votoList = new ArrayList<>();
    }

    @JsonIgnore
    private List<Voto> votoList;
    private boolean finalizada;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public List<Voto> getVotoList() {
        return votoList;
    }

    public void setVotoList(List<Voto> votoList) {
        this.votoList = votoList;
    }

    public Long getDuracaoMinutos() {
      return duracaoMinutos;
    }

    public void setDuracaoMinutos(Long duracaoMinutos) {
      this.duracaoMinutos = duracaoMinutos;
    }

    public Resultado getResultado() {
      return resultado;
    }

    public void setResultado(Resultado resultado) {
      this.resultado = resultado;
    }

}
