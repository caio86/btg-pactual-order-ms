package dev.caiol.btgpactual.order_ms.config;

import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  public static final String ORDER_CREATED_QUEUE = "btg-pactual.order.created.queue";

  @Bean
  public Declarable OrderCreatedQueue() {
    return new Queue(RabbitMQConfig.ORDER_CREATED_QUEUE);
  }

  @Bean
  public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
