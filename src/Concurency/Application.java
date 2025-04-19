package Concurency;

import APLogger.Logger;

public class Application implements Runnable{
    @Override
    public void run() {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++) {
                    Logger.getInstance().log("A", Logger.Level.INFO);
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++) {
                    Logger.getInstance().log("B", Logger.Level.INFO);
                }
            }
        });

        a.start();
        b.start();
    }
}
