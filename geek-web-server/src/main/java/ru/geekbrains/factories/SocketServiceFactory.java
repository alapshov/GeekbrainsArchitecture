package ru.geekbrains.factories;

import ru.geekbrains.service.SocketService;
import java.net.Socket;


public class SocketServiceFactory {
    public static SocketService create(Socket socket) {
        return new SocketService(socket);
    }
}
