package Concurency;

import APLogger.Logger;
import Concurency.Semaphore.APSemaphore;
import University.Point;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Application implements Runnable{

    volatile Integer integer;

    @Override
    public void run() {

        PipedInputStream pipedInputStream;
        PipedOutputStream pipedOutputStream;
        APSemaphore semaphore = new APSemaphore(1, 0);

        try {
            pipedInputStream = new PipedInputStream();
            pipedOutputStream = new PipedOutputStream(pipedInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++) {
                    Logger.getInstance().log("A", Logger.Level.INFO);
                }
                try {
                    Point point = new Point(12.5,13.2);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream);
                    objectOutputStream.writeObject(point);
                    objectOutputStream.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                semaphore.release();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                semaphore.acquire();

                String result = "B";
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);
                    result = objectInputStream.readObject().toString();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                for(int i=0;i<10000;i++) {
                    Logger.getInstance().logWithDetails(result, Logger.Level.INFO);
                }
            }
        });

        MyThread myThread = new MyThread();

        a.start();
        b.start();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.next();
        myThread.interrupt();
    }
}
