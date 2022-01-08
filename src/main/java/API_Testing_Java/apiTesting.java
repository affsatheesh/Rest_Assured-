package API_Testing_Java;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class apiTesting {
    public static void main(String[] args) throws IOException {
        apiTesting test = new apiTesting();
        test.getRequest();
     //  test.postRequest();
      // test.putRequest();
      // test.deleteRequest();
    }

    public void getRequest() throws IOException {
        URL url = new URL("https://skoolgo.pixelmindit.com:8000/api/customTitles/getAllCustomTitles");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        int rescode = connection.getResponseCode();
        System.out.println(rescode);
        String resmessage = connection.getResponseMessage();

        System.out.println(resmessage);

        InputStream inputred = connection.getInputStream();
        InputStreamReader inputreader = new InputStreamReader(inputred);
        BufferedReader buffers = new BufferedReader(inputreader);

        String line;
        StringBuffer buff = new StringBuffer();
        while ((line = buffers.readLine()) != null) {
            buff.append(line);
        }
        System.out.println(buff);
    }


    public void postRequest() throws IOException {
        URL url = new URL("https://skoolgo.pixelmindit.com:8000/api/customTitles/addCustomTitles");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("content-type", "application/json");
        connection.setDoOutput(true);
        String jsonbody = "{\"title\":\"Hi\"}";
        byte[] bytedata = jsonbody.getBytes();

        OutputStream output = connection.getOutputStream();
        output.write(bytedata);

        System.out.println("response code =" + connection.getResponseCode());

        InputStream input = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader readers = new BufferedReader(reader);

        String line;
        StringBuffer buff = new StringBuffer();

        while ((line = readers.readLine()) != null) {
            buff.append(line);
        }
        System.out.println(buff);
    }


    public void putRequest() throws IOException {
        URL url = new URL("https://skoolgo.pixelmindit.com:8000/api/customTitles/updateCustomTitles/60b9948553d28d300454f05d");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("content-type", "application/json");
        connection.setDoOutput(true);

        String jsondata = "{\"title\":\"Hello\"}";

        byte[] bytsdata = jsondata.getBytes();

        OutputStream outputset = connection.getOutputStream();
        outputset.write(bytsdata);

        System.out.println("respose code = " + connection.getResponseCode());
        System.out.println("respose Message = " + connection.getResponseMessage());

        InputStream input = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader buff = new BufferedReader(reader);
        String line;
        StringBuffer buffers = new StringBuffer();

        while ((line = buff.readLine()) != null) {
            buffers.append(line);
        }
        System.out.println(buffers);
    }


    public void deleteRequest() throws IOException {
        URL url = new URL("https://skoolgo.pixelmindit.com:8000/api/customTitles/deleteCustomTitles/60b9948553d28d300454f05d");
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        System.out.println("respose code = "+connection.getResponseCode());
        System.out.println("respose code = "+connection.getResponseMessage());
    }
}