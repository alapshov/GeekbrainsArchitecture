package ru.geekbrains;

import java.io.BufferedReader;
import java.io.IOException;

public class Handler {

    public String[] getPartsReadLine(BufferedReader input) throws IOException {
        while (!input.ready());

        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");
        System.out.println(firstLine);
        while (input.ready()) {
            System.out.println(input.readLine());
        }

        return parts;
    }
}
