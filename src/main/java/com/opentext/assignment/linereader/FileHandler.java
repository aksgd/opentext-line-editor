package com.opentext.assignment.linereader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.function.BiConsumer;

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

    public void insert(int lineNumber, String line){
        linesOfFile.add(lineNumber - 1, line);
    }

    public void delete(int lineNumber){
        linesOfFile.remove(lineNumber - 1);
    }

    public boolean isValidLine(int lineNumber) {
        return lineNumber <= linesOfFile.size() + 1 && lineNumber > 0;
    }

    public void forEachLine(BiConsumer<Integer, String> action) {
        var iterator = linesOfFile.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            action.accept(++index, iterator.next());
        }
    }
}
