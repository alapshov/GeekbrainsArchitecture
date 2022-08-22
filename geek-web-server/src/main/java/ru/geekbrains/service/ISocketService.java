package ru.geekbrains.service;

import java.net.Socket;
import java.util.Deque;

public interface ISocketService {
    Socket socket = null;
    Deque<String> readRequest();
    void writeResponse(String rawResponse);
}
