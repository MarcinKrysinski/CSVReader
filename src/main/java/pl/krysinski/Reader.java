package pl.krysinski;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<String[]> readData() throws IOException {
        String file = "src/main/java/pl/krysinski/USERS_DATA.csv";
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new
                FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }
}
