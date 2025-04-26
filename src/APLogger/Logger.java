package APLogger;

import java.awt.*;

public class Logger {
    public enum Level {
        OFF(0),
        FATAL(1),
        ERROR(2),
        WARNING(3),
        INFO(4),
        DEBUG(5);

        private final int value;

        public int getValue() {
            return value;
        }

        Level(int value) {
            this.value=value;
        }
    }

    private static Logger instance = null;
    private static final Object singletonWatcher = new Object();
    private static final Object staticLogWatcher = new Object();

    public static Logger getInstance() {
        synchronized (singletonWatcher) {
            if (instance == null) {
                Level level = Level.INFO;
                try {
                    level = Level.valueOf(System.getenv("LogLevel"));
                } catch (IllegalArgumentException ex) {
                } catch (NullPointerException ex) {

                }
                instance = new Logger("GlobalLogger", level);
            }
        }
        return instance;
    }

    protected String name;
    protected Level level;

    public Logger(String name) {
        this(name, Level.INFO);
    }

    public Logger(String name, Level level) {
        this.name=name;
        this.level=level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private final Object o=new Object();

    public synchronized void log(String message, Level level) {
        //If called level is lower than logger level

        if (level.getValue() <= this.level.getValue()) {
            synchronized (staticLogWatcher) {
                System.err.print(getLevel().toString());
                System.err.print(":");
                System.err.print(" ");
                System.err.println(message);
            }
        }
    }

    public synchronized void logWithDetails(String message, Level level) {
        //If called level is lower than logger level

        if (level.getValue() <= this.level.getValue()) {
            synchronized (staticLogWatcher) {
                System.err.print(System.currentTimeMillis());
                System.err.print(" ");
                System.err.print("-");
                System.err.print(" ");
                System.err.print(getLevel().toString());
                System.err.print(":");
                System.err.print(" ");
                System.err.println(message);
            }
        }
    }
}
