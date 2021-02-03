package com.cooperativa.model;

public class Resultado {

    private String codigo;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getTotalVotos() {
      return totalVotos;
    }

    public void setTotalVotos(Long totalVotos) {
      this.totalVotos = totalVotos;
    }

    public Long getTotalSim() {
      return totalSim;
    }

    public void setTotalSim(Long totalSim) {
      this.totalSim = totalSim;
    }

    public Long getTotalNao() {
      return totalNao;
    }

    public void setTotalNao(Long totalNao) {
      this.totalNao = totalNao;
    }

}
