package Helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Helper {


    public static JsonPath Jsonpaths(Response res)
    {
        String response =res.asPrettyString();
        JsonPath pa = new JsonPath(response);
        return pa;
    }

    public static XmlPath xmlpaths(Response res)
    {
        String respose = res.asPrettyString();
        XmlPath path = new XmlPath(respose);
        return path;
    }

}
