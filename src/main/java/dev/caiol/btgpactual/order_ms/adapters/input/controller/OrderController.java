package dev.caiol.btgpactual.order_ms.adapters.input.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.caiol.btgpactual.order_ms.adapters.input.api.IOrderResourceAPI;
import dev.caiol.btgpactual.order_ms.adapters.input.api.response.ApiListResponse;
import dev.caiol.btgpactual.order_ms.adapters.input.api.response.OrderResponse;
import dev.caiol.btgpactual.order_ms.adapters.input.api.response.PagintionResponse;
import dev.caiol.btgpactual.order_ms.application.domain.model.PageRequest;
import dev.caiol.btgpactual.order_ms.application.ports.in.IFindTotalOrderPriceByCustomerUseCase;
import dev.caiol.btgpactual.order_ms.application.ports.in.IListOrdersUseCase;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class OrderController implements IOrderResourceAPI {

  private final IListOrdersUseCase listOrdersUseCase;
  private final IFindTotalOrderPriceByCustomerUseCase findTotalOrderPriceByCustomerUseCase;

  @Override
  public ResponseEntity<ApiListResponse<OrderResponse>> listOrders(
      Long customerId,
      Integer page,
      Integer pageSize) {

    var pageResponse = listOrdersUseCase.execute(customerId, new PageRequest(page, pageSize));
    var totalOnOrders = findTotalOrderPriceByCustomerUseCase.execute(customerId);

    return ResponseEntity.ok(new ApiListResponse<>(
        Map.of("totalOnOrders", totalOnOrders),
        pageResponse.content().stream().map(OrderResponse::fromDomain).toList(),
        PagintionResponse.fromPage(pageResponse)));
  }

}
