package API_Testing_RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Json_Test {

    @Test
    public void jsonGet() {
        Response res = get("http://localhost:3000/Users");
        System.out.println(res.getBody().asPrettyString());
        System.out.println(res.getStatusCode());
    }

    @Test
    public void jsonGet1() {
       baseURI = "http://localhost:3000/";
        Response res = given()
                .when().get("Users");
        System.out.println(res.asPrettyString());
    }

    @Test
    public void jsonPostReq() {
        JSONObject obj = new JSONObject();
        obj.put("firstname", "New User");
        obj.put("lastname", "Jack John");
        obj.put("email", "JackJohn@gmail.com");
        Response res = given().header("content-type", "application/json").
                body(obj.toJSONString()).post("http://localhost:3000/Users");
        System.out.println(res.asPrettyString());
    }

    @Test
    public void newConcept() {
        baseURI = "http://localhost:3000/";
        ValidatableResponseOptions vel = given().
                when().get("Users").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void restPostReq() {
        JSONObject obj = new JSONObject();
        obj.put("first_name", "sabari");
        obj.put("last_name", "Nathan");
        obj.put("email", "sabarizorba@gmail.in");

        baseURI = "http://localhost:3000/";
        given().header("content-type", "application/json").body(obj.toJSONString())
                .when().post("Users").then().assertThat().statusCode(201)
                .contentType(ContentType.JSON)
                .and()
                .body("Users[0].first_name",equalTo("Michael"));
    }

    @Test
    public void restPutReq() {
        JSONObject obj1 = new JSONObject();
        obj1.put("firstname", "sabari Nathan");
        obj1.put("email", "sabarinathan001@gmail.com");
        obj1.put("lastname", "Murugan");
        baseURI = "http://localhost:3000/";
        given().header("content-type", "application/json").body(obj1.toJSONString()).
                when().put("Users/18").then().assertThat().statusCode(200);
    }

    @Test
    public void restDeleteReq() {
        baseURI = "http://localhost:3000/";
        given().header("content-type", "application/json").
                when().delete("Users/18").then().assertThat().statusCode(200);
    }

    @Test
    public void restGet() {
//      //  baseURI="https://skoolgo.pixelmindit.com:8000/api/customTitles/";
//        Response res = given().
//                when().
//                get("http://localhost:3000/Users");
//        JsonPath jp = new JsonPath(res.asPrettyString());
//        System.out.println(jp);
//        String account  =jp.get("Users[0].email").toString();
////        String account = jp.get("Users.first_name").toString();
//        System.out.println(account);
////        System.out.println(res.getBody().asPrettyString());

    }
    @Test
    public void restAPISko()
    {
        ValidatableResponse res = get("https://skoolgo.pixelmindit.com:5000/api/master/getAllPeriodForAdmin").then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("response[0].periodName",equalTo("One Day"));
        System.out.println(res.toString());
    }




}