package datafactory;

import com.github.javafaker.Faker;
import dto.order.CreateOrderDTO;

import static constants.Constants.*;

public class OrderDataFactory {

    public CreateOrderDTO buildOrder() {
        return CreateOrderDTO.builder()
                .id(Faker.instance().regexify(REGEX_ORDER_ID))
                .createdAt(Faker.instance().regexify(REGEX_DATE))
                .build();

    }
}
