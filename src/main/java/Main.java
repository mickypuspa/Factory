

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class Main {

    //Implementing Log4j
    static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();


        //Command C1
        Command c = Factory.getInstance().getCommand("C1"); // Classloader (C1)
        logger.info("C1 por primera vez");
        c.execute();
        c =  Factory.getInstance().getCommand("C1");  // Cache (C1)
        logger.info("C1 desde Cache");
        c.execute();

        //Command C2
        Command c2 = Factory.getInstance().getCommand("C2"); // Classloader (C2)
        logger.info("C2 por primera vez");
        c2.execute();
        c2 =  Factory.getInstance().getCommand("C2");  // Cache (C2)
        logger.info("C2 desde Cache");
        c2.execute();


        //Ejecucion directa del Singleton de la Factory en C1 y C2

        logger.info("Ejecucion directa C1");
        Factory.getInstance().getCommand("C1").execute();

        logger.info("Ejecucion directa C2");
        Factory.getInstance().getCommand("C2").execute();
    }
}
