package webcrawler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Search {

    private String m_path;
    Logger logger = new Logger("Path");


    public Search() {
    }



    public void search(String m_path) throws IOException {
        String last_five_dig;


        File dir = new File(m_path);
        if (dir.exists()) {
            System.out.println("Introduceti cuvintele sau cuvantul cheie : ");
            Integer a = 2;

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            ArrayList<String> KeyWord_list = new ArrayList<String>();

            String[] keys = s.split(" ");
            for (String iter : keys)
                KeyWord_list.add(iter);
            int size = KeyWord_list.size();
            logger.logger("1.Au fost introduse urmatoarele cuvinte: " + s);

            for (int i = 0; i < size; i++) {
                Pattern p = Pattern.compile(KeyWord_list.get(i));
                logger.logger("\n" + a + ".Se stabileste cuvantul cheie---- " + KeyWord_list.get(i));
                a++;
                List<Integer> COUNTER = new ArrayList<Integer>();
                ArrayList<String> file_list = new ArrayList<String>();
                Integer zero = 0;
                for (File f : dir.listFiles()) {
                    if (!f.isFile()) continue;
                    try {

                        FileInputStream fis = new FileInputStream(f);
                        last_five_dig = f.getName().substring(f.getName().length() - 5);

                        if (last_five_dig.equals(".html")) {
                            logger.logger("\n" + a + ".Se veririca daca fisierul este un fisier .html " );
                            a++;
                            byte[] data = new byte[fis.available()];
                            fis.read(data);
                            String text = new String(data);
                            Matcher m = p.matcher(text);
                            Integer count = 0;
                            while (m.find()) {

                                count++;
                            }

                            if (count > 0) {

                                file_list.add(f.getName());
                                logger.logger("\n" + a + ".S-a adaugat fisierul" +f.getName()+" in lista de fisiere in care apare cuvantul cheie "+KeyWord_list.get(i));
                                a++;
                                COUNTER.add(count);
                            }
                            fis.close();
                        }

                    } catch (Exception e) {
                        System.out.print("\n\t Error processing file : " + f.getName());
                    }
                    zero = 0;
                }
                // list of files containing keyword.
                for (int k = 0; k < COUNTER.size(); k++)
                    for (int l = k; l < COUNTER.size(); l++) {
                        if (COUNTER.get(k) < COUNTER.get(l)) {
                            String aux;
                            aux = file_list.get(k);
                            file_list.set(k, file_list.get(l));
                            file_list.set(l, aux);

                            Integer aux2;
                            aux2 = COUNTER.get(k);
                            COUNTER.set(k, COUNTER.get(l));
                            COUNTER.set(l, aux2);
                        }
                    }
                logger.logger("\n" + a + ".S-a ordonat lista de fisiere in functie de numarul de aparitii al cuvintelor cheie" );
                a++;
                System.out.print("\n\t List fisierelor ordonate in functie de numarul de aparitii al cuvantulului/cuvintelor cheie : " + KeyWord_list.get(i));
                System.out.print("\t" + file_list);

            } // IF directory exists then only process.

        } else {
            System.out.print("\n Directory doesn't exist.");
        }
    }


    public void print() {
    }
}
