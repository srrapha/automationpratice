package datafactory;

import com.github.javafaker.Faker;
import dto.product.RegisterProductDTO;
import static utils.ConstantsUtils.*;

public class ProductDataFactory {

    public RegisterProductDTO buildProduct() {
        return RegisterProductDTO.builder()
                .id(Faker.instance().regexify(REGEX_PRODUCT_ID))//a API simulada já incrementa o valor
                .createdAt(Faker.instance().regexify(REGEX_DATE))
                .name(Faker.instance().regexify(REGEX_PRODUCT_NAME))
                .inStock(IN_STOCK_PRODUCT)
                .avatar(PRODUCT_AVATAR + Faker.instance().regexify(REGEX_PRODUCT_ID).concat(EXTENSAO_IMAGEM))
                .quantity((Faker.instance().regexify(REGEX_QUANTITY)))
                .build();
    }

}
