package datafactory;

import com.github.javafaker.Faker;
import dto.SimulationZipJsonDTO;
import dto.adress.RegisterAdressDTO;
import utils.GeneralUtils;

import static constants.Constants.*;
import static constants.Regex.REGEX_ADRESS_ADICIONAL;
import static utils.FakerGenerator.*;

public class AdressDataFactory extends GeneralUtils {
    
    public RegisterAdressDTO buildAdress(SimulationZipJsonDTO dataAdress
    ) {
        String clientId = getId();
        return RegisterAdressDTO.builder()
                .id(clientId)
                .createdAt(getCurrenceDate())
                .idClient(clientId)
                .name(Faker.instance().artist().toString())
                .company(COMPANY)
                .adress(dataAdress.getLogradouro())
                .city(dataAdress.getLocalidade())
                .state(dataAdress.getUf())
                .zip(ADRESS_ZIP)
                .country(COUNTRY)
                .aditional(Faker.instance().regexify(REGEX_ADRESS_ADICIONAL))
                .build();

    }

}
