package linereader.assignment.opentext;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FileHandler {

    private final File file;
    private final Path path;
    private final LinkedList<String> linesOfFile = new LinkedList<String>();
    public FileHandler(String filePath) throws FileNotFoundException {
        path = Path.of(filePath);
        file = path.toFile();
        var br = new BufferedReader(new FileReader(file));
        br.lines().forEach(line -> {
            linesOfFile.add(line);
        });
    }

    public void save() throws IOException {
        var fileContent = String.join("\n", linesOfFile);
        Files.writeString(path,fileContent);
    }

    public void insert(int lineNumber, String line) throws Exception{
        linesOfFile.add(lineNumber - 1, line);
    }

    public void delete(int lineNumber) throws Exception {
        linesOfFile.remove(lineNumber - 1);
    }

    public void forEachLine(BiConsumer<Integer, String> action) {
        var iterator = linesOfFile.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            action.accept(++index, iterator.next());
        }
    }
}
