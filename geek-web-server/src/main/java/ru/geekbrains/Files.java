package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files {
    public void fileRead(String folder, String[] parts, PrintWriter output) throws IOException {
        Path path = Paths.get(folder, parts[1]);
        if (!java.nio.file.Files.exists(path)) {
            output.println("HTTP/1.1 404 NOT_FOUND");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();
            output.println("<h1>Файл не найден!</h1>");
            output.flush();
            return;
        }
        output.println("HTTP/1.1 200 OK");
        output.println("Content-Type: text/html; charset=utf-8");
        output.println();
        java.nio.file.Files.newBufferedReader(path).transferTo(output);
        System.out.println("Client disconnected!");
    }
}
