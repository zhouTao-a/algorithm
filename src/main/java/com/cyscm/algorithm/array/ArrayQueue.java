package com.cyscm.algorithm.array;

import java.util.Scanner;

/**
 * 使用数组实现队列功能
 * @author zhoutao
 */
public class ArrayQueue {
    public static void main(String[] args) {
        QueueAnnular queue = new QueueAnnular(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出
        while (loop) {
            System.out.println("s(select): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("p(push): 添加数据到队列");
            System.out.println("g(get): 显示头部队列");
            System.out.println("o(pop): 从队列取出数据");
            //接受一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.select();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'p':
                    System.out.println("输入一个数");
                    int val = scanner.nextInt();
                    try {
                        queue.push(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    System.out.printf("头部数字为 %d \n", queue.get());
                    break;
                case 'o':
                    queue.pop();
                    break;
                default:
                    break;
            }
        }

    }
}

/**
 * 环形队列
 * 1、front == rear%maxSize 空数组
 */
class QueueAnnular{
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;
    /**
     * 构造函数
     * front 队列前标记
     * rear 队列后标记
     */
    QueueAnnular(int maxSize){
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }

    /**
     * front、rear相等时为空数组
     * @return
     */
    boolean isEmpty(){
        return front == rear;
    }

    /**
     * rear = maxSize - 1时数组满
     * @return
     */
    boolean isFull(){
        return front == rear - maxSize;
    }

    /**
     * 添加
     */
    void push(int number){
        if (isFull()) {
            throw new RuntimeException("数组已满，不能继续添加");
        }
        //添加元素
        queue[rear++%maxSize] = number;
        System.out.println("添加成功");
    }

    /**pp
     * 返回第front列数据
     */
    int get(){
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        return queue[front%maxSize];
    }

    /**
     * 移除第front列数据
     */
    void pop(){
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        ++front;
        System.out.println("移除成功");
    }

    /**
     * 查看所有元素
     */
    void select(){
        System.out.println("front = " + front + ", rear = " + rear);
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        for (int i = 0; i < rear - front; i++) {
            System.out.println("int[" + i +"]:" + queue[(rear - i)%maxSize] );
        }
    }
}

class Queue{
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;
    /**
     * 构造函数
     * front 队列前标记
     * rear 队列后标记
     */
    Queue(int maxSize){
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
    }

    /**
     * front、rear相等时为空数组
     * @return
     */
    boolean isEmpty(){
        return front == rear;
    }

    /**
     * rear = maxSize - 1时数组满
     * @return
     */
    boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 添加
     */
    void push(int number){
        if (isFull()) {
            throw new RuntimeException("数组已满，不能继续添加");
        }
        //添加元素
        queue[++rear] = number;
        System.out.println("添加成功");
    }

    /**
     * 返回第front列数据
     */
    int get(){
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        return queue[front + 1];
    }

    /**
     * 移除第front列数据
     */
    void pop(){
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        ++front;
        System.out.println("移除成功");
    }

    /**
     * 查看所有元素
     */
    void select(){
        if (isEmpty()) {
            System.out.println("数组为空，不能获取元素");
        }
        for (int i = 0; i < rear - front; i++) {
            System.out.println("int[" + i +"]:" + queue[front + i + 1] );
        }
    }
}