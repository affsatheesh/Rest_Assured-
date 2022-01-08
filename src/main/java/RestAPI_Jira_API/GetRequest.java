package RestAPI_Jira_API;

import Configuration.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class GetRequest {
    @Test
    public void getAllUsers() throws IOException {
      String  baseurl = Base.prop().getProperty("BaseURI");
        baseURI = baseurl;
        Response res = given().header("content-Type", "application/json").header("Cookie", "JSESSIONID=" + Base.cookies()).
                when().get("/rest/api/2/issuetype").
                then().statusCode(200).extract().response();
        System.out.println(res.asPrettyString());
    }

    @Test
    public void postRequest() throws IOException {
        String  baseurl = Base.prop().getProperty("BaseURI");
        baseURI = baseurl;
        given().header("content-Type","application/Json").header("Cookie", "JSESSIONID=" + Base.cookies()).
                body(
                        "{\n" +
                                "   \"fields\":{\n" +
                                "      \"project\":\n" +
                                "      {\n" +
                                "         \"key\": \"SKOOLGO\"\n" +
                                "      },\n" +
                                "      \"summary\": \"This is Automation Test\",\n" +
                                "      \"description\": \"He is a talent\",\n" +
                                "      \"issuetype\": {\n" +
                                "         \"name\":\"Bug\"\n" +
                                "      }\n" +
                                "   }\n" +
                                "}"
                ).
                when().post("/rest/api/2/issue").then().assertThat().statusCode(201);
    }
    @Test
    public void getOneUser() throws IOException {
        String  baseurl = Base.prop().getProperty("BaseURI");
        baseURI = baseurl;
       Response res = given().header("content-Type","application/Json").header("Cookie", "JSESSIONID=" + Base.cookies()).
                when().get("/rest/api/2/issue/10002").then().extract().response();
      System.out.println(res.asPrettyString());
    }

    @Test
    public void deleteRequest() throws IOException {
        String  baseurl = Base.prop().getProperty("BaseURI");
        baseURI = baseurl;
        given().header("content-Type","application/Json").header("Cookie", "JSESSIONID=" + Base.cookies()).
                when().delete("/rest/api/2/issue/10003").then().statusCode(204);
    }

    @Test
    public void updateRequest() throws IOException {
        String  baseurl = Base.prop().getProperty("BaseURI");
        baseURI = baseurl;
        given().header("content-Type","application/Json").header("Cookie", "JSESSIONID=" + Base.cookies()).
                body(
                        "{\n" +
                                "    \"body\": \"I Just Tried to Update the Comments in Automation.\",\n" +
                                "    \"visibility\": {\n" +
                                "        \"type\": \"role\",\n" +
                                "        \"value\": \"Administrators\"\n" +
                                "    }\n" +
                                "}"
                ).
                when().put("/rest/api/2/issue/10100/comment/10002");

    }

}
