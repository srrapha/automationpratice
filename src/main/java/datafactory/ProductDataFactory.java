package datafactory;

import dto.product.RegisterProductDTO;
import static constants.Constants.*;
import static utils.FakerGenerator.*;

public class ProductDataFactory {

    public RegisterProductDTO buildProduct() {
        return RegisterProductDTO.builder()
                .id(getId())
                .createdAt(getCurrenceDate())
                .name(getProduct())
                .inStock(IN_STOCK_PRODUCT)
                .avatar(getAvatar())
                .quantity(getQuantity())
                .build();
    }

}
