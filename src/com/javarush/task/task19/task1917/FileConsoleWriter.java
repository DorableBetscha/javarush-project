package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    public FileConsoleWriter (String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    //Этот конструктор принимает путь к файлу в виде строки и передает его в конструктор FileWriter.
    // Если файл не существует, он будет создан; если существует, его содержимое будет перезаписано.

    public FileConsoleWriter(String filePath, boolean append) throws IOException {
        this.fileWriter = new FileWriter(filePath, append);
    }
    //Добавление второго параметра append позволяет пользователю выбрать, следует ли добавлять данные
    // в конец файла (append = true) или перезаписывать его (append = false).

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    //Использование объекта File вместо строки пути к файлу может быть предпочтительнее во многих случаях,
    // особенно когда работа идет с относительными путями или когда необходимо использовать функциональность класса File,
    // например, проверку существования файла.

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    //Этот конструктор сочетает в себе преимущества использования объекта File и возможности выбора режима добавления данных.

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }
    //Конструктор public FileConsoleWriter(FileDescriptor fd) принимает объект FileDescriptor в качестве аргумента
    // и использует его для создания нового экземпляра FileWriter. Это позволяет записывать данные непосредственно в ресурс,
    // ассоциированный с данным дескриптором файла, без необходимости знать путь к файлу или работать с объектом File.

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf).substring(off, off + len));
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println((char) c);
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(new String(cbuf));
    }
    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }
}
