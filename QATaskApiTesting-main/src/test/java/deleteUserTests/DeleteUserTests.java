package deleteUserTests;


import io.restassured.response.Response;
import org.testng.annotations.Test;
import reponseDTOs.getUserListResponseDtos.GetUserListResponseDto;
import restAssured.RandomGenerator;
import restAssured.RestAssured;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static testSetup.TestSetup.SetupURLAndRequestParameters;

public class DeleteUserTests extends RestAssured {

    @Test
    void deleteUser() throws IOException {

        Response getUserId = getResource("/api/users", SetupURLAndRequestParameters());
        GetUserListResponseDto getUserListResponseDto = mapper.readValue(getUserId.body().asString(), GetUserListResponseDto.class);

        List<String> userIds = new ArrayList<>();
        getUserListResponseDto.getData().forEach(DataResponseDto -> {
            List<String> ids = Collections.singletonList(DataResponseDto.getId().toString());
            userIds.addAll(ids);
        });

        String userId = userIds.get(0);
        Response response = deleteResource("/api/user" + userId, SetupURLAndRequestParameters());
        assertThat(response.body().asString()).isNotEmpty();
    }

    @Test
    void deleteUserWhichNotExist() {

        Response response = deleteResource("/api/user" + RandomGenerator.generateFirstName(), SetupURLAndRequestParameters());
        assertThat(response.body().asString()).isNotEmpty();
    }
}
