package Concurency;

import APLogger.Logger;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application implements Runnable{

    volatile Integer integer;

    @Override
    public void run() {

        PipedInputStream pipedInputStream;
        PipedOutputStream pipedOutputStream;

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
                PrintStream printStream = new PrintStream(pipedOutputStream);
                printStream.println("Done.");
                printStream.flush();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(pipedInputStream);
                String result = scanner.nextLine();

                for(int i=0;i<10000;i++) {
                    Logger.getInstance().logWithDetails(result, Logger.Level.INFO);
                }
            }
        });

        MyThread myThread = new MyThread();

        a.start();
        b.start();
//        myThread.start();
    }
}
