package com.cooperativa.model;

import java.text.SimpleDateFormat;

public class Pauta {

    private String codigo;
    private Votacao votacao;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Votacao getVotacao() {
      return votacao;
    }

    public void setVotacao(Votacao votacao) {
      this.votacao = votacao;
    }

    public boolean temVotacaoEmAndamento() {
      return votacao != null && !votacao.isFinalizada();
    }

    public String imprimirResultadoVotacao() {
      SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      StringBuilder sb = new StringBuilder();
      sb.append("Resultado da Votação da Pauta "+codigo);
      sb.append("\n");
      sb.append("Data abertura: "+df.format(votacao.getDataInicio()));
      sb.append("\n");
      sb.append("Duração da sessão: "+votacao.getDuracaoMinutos() + " minutos");
      sb.append("\n");
      sb.append("Total de votos apurados: "+votacao.getResultado().getTotalVotos());
      sb.append("\n");
      sb.append("Total de votos Sim: "+votacao.getResultado().getTotalSim());
      sb.append("\n");
      sb.append("Total de votos Não: "+votacao.getResultado().getTotalNao());
      sb.append("\n");

      return sb.toString();
    }

}
