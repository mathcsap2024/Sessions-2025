package Concurency;

import APLogger.Logger;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();

//        Logger logger = new Logger("MyLogger");
        Logger logger = Logger.getInstance();
        logger.log("Entered run method.", Logger.Level.INFO);
        while(!interrupted()) {
            try {
                logger.log("Going to sleep ...", Logger.Level.INFO);
                sleep(1000);
            } catch (InterruptedException e) {
                logger.log("Thread is interrupted.", Logger.Level.INFO);
                break;
            }
        }
//        interrupted();

        for(int i=0;i<10000;i++) {
            logger.log("M", Logger.Level.INFO);
        }
    }
}
