package API_Testing_Unirest;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UniRest {
    public static void main(String[] args) throws UnirestException {
        UniRest rest = new UniRest();
        rest.uniRestGetRequest();
        // rest.uniRestPostRequest();
        //  rest.uniRestGettokenRequest();
        //   rest.uniRestPutRequest();
       // rest.uniRestDelete();
    }

    public void uniRestGetRequest() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://skoolgo.pixelmindit.com:8000/api/customTitles/getAllCustomTitles").asJson();
        System.out.println(" Status code = " + response.getBody());
        System.out.println(" Status Status = " + response.getStatus());
    }

    public void uniRestGettokenRequest() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("https://skoolgo.pixelmindit.com:8000/api/user/login").header("content-type", "application/json").body("{\"email\":\"admin@pixel.com\",\n" +
                "\t\"password\":\"sk12345\"\n" +
                "}").asJson();
        System.out.println(" Status code = " + response.getBody());
        System.out.println(" Status Status = " + response.getStatus());
    }

    public void uniRestPostRequest() throws UnirestException {
        // HttpResponse<JsonNode> newreq = Unirest.post("https://skoolgo.pixelmindit.com:8000/api/customTitles/addCustomTitles").body("{\"title\": \"Hii\"}").asJson();
        HttpResponse<JsonNode> newreq = Unirest.post("https://skoolgo.pixelmindit.com:8000/api/phoneCategory/addPhoneCategory").header("content-type", "application/json").body("{\"phoneType\": \"Newsss\"}").asJson();
        System.out.println(" Status code = " + newreq.getBody());
        System.out.println(" Status Status = " + newreq.getStatus());
        System.out.println(" Status Status = " + newreq.getBody());
    }

    public void uniRestPutRequest() throws UnirestException {
        HttpResponse<JsonNode> newreq = Unirest.put("https://skoolgo.pixelmindit.com:8000/api/phoneCategory/updatePhoneCategory/60bb181653d28d300454f087").header("content-type", "application/json").body("{\"phoneType\": \"Ne\"}").asJson();
        System.out.println(" Status code = " + newreq.getBody());
        System.out.println(" Status Status = " + newreq.getStatus());
        System.out.println(" Status Status = " + newreq.getBody());
    }

    public void uniRestDelete() throws UnirestException {
        HttpResponse<JsonNode> newreq = Unirest.delete("https://skoolgo.pixelmindit.com:8000/api/phoneCategory/deletePhoneCategory/60bb181653d28d300454f087").asJson();
        System.out.println(" Status code = " + newreq.getBody());
        System.out.println(" Status Status = " + newreq.getStatus());
        System.out.println(" Status Status = " + newreq.getBody());
    }
}
