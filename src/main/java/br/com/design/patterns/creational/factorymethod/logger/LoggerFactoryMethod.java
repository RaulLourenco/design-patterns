package br.com.design.patterns.creational.factorymethod.logger;

abstract class Logger {
    abstract Logging createLogger();
    void log() {
        Logging logging = createLogger();
        logging.log();
    };
}

class FileLogger extends Logger {

    @Override
    Logging createLogger() {
        return new FileLogging();
    }
}

class DatabaseLogger extends Logger {

    @Override
    Logging createLogger() {
        return new DatabaseLogging();
    }
}

interface Logging {
    void log();
}

class FileLogging implements Logging {

    @Override
    public void log() {
        System.out.println("Logging through a file.");
    }
}

class DatabaseLogging implements Logging {

    @Override
    public void log() {
        System.out.println("Logging through a database.");
    }
}

class LoggerFactoryMethod {
    private static Logger logger;

    static void initialize() {
        String loggerChoice = "file";

        if(loggerChoice.equals("file")) {
            logger = new FileLogger();
        } else {
            logger = new DatabaseLogger();
        }
    }
    public static void main(String[] args) {
        initialize();
        logger.log();
    }
}
