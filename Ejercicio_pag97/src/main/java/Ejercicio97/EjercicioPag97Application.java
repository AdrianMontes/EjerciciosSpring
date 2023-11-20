package Ejercicio97;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjercicioPag97Application {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioPag97Application.class, args);
        Logger logger = LoggerFactory.getLogger(EjercicioPag97Application.class);

        /*
         * Solo se mostrarán los 3 primeros mensajes
         * si no tocamos el application.properties.
         * La razón por la que esto ocurre es porque
         * no están configurados en el archivo
         * application.properties.
         * Para solucionar esto, hay que integrarlos
         * en dicho archivo.
         */
        logger.debug("Debug");
        logger.error("Error");
        logger.warn("Warn");
        logger.info("Info");
        logger.trace("Trace");
    }
}