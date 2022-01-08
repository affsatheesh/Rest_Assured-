package API_Testing_RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestDeleteReq {

    @Test
    public void deleteReq() {
        baseURI = "http://localhost:3000";
        Response res = given().header("content-type", "application/json").
                when().get("/Users");
        String srt = res.asPrettyString();
        System.out.println(srt);
    }

    @Test
    public void getData()
    {
        baseURI = "http://localhost:3000";
        given().header("content-Type","application/json").
                when().get("/Users").then().statusCode(200).body("id[0]",equalTo(7)).
                                                               body("first_name[0]",equalTo("Michael"));
    }

    @Test
    public void PostReq() {

        baseURI = "http://localhost:3000";
        String path = "{\n" +
                "        \"email\": \"NiceTest@gmail.com\",\n" +
                "        \"first_name\": \"GOOD\",\n" +
                "        \"last_name\": \"KA\"\n" +
                "    }";
        Response res = given().header("content-Type", "application/json").body(path).
                when().post("/Users").then().assertThat().statusCode(201).and().contentType(ContentType.JSON).extract().response();
        String srt1 = res.asPrettyString();
        System.out.println(srt1);

        JsonPath js = new JsonPath(srt1);
        String userID = js.get("last_name");
        String userID1 = js.get("first_name");
        int userID2 = js.get("id");
        System.out.println(userID);
        System.out.println(userID1);
        System.out.println(userID2);

        given().header("content-Type","application/json").when().delete("/Users/"+userID2).
                then().assertThat().statusCode(200);
    }

}
