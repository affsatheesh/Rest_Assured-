package API_Testing_RestAssured;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ForgetPasswordPostReq {


    @Test
    public void postRequest() throws IOException, CsvValidationException {
        FileWriter fw = new FileWriter("./Data/testout.txt");
        PrintWriter pw = new PrintWriter(fw);

        String csv_file1 = "./Data/JeemgymData.csv";
        CSVReader reader = new CSVReader(new FileReader(csv_file1));
        String[] cell = reader.readNext();
        while ((cell = reader.readNext()) != null) {

            String Email = cell[0];
            String ne = '"' + Email + '"';
            baseURI = "https://skoolgo.pixelmindit.com:6100/api/";
            String path = "{\n" +
                    "   \"email\":" + ne + "\n" +
                    "}";
            Response res = given().header("content-type", "application/json").body(path).
                    when().post("credential/forgotPassword").
                    then().and().contentType(ContentType.JSON).extract().response();

          int statuscode = res.statusCode();
          if(statuscode==200)
          {
              System.out.println("New Password Sent ==> "+ Email);
          }
          else {
              pw.println(Email);
              System.out.println("This Mail ID Unable to send the Password ==> " + Email);
          }
        }
        pw.close();
    }
}
