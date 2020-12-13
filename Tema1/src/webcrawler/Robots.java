package webcrawler;

import java.util.Collections;
import java.util.List;

public class Robots implements  IRobots{

    private String UserAgent;
    private String Path;
    private String ISDissallow;
    private List<String>UserAgents;
    private List<String> DissalowList;

    @Override
    public boolean query(String userAgent, String path) {
        return false;
    }

    @Override
    public List<String> getDissalowList(String userAgent) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<String> getUserAgents() {
        return UserAgents;
    }

    @Override
    public void ReadFile(String filename) {

    }


}

