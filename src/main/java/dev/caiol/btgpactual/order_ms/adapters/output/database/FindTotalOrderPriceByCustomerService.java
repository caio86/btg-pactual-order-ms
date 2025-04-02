package dev.caiol.btgpactual.order_ms.adapters.output.database;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.math.BigDecimal;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import dev.caiol.btgpactual.order_ms.application.ports.out.IFindTotalOrderPriceByCustomer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindTotalOrderPriceByCustomerService implements IFindTotalOrderPriceByCustomer {

  private final MongoTemplate template;

  @Override
  public BigDecimal execute(Long customerId) {
    var aggregations = newAggregation(
        match(Criteria.where("customerId").is(customerId)),
        group().sum("total").as("total")

    );

    var response = template.aggregate(aggregations, "tb_orders", Document.class);

    return new BigDecimal(response.getUniqueMappedResult().getOrDefault("total", BigDecimal.ZERO).toString());
  }

}
