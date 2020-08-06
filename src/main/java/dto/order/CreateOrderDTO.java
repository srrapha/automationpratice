package dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderDTO {

    String id;
    String createdAt;
    String name;
    String avatar;
    String idClient;
    String idAdress;
    String amount;
    Boolean confirmed;


}
