package dev.caiol.btgpactual.order_ms.adapters.input.queue;

import static dev.caiol.btgpactual.order_ms.config.RabbitMQConfig.ORDER_CREATED_QUEUE;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import dev.caiol.btgpactual.order_ms.application.domain.OrderDomain;
import dev.caiol.btgpactual.order_ms.application.domain.OrderItem;
import dev.caiol.btgpactual.order_ms.application.ports.in.ISaveOrderUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class OrderCreatedListener {

  private final ISaveOrderUseCase saveOrderUseCase;

  @RabbitListener(queues = ORDER_CREATED_QUEUE)
  public void listen(Message<OrderCreatedEventDTO> message) {
    log.info("Message consumed: {}", message);

    var payload = message.getPayload();

    var domain = OrderDomain.builder()
        .orderId(payload.codigoPedido())
        .customerId(payload.codigoCliente())
        .items(
            payload.itens().stream()
                .map(item -> OrderItem.builder()
                    .product(item.produto())
                    .quantity(item.quantidade())
                    .price(item.preco())
                    .build())
                .toList()

        )
        .build();

    saveOrderUseCase.execute(domain);
  }
}
