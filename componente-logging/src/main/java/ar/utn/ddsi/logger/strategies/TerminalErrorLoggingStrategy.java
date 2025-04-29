package ar.utn.ddsi.logger.strategies;

import ar.utn.ddsi.logger.Error;

import java.time.format.DateTimeFormatter;

//CREAR ERROR POR TERMINAL
public class TerminalErrorLoggingStrategy implements ErrorLoggingStrategy {

  @Override
  public void logError(Error error) {
    System.out.printf("Message: %s, Stacktrace: %s, Timestamp: %s%n",
        error.getMessage(),
        error.getStackTrace(),
        error.getTimestamp().format(DateTimeFormatter.BASIC_ISO_DATE)
    );
  }
}
