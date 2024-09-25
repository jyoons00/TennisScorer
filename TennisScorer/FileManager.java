package TennisScorer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    private PrintWriter fileWriter;
    private PrintWriter consoleWriter;

    public FileManager(String filePath) {
        try {
            this.fileWriter = new PrintWriter(new FileWriter(filePath, true));
            this.consoleWriter = new PrintWriter(System.out, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printToFile(String message) {
        if (fileWriter != null) {
            fileWriter.println(message);
        }
    }

    public void printToConsole(String message) {
        if (consoleWriter != null) {
            consoleWriter.println(message);
        }
    }
    
    public void printToConsoleAndFile(String message) {
        printToConsole(message);
        printToFile(message);
    }

    public void close() {
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
