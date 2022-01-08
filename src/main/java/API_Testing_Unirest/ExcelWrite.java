package API_Testing_Unirest;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelWrite {
    public static void main(String[] arg) throws IOException {
        FileWriter file = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\names.csv");
        CSVWriter write = new CSVWriter(file);
        Faker fa = new Faker();
        String[] set = {"StudentID", "Studentname", "number", "country", "bloodGroup", "course", "bookID", "book", "genre", "author", "Bookprice", "Discount"};
        write.writeNext(set);

        for (int i = 1; i <= 100; i++) {
            String StudentID = fa.number().digits(5);
            String Studentname = fa.name().firstName();
            String bloodGroup = fa.name().bloodGroup();
            String genre = fa.book().genre();
            String course = fa.educator().course();
            String book = fa.book().title();
            String author = fa.book().author();
            String number = fa.phoneNumber().cellPhone().trim();
            String country = fa.country().name();
            String bookID = fa.number().digits(6);
            String Bookprice = fa.number().digits(4);
            String Discount = fa.number().digits(2);

            String[] set1 = {StudentID, Studentname, number, country, bloodGroup, course, bookID, book, genre, author, Bookprice, Discount};
            write.writeNext(set1);
        }
        write.flush();
    }
}

