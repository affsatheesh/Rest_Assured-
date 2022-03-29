package API_Testing_RestAssured;

import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class AR {

    public static void main (String [] arg)
    {
/*       Response rs = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
       String stat = rs.asPrettyString();
      int statuscode =  rs.statusCode();
       System.out.println(stat);

        if(statuscode==200)
        {
            System.out.println("Its working");
        }*/

        getRequest();
      //  postRequest();
    }

    public static void getRequest()
    {
       RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        Response rs = RestAssured.given().header("content-Type","application/json").when().
                get("/employees").then().assertThat().statusCode(200).extract().response();
        System.out.println(rs.toString());
    }

    public static void postRequest() {
        String path = "{\"email\": \"ce@pixelmindit.com\",\n" +
                " \"password\": \"sk12345\"}";

        RestAssured.baseURI = "https://skoolgo.pixelmindit.com:7860/api/credential";
        Response rs = RestAssured.given().header("content-Type", "application/json").body(path)
                .when().post("/login").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                extract().response();

        System.out.println(rs.asPrettyString());

    }
}
