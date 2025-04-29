package ar.utn.ddsi.logger.strategies;

import ar.utn.ddsi.logger.Error;
import ar.utn.ddsi.logger.adapters.DataBaseAdapter;
import ar.utn.ddsi.logger.utils.ObjectToMapConversor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DataBaseErrorLoggingStrategy implements ErrorLoggingStrategy{

    private DataBaseAdapter dataBaseAdapter;

    @Override
    public void logError(Error error) {
        this.dataBaseAdapter.connect();
        this.dataBaseAdapter.insert("error_log", ObjectToMapConversor.convertObjectToMap(error));
        this.dataBaseAdapter.disconnect();
    }
}
