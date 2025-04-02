package dev.caiol.btgpactual.order_ms.adapters.input.api.response;

import java.util.List;
import java.util.Map;

public record ApiListResponse<T>(
    Map<String, Object> summary,
    List<T> data,
    PagintionResponse pagination) {
}
