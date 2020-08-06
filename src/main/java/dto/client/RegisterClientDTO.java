package dto.client;

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
public class RegisterClientDTO {

    private String id;
    private String createdAt;
    private String firstName;
    private String lastName;
    private String gender;
    private String name;
    private String avatar;
    private String email;
    private String pass;
    private String dateOfBirth;
    private Boolean newsletter;

}
