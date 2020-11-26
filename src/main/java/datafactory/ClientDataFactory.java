package datafactory;

import com.github.javafaker.Faker;
import dto.client.RegisterClientDTO;

import static constants.Constants.*;

public class ClientDataFactory {

    public RegisterClientDTO buildClient() {
        return RegisterClientDTO.builder()
                .id(Faker.instance().regexify(REGEX_CLIENT_ID))
                .createdAt(Faker.instance().regexify(REGEX_DATE))
                .firstName(Faker.instance().dragonBall().character())
                .lastName(Faker.instance().regexify(REGEX_LAST_NAME_CLIENT))
                .gender(Faker.instance().regexify(REGEX_GENDER_CLIENT))
                .email(Faker.instance().regexify(REGEX_EMAIL_CLIENT).concat(SUFIXO_EMAIL))
                .pass(PASSWORD_CLIENT)
                .dateOfBirth(Faker.instance().regexify(DATE_BIRTH_CLIENT))
                .newsletter(NEWSLETTER_CLIENT) // Não é uma boa prática setar o valor direto de booleanos
                .build();

    }
}
