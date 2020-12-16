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

    private User createUser(String[] headers, String[] value) {
        User user = new User();
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals("id")) {
                user.setId(value[i]);
            }
            if (headers[i].equals("first_name")) {
                user.setFirst_name(value[i]);
            }
            if (headers[i].equals("last_name")) {
                user.setLast_name(value[i]);
            }
            if (headers[i].equals("email")) {
                user.setEmail(value[i]);
            }
            if (headers[i].equals("gender")) {
                user.setGender(Gender.valueOf(value[i]));
            }
            if (headers[i].equals("ip_address")) {
                String ip_address = value[i];
                user.setIp_address(ip_address.substring(0, ip_address.length() - 2));
            }
        }
        return user;
    }
}
