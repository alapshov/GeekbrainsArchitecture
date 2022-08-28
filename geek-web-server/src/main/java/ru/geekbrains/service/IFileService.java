package ru.geekbrains.service;

public interface IFileService {
    String rootDir = null;
    boolean exists(String filename);
    boolean isDirectory(String filename);
    String readFile(String filename);
}
