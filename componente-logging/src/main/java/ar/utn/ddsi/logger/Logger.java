package ar.utn.ddsi.logger;

import ar.utn.ddsi.logger.strategies.ErrorLoggingStrategy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Logger {
    @Setter
    private ErrorLoggingStrategy errorLoggingStrategy;
    //ESTRATEGIA DE LOGGEO A UTILIZAR

    public void log(Error error){
        this.errorLoggingStrategy.logError(error);
    }
}
