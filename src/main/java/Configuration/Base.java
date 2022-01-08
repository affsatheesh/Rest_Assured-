package Configuration;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import Helpers.Helper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.*;

public class Base {

    public static Properties prop() throws IOException {
        Properties  pro = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\API_Pro.properties");
        pro.load(file);
        return pro;
    }


    public static String cookies() throws IOException {
        baseURI=prop().getProperty("BaseURI");
       Response res = given().header("content-Type","application/json").body(
                "{ \"username\": \"affsatheesh\", \"password\": \"worldend\" }"
        ).when().post("/rest/auth/1/session").then().statusCode(200).extract().response();

        JsonPath paths = Helper.Jsonpaths(res);
//       String str = res.asPrettyString();
//        JsonPath paths = new JsonPath(str);
       String nepath = paths.get("session.value");
       System.out.println(nepath);
       return nepath;
    }


}
