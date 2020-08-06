package dto.adress;

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
public class RegisterAdressDTO {

    private String id;
    private String createdAt;
    private String idClient;
    private String name;
    private String avatar;
    private String company;
    private String adress;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String aditional;

}
