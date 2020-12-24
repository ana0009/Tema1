package webcrawler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public interface IRobots {

    boolean query (String userAgent, String path);
    List<String> getDissalowList(String userAgent);

    public List<String> getUserAgents();
    public void ReadFile(String filename);
}
