package builder_pattern;

// Abstract Handler
abstract class Logger {
    protected Logger nextLogger; // Next logger in the chain
    protected int level;         // Log level

    // Set the next logger in the chain
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    // Process the log request
    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message); // Abstract method for logging
}

// Concrete Handlers
class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = 1;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}

class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = 2;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = 3;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}

// Client
public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Create loggers
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Build the chain
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        // Pass log requests
        System.out.println("Test 1: INFO Level");
        infoLogger.logMessage(1, "This is an info message.");

        System.out.println("\nTest 2: DEBUG Level");
        infoLogger.logMessage(2, "This is a debug message.");

        System.out.println("\nTest 3: ERROR Level");
        infoLogger.logMessage(3, "This is an error message.");
    }
}

