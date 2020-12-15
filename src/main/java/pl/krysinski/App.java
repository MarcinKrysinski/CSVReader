package pl.krysinski;

import pl.krysinski.model.User;
import pl.krysinski.utils.Reader;

import java.io.IOException;
import java.util.List;


public class App {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        List<User> usersList;
        usersList = reader.readData();
        System.out.print(usersList);
    }
}
