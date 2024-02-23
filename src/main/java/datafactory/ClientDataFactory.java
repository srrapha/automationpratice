package datafactory;

import com.github.javafaker.Faker;
import dto.client.RegisterClientDTO;

import static constants.Constants.*;
import static utils.FakerGenerator.*;

public class ClientDataFactory {

    public RegisterClientDTO buildClient() {
        return RegisterClientDTO.builder()
                .id(Faker.instance().regexify(getId()))
                .createdAt(getCurrenceDate())
                .firstName(getName())
                .lastName(getLastName())
                .gender(getGender())
                .email(getMail())
                .pass(PASSWORD_CLIENT)
                .dateOfBirth(DATE_BIRTH_CLIENT)
                .newsletter(NEWSLETTER_CLIENT) // Não é uma boa prática setar o valor direto de booleanos
                .build();

    }
}
