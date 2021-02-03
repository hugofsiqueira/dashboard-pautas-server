package com.dashboard.services;

import com.cooperativa.model.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

  @Autowired
  private SimpMessagingTemplate webSocket;

  public void enviarPauta(Pauta pauta) {
    webSocket.convertAndSend("/topic/pauta", pauta);
  }

}
