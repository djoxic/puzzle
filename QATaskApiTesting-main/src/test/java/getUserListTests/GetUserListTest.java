package getUserListTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import reponseDTOs.getUserListResponseDtos.GetUserListDelayDto;
import reponseDTOs.getUserListResponseDtos.GetUserListResponseDto;
import restAssured.RestAssured;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static testSetup.TestSetup.SetupURLAndRequestParameters;

public class GetUserListTest extends RestAssured {

    @Test
    void getUserList() throws IOException {

        Response response = getResource("/api/users", SetupURLAndRequestParameters());

        GetUserListResponseDto getUserListResponseDto = mapper.readValue(response.body().asString(), GetUserListResponseDto.class);

        assertThat(getUserListResponseDto).hasNoNullFieldsOrProperties();
        assertThat(getUserListResponseDto.getSupport().getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        assertThat(getUserListResponseDto.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
        getUserListResponseDto.getData().forEach(dataResponseDto ->
                assertThat(dataResponseDto).hasNoNullFieldsOrProperties());
    }

    @Test
    void getUserListDelay() throws IOException {

        GetUserListDelayDto getUserListDelayPOJO = GetUserListDelayDto.setDelay();
        Map<String, String> getUserListDelay = GetUserListDelayDto.getUserListDelayRequestParameter(getUserListDelayPOJO);

        Response response = queryParams(getUserListDelay, "/api/users/", SetupURLAndRequestParameters());

        GetUserListResponseDto getUserListResponseDto = mapper.readValue(response.body().asString(), GetUserListResponseDto.class);

        assertThat(getUserListResponseDto).hasNoNullFieldsOrProperties();
        assertThat(getUserListResponseDto.getSupport().getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");
        assertThat(getUserListResponseDto.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
        getUserListResponseDto.getData().forEach(dataResponseDto ->
                assertThat(dataResponseDto).hasNoNullFieldsOrProperties());
    }
}
