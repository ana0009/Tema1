package webcrawler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
         ProcessURL p = new ProcessURL();
         p.getURL();

        // LinkExtraction e = new LinkExtraction();
        // System.out.println(e.extractUrl());
         //System.out.println(p.getURL());
        //SaveHTML s = new SaveHTML();
       // s.DownloadWebPage("https://en.wikipedia.org/wiki/Java_(programming_language)");
    }


}
