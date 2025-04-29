package ar.utn.ddsi.logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Logger logger = new Logger(new TerminalErrorLoggingStrategy());
        //No es correcto ya que expongo la estrategia.
        //Dificulta la instanciacion.
        //Obliga a pasar clases asociadas (DB).

        //APARECE PATRON FACTORY
        Logger logger = LoggerFactory.createTerminalLogger();
        logger.log(Error.of("MENSAJE"));

        LoggerFactory.switchToFile(logger);


    }
}
