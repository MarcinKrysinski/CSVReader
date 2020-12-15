package pl.krysinski;

import java.io.IOException;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws IOException {
        Reader reader = new Reader();
        List<String[]> usersList;
        usersList = reader.readData();
        System.out.print(usersList);
    }
}
