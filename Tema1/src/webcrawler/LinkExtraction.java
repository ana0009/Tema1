package crawler;

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
    private Matcher mTag, mLink;
    private Pattern pTag, pLink;

    /* get the queue*/
    ProcessURL p = new ProcessURL();
    public Queue<String> q = p.getURL();

    public Queue<String> getQueue(){
        return q;
    }


    private static final String HTML_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
    private static final String HTML_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

    public LinkExtraction() throws IOException {
        pTag = Pattern.compile(HTML_TAG_PATTERN);
        pLink = Pattern.compile(HTML_HREF_TAG_PATTERN);
    }

    public void extractHTMLLinks(String first) {
        mTag = pTag.matcher(first);

        while (mTag.find()) {
            String href = mTag.group(1);     /* get the values of href*/

            mLink = pLink.matcher(href);

            while (mLink.find()) {
                String link = mLink.group(1);
                if(link != null){
                    System.out.println(link);
                }else {
                    System.out.println("Nu e");
                }
                q.add(link);
            }
        }
    }
}
