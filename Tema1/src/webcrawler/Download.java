package webcrawler;

import java.io.*;
import java.net.*;

public class Download {
    final static int size = 2048;

    public static void URLfile(String file_Address, String dest_dir, String localFileName) {

        InputStream in_stream = null;
        OutputStream out_stream = null;
        URLConnection conn = null;

        try {

            URL url;
            byte[] buffer;
            int byte_read, byte_written = 0;
            url = new URL(file_Address);

            out_stream = new BufferedOutputStream(new FileOutputStream(dest_dir + "\\" + localFileName));

            conn = url.openConnection();
            in_stream = conn.getInputStream();
            buffer = new byte[size];

            System.out.println("Successfully Downloaded!");
            System.out.println("File name:\"" + localFileName + "\"\nNo ofbytes :" + byte_written);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileDownload(String file_Address, String dest_dir) {
        int slash = file_Address.lastIndexOf('/');
        int punct = file_Address.lastIndexOf('.');

        String file_name = file_Address.substring(slash + 1);

        if (punct >= 1 && slash >= 0 && slash < file_Address.length() - 1) {
            URLfile(file_Address, dest_dir, file_name);
        } else {
            System.err.println("Path or filename");
        }
    }

}