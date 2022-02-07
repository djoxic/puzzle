package registerUserTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import reponseDTOs.registerUserUnsuccessful.RegisterUserUnsuccessfulResponseDto;
import restAssured.RestAssured;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static testSetup.TestSetup.SetupURLAndRequestParameters;

public class RegisterUserUnsuccessfulTests extends RestAssured {

    @Test
    void registerUserUnsuccessful() throws IOException {

        Response response = createResourceBadRequest("/api/register", "", SetupURLAndRequestParameters());
        RegisterUserUnsuccessfulResponseDto registerUserUnsuccessfulResponseDto = mapper.readValue(response.body().asString(), RegisterUserUnsuccessfulResponseDto.class);
        assertThat(registerUserUnsuccessfulResponseDto.getError()).isEqualTo("Missing email or username");
    }
}
