package reponseDTOs.getUserListResponseDtos;

import lombok.Data;
import restAssured.RandomGenerator;

import java.util.HashMap;
import java.util.Map;

@Data
public class GetUserListDelayDto {

    private Integer delay;

    public static GetUserListDelayDto setDelay() {

        GetUserListDelayDto getUserListDelayDto = new GetUserListDelayDto();
        getUserListDelayDto.setDelay(RandomGenerator.generateRandomNumber(5, 1));
        return getUserListDelayDto;
    }

    public static Map<String, String> getUserListDelayRequestParameter(GetUserListDelayDto getUserListDelayDto) {

        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("delay", getUserListDelayDto.getDelay().toString());
        return parameterMap;
    }
}
