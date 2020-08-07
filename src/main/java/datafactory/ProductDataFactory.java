package datafactory;

import com.github.javafaker.Faker;
import dto.product.RegisterProductDTO;
import static utils.ConstantsUtils.*;

public class ProductDataFactory {

    public RegisterProductDTO buildProduct() {
        return RegisterProductDTO.builder()
                .id("1")//a API simulada já incrementa o valor
                .createdAt(Faker.instance().regexify(DATE_RDM).concat("/2020"))
                .name(Faker.instance().regexify(PRODUCT_NAME))
                .inStock(Boolean.TRUE)
                .avatar("https://s3.amazonaws.com/uifaces/faces/twitter/erwanhesry/" + Faker.instance().regexify(ID).concat(".jpg"))
                .quantity((Faker.instance().regexify(QUANTITY)))
                .build();

    }

}
