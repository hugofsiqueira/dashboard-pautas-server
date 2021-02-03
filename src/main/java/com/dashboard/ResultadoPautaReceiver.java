package com.dashboard;

import com.cooperativa.model.Pauta;
import com.dashboard.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultadoPautaReceiver {

  @Autowired
  private PautaService pautaController;

  public void receberResultadoPauta(Pauta pauta) {
    System.out.println(pauta.imprimirResultadoVotacao());
    try {
      pautaController.enviarPauta(pauta);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
