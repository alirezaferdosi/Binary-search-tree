package com.example.javaproject;

public class queue {
    private int front = 0;
    private int rear = 0;
    private int size = 100;
    private Object[] Data = new Object[100];

    boolean isEmpty(){
        return front == rear;
    }
    boolean isFull(){
        return front == (rear + 1)%size;
    }

    void add(Object item){
        if(isFull())return;
        else{
            Data[rear] = item;
            rear = (rear + 1)%size;

        }
    }

    Object remove(){
        if(isEmpty()) return null;
        else{
            Object item = Data[front];
            front = (front + 1)%size;
            return item;
        }
    }
}
