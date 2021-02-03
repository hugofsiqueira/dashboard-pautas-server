package com.dashboard;

import com.cooperativa.model.Pauta;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  static final String QUEUE_NAME = "pautas.queue";
  static final String EXCHANGE_NAME = "pautas.exchange";
  static final String ROUTE_KEY = "pautas.route";

  @Autowired
  private ResultadoPautaReceiver resultadoPautaReceiver;

  @Bean
  public CachingConnectionFactory rabbitConnectionFactory(RabbitProperties config)
    throws Exception {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.getRabbitConnectionFactory()
      .setUri("amqps://fqybnvgw:vRL8SVNo59D4QY3AWaFO8lYt2puW9jyW@jackal.rmq.cloudamqp.com/fqybnvgw");
    return connectionFactory;
  }

  @RabbitListener(queues = QUEUE_NAME)
  public void ouvirResultadosPautas(Pauta pauta) {
    resultadoPautaReceiver.receberResultadoPauta(pauta);
  }

  @Bean
  Queue queue() {
    return new Queue(QUEUE_NAME, false);
  }

  @Bean
  DirectExchange exchange() {
    return new DirectExchange(EXCHANGE_NAME);
  }

  @Bean
  Binding binding(Queue queue, DirectExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(ROUTE_KEY);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }
}
