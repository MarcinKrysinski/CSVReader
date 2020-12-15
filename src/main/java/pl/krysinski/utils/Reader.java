package pl.krysinski.utils;

import pl.krysinski.model.Gender;
import pl.krysinski.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reader {

    public List<User> readData() throws IOException {
        String file = "src/main/java/pl/krysinski/files/USERS_DATA.csv";
        List<User> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] headers = br.readLine().split(",");
            String record;
            while ((record = br.readLine()) != null) {
                String[] tokens = record.split(",");
                User user = createUser(headers, tokens);
                content.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }

    private User createUser(String[] headers, String[] tokens) {
        User user = new User();
        for (int h = 0; h < headers.length; h++) {
            if ("id".equals(headers[h])) {
                user.setId(tokens[h]);
            }
            if ("first_name".equals(headers[h])) {
                user.setFirst_name(tokens[h]);
            }
            if ("last_name".equals(headers[h])) {
                user.setLast_name(tokens[h]);
            }
            if ("email".equals(headers[h])) {
                user.setEmail(tokens[h]);
            }
            if ("gender".equals(headers[h])) {
                user.setGender(Gender.valueOf(tokens[h]));
            }
            if ("ip_address;;".equals(headers[h])) {
                String ip_address = tokens[h];
                user.setIp_address(ip_address.substring(0, ip_address.length() - 2));
            }
        }
        return user;
    }
}
