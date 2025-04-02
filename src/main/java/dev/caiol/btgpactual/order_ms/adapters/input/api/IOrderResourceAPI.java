package dev.caiol.btgpactual.order_ms.adapters.input.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.caiol.btgpactual.order_ms.adapters.input.api.response.ApiListResponse;
import dev.caiol.btgpactual.order_ms.adapters.input.api.response.OrderResponse;

@RequestMapping("/api/v1")
public interface IOrderResourceAPI {

  @GetMapping("/customers/{customerId}/orders")
  ResponseEntity<ApiListResponse<OrderResponse>> listOrders(
      @PathVariable("customerId") Long customerId,
      @RequestParam(name = "page", defaultValue = "0") Integer page,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize);
}
