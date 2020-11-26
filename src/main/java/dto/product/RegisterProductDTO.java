package dto.product;

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
public class RegisterProductDTO {

     private String id;
     private String createdAt;
     private String name;
     private String avatar;
     private Boolean inStock;
     private String quantity;

}
