package datafactory;

import com.github.javafaker.Faker;
import dto.product.RegisterProductDTO;
import static utils.ConstantsUtils.*;

public class ProductDataFactory {

    public RegisterProductDTO buildProduct(String name) {
        return RegisterProductDTO.builder()
                .id("")
                .createdAt(Faker.instance().regexify(DATE_RDM).concat("/2020"))
                .name(name)
                .inStock(Boolean.TRUE)
                .avatar("https://s3.amazonaws.com/uifaces/faces/twitter/erwanhesry/" + Faker.instance().regexify(ID).concat(".jpg"))
                .quantity((Faker.instance().regexify(QUANTITY)))
                .build();

    }
}
