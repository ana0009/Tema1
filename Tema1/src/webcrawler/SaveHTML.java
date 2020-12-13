package webcrawler;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;

public class SaveHTML {

    public static void save_html(String web_page)
    {
        try {
            String line;
            BufferedWriter writer;
            BufferedReader readr;
            URL url = new URL(web_page);


            System.out.println("Successfully Downloaded!");
        }

        // Exceptions
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

}
