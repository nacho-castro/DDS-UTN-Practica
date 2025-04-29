package ar.utn.ddsi.logger.strategies;

import ar.utn.ddsi.logger.Error;

//PATRON STRATEGY
public interface ErrorLoggingStrategy {
    public void logError(Error error);
}
