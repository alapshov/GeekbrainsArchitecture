package ru.geekbrains.factories;

import ru.geekbrains.service.FileService;

public class FileServiceFactory {
    public static FileService create(String config) {
        return new FileService(config);
    }
}
