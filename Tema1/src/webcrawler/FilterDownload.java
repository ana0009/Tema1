package webcrawler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterDownload {

    public static void main(String[] args) {

        try {

            String[] extensions = {"doc", "pdf", "docx"};
            List<String> files = findFiles(Paths.get("F:\\~CURSURI~\\ANUL IV\\IP\\Proiect IP\\Implementare_AndreiP"), extensions);
            files.forEach(x -> System.out.println(x));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> findFiles(Path path, String[] fileExtensions) throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;
        try (Stream<Path> walk = Files.walk(path, 1)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    // convert path to string
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> isEndWith(f, fileExtensions))
                    .collect(Collectors.toList());
        }
        return result;

    }

    private static boolean isEndWith(String file, String[] fileExtensions) {
        boolean result = false;
        for (String fileExtension : fileExtensions) {
            if (file.endsWith(fileExtension)) {
                result = true;
                break;
            }
        }
        return result;
    }

}