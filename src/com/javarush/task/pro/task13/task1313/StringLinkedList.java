package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();
    private Node prev = new Node(); // облачное хранилище ссылки на предыдущий объект

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node node = new Node(); // новый объект node
        node.value = value; //присваиваем объекту node в переменную value значение value(которое помещается при обращении к методу
        if (first.next == null){ //понять первый объект или нет
            first.next = node;// присваиваем ссылку на объект node
            last.prev = node; // кладем туда ссылку на первый объект(но, это последний объект)
        }
        prev = last.prev;
        if (first != null){
            node.prev = last.prev;
        }
        prev.next = node;
        last.prev = node; //всегда кладем ссылку в последнюю очередь, не знаем, сколько будет объектов
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
