package crawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;


/*
* The class ProcessURL reads the file where are stored the URLs and save
* them in a queue after checking that they have the correct format of an
* URL.This queue is returned by a function and can be used in order to
* implement other class.
 */

public class ProcessURL {
    private BufferedReader reader;
    Queue<String> URLlist = new LinkedList<>();

    public ProcessURL() {
        this.reader = null;
    }

    public ProcessURL(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedReader getReader() {
        return reader;
    }

    /* this function converts a string into an URL*/
    public String convertString(String line) throws IOException {
        URL website = new URL(line);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        return response.toString();
    }

    /*transform the string read from the file into an URL*/
    public boolean isValidURL(String urlString)
    {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /*verify if the URL is a valid one*/
    public String getLine(String line){
        String msg = "This URL is not valid!";
        if(isValidURL(line) == true){
            return line;
        }else{
            return msg;
        }
    }

    /*give the queue of URLs*/
    public Queue<String> getURL() throws IOException {
        reader = new BufferedReader(new FileReader("C:/Users/Bianca/Desktop/crawler.txt"));
        String line = reader.readLine();
        while (line != null) {
            convertString(line);
            URLlist.add(getLine(line)); /*append to the queue the URL*/
            line = reader.readLine(); /*read next line*/
        }
        reader.close();
        return URLlist;
    }

}
