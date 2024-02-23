package datafactory;

import dto.order.CreateOrderDTO;

import static utils.FakerGenerator.getCurrenceDate;
import static utils.FakerGenerator.getId;

public class OrderDataFactory {

    public CreateOrderDTO buildOrder() {
        return CreateOrderDTO.builder()
                .id(getId())
                .createdAt(getCurrenceDate())
                .build();

    }
}
