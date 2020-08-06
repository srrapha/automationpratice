package datafactory;

import com.github.javafaker.Faker;
import dto.client.RegisterClientDTO;

import static utils.ConstantsUtils.*;

public class ClientDataFactory {

    public RegisterClientDTO buildClient(String firstname, String lastName, String gender) {
        return RegisterClientDTO.builder()
                .id(Faker.instance().regexify(ID))
                .createdAt(Faker.instance().regexify(DATE_RDM).concat("/2020"))
                .firstName(firstname)
                .lastName(lastName)
                .gender(gender)
                .email(Faker.instance().regexify(EMAIL_RDM).concat("@mail.com"))
                .pass("####")
                .dateOfBirth(Faker.instance().regexify(DATE_BIRTH_RDM).concat("/1990"))
                .newsletter(Boolean.TRUE)
                .build();

    }
}
