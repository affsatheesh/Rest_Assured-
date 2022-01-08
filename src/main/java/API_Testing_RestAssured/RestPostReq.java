package API_Testing_RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestPostReq {


    @Test
    public void postRequest() {
        baseURI = "https://skoolgo.pixelmindit.com:5000/api";
        String path = "{\n" +
                "   \"periodName\":\"Seven Months\",\n" +
                "   \"periodDays\":210\n" +
                "}";
        Response res = given().header("content-type", "application/json").body(path).
                when().post("/master/addPeriod").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
        System.out.println(res.asPrettyString());

        String str = res.asPrettyString();
        JsonPath js = new JsonPath(str);
        String idDetails = js.get("response._id");
        System.out.println(idDetails);
    }
}
