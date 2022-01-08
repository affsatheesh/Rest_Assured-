package API_Testing_Unirest;

import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JavaFaker {

    public static void main(String[] arg) throws IOException {
        Faker fa = new Faker();

        FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\names.txt");
        BufferedWriter bwr = new BufferedWriter(writer);

        for(int i=1;i<=20;i++) {
            String name = fa.name().firstName();
            String number = fa.phoneNumber().cellPhone();
            bwr.write(name +" "+ number);
            bwr.write("\n");
           // bwr.write(number);
            System.out.println(name +" "+ number);
        }
        bwr.close();
    }
}
