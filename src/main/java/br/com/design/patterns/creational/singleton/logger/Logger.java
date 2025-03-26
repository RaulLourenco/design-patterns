package br.com.design.patterns.creational.singleton.logger;

public class Logger {
    private static final Logger instance = new Logger();

    private Logger() {}

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

class LoggerApplication {
    public static void main(String[] args) {
        Logger.getInstance().log("Starting the application.");
    }
}
