package Concurency;

import APLogger.Logger;

public class MyThread extends Thread{
    @Override
    public void run() {
//        Logger logger = new Logger("MyLogger");
        Logger logger = Logger.getInstance();
        super.run();

        for(int i=0;i<10000;i++) {
            logger.log("M", Logger.Level.INFO);
        }
    }
}
