package com.example.project;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        // command line parameter
        if(args.length != 1) {
            System.err.println("Invalid command line, exactly one argument required");
            System.exit(1);
        }
        
        Mission m;
        try {
            Path filePath = Path.of(args[0]);
            String content = Files.readString(filePath);
            // System.out.println(content);
            m = new Mission(content);
        } catch (FileNotFoundException e) {
            String errorContent = "1 1\n1 1 N\nNOT VALID\n1 1 N\nNOT VALID\n";
            m = new Mission(errorContent);
        }

        System.out.println(m.toString());
    }
}