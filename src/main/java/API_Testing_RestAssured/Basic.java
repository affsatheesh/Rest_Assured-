package API_Testing_RestAssured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic
{

    public static void main (String [] arg) {

        Basic bas = new Basic();
      //  bas.getRequest();
       // bas.PostRequest();
    }

      public void getRequest() {
        Response res = RestAssured.get("https://skoolgo.pixelmindit.com:5000/api/master/getAllPeriodForAdmin");
        System.out.println(res.getBody().asPrettyString());
        System.out.println(res.getStatusCode());
    }


    public void PostRequest() {

      Response ress =  RestAssured.get("http://localhost:4000/api/scheduling/getAllVisaForAdmin");
        RequestSpecification httpRequest = RestAssured.given();
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGI0YTFkMjg2ZmE0ZDNkMTQwM2MwN2MiLCJlbXBsb3llZUlkIjoiIiwicm9sZSI6IlN5c3RlbSBBZG1pbiIsInN0YXR1cyI6dHJ1ZSwibm90aWZ5X1Rva2VuIjoiIiwiaWF0IjoxNjIzMjg1MzQxLCJleHAiOjE2MjMzNzE3NDF9.lAA-bjSzPeDmMVE1K8-F2QCe9c64dUe3Znkc8BLTtjM";
        httpRequest.header("Authorization", "Bearer " + token);
        System.out.println(ress.getBody().asPrettyString());
        System.out.println(ress.getStatusCode());
    }




}
