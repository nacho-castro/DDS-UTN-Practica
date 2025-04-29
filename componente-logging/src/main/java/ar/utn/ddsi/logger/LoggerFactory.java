package ar.utn.ddsi.logger;

import ar.utn.ddsi.logger.adapters.MongoDataBaseAdapter;
import ar.utn.ddsi.logger.adapters.MySQLDataBaseAdapter;
import ar.utn.ddsi.logger.strategies.DataBaseErrorLoggingStrategy;
import ar.utn.ddsi.logger.strategies.ErrorLoggingStrategy;
import ar.utn.ddsi.logger.strategies.FileErrorLoggingStrategy;
import ar.utn.ddsi.logger.strategies.TerminalErrorLoggingStrategy;

public class LoggerFactory {

    //funciona como inyector para el logger

    public static Logger createTerminalLogger(){
        return new Logger(createTerminalStrategy());
    }

    public static Logger createFileLogger(){
        return new Logger(createFileStrategy());
    }

    public static Logger createMySQLLogger(){
        return new Logger(createMySQLStrategy());
    }

    public static Logger createMongoDBLogger(){
        return new Logger(createMongoDBStrategy());
    }

    //SWITCH
    public static Logger switchToFile(Logger logger){
        logger.setErrorLoggingStrategy(createFileStrategy());
        return logger;
    }

    public static Logger switchToTerminal(Logger logger){
        logger.setErrorLoggingStrategy(createTerminalStrategy());
        return logger;
    }

    public static Logger switchToMYSQL(Logger logger){
        logger.setErrorLoggingStrategy(createMySQLStrategy());
        return logger;
    }

    public static Logger switchToMongoDB(Logger logger){
        logger.setErrorLoggingStrategy(createMongoDBStrategy());
        return logger;
    }

    //STRATEGIES
    private static ErrorLoggingStrategy createTerminalStrategy(){
        return new TerminalErrorLoggingStrategy();
    }

    private static ErrorLoggingStrategy createFileStrategy(){
        return new FileErrorLoggingStrategy();
    }

    private static ErrorLoggingStrategy createMySQLStrategy() {
        return new DataBaseErrorLoggingStrategy(new MySQLDataBaseAdapter());
    }

    private static ErrorLoggingStrategy createMongoDBStrategy() {
        return new DataBaseErrorLoggingStrategy(new MongoDataBaseAdapter());
    }
}
