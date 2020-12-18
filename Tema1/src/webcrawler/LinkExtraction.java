package webcrawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * The class LinkExtraction extract the existing link from the downloaded
 * pages and add the links in queue if they aren't already added.
 *
 */

public class LinkExtraction {
    /* get the queue*/
    ProcessURL p = new ProcessURL();
    public Queue<String> q = p.getURL();

    public LinkExtraction() throws IOException {
    }

    public Queue<String> getQueue() {
        return q;
    }

    BufferedReader read = new BufferedReader(new FileReader("C:/Users/Bianca/Desktop/Proiect/Downloads/Downloads.html"));
//pe asta trebuie sa o fac sa ia ca parametru ce mi-a returnat Vicentiu !!!!
    
    public Queue<String> extractUrl( ) throws IOException {
        String line;
        while((line = read.readLine()) != null){
            String regex = "(https|http?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            while (m.find()) {
                q.add(m.group());
                q.add("\n");
            }
        }
        return q;
    }
}
