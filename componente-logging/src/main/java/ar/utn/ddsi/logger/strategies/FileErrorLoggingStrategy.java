package ar.utn.ddsi.logger.strategies;

import ar.utn.ddsi.logger.Error;

public class FileErrorLoggingStrategy implements ErrorLoggingStrategy{

    @Override
    public void logError(Error error) {
        //TODO ESCRIBIR ARCHIVO .JSON, .CSV...
    }
}
