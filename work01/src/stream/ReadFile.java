package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        reader.lines().forEach(System.out::println);
        reader.close();
    }

}
