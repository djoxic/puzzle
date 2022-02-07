package restAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

public class RestAssured {

    public static ObjectMapper mapper = new ObjectMapper();

    public static final int StatusOK = 200;
    public static final int BadRequest = 400;


    // POST Requests

    public static Response createResourceBadRequest(String path, Object bodyPayload, RequestSpecification request) {
        return request.given().body(bodyPayload).when().post(path).then().log().ifValidationFails()
                .statusCode(BadRequest).extract().response();
    }

    // GET Requests
    public static Response getResource(String path, RequestSpecification request) {
        return request.given().when().get(path).then().log().ifValidationFails().statusCode(StatusOK).extract()
                .response();
    }

    // DELETE Requests
    public static Response deleteResource(String path, RequestSpecification request) {
        return request.given().when().delete(path).then().log().ifValidationFails().statusCode(StatusOK).extract().response();
    }

    // CURL Requests
    public static Response queryParams(Map<String, String> parametersMap, String path, RequestSpecification request) {
        return request.queryParams(parametersMap).given().when().get(path).then().log().ifValidationFails().statusCode(StatusOK).extract().response();
    }
}
