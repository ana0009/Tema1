package webcrawler;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Logger {
    String m_mesaj;
    String m_path;
    FileHandler fh;
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger("MyLog");


    public Logger(String m_path) {
        try {
            fh = new FileHandler(m_path, false);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void logger(String m_mesaj) {logger.info(m_mesaj);}

    public void print() {

    }
}
