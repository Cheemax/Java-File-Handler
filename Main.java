package work1;

import javax.swing.*;
import java.io.File;



public class Main {

    public static void main(String[] args) {

        File file = getFile();
        if(file == null) {
            JOptionPane.showMessageDialog(null, "File was not selected. Program will terminate");
            System.exit(1);
        }

        FileHandler fileHandler = createChainOfHandlers();
        fileHandler.process(file);

    }

    private static FileHandler createChainOfHandlers() {
        TextFileHandler textFileHandler = new TextFileHandler();
        AstahFileHandler astahFileHandler = new AstahFileHandler();
        HtmlFileHandler htmlFileHandler = new HtmlFileHandler();
        JpgFileHandler jpgFileHandler = new JpgFileHandler();

        return FileHandler.createChain(textFileHandler, astahFileHandler, htmlFileHandler, jpgFileHandler);
    }


    private static File getFile() {
        final JFileChooser fileChooser = new JFileChooser();
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {

           final File file = fileChooser.getSelectedFile();
           return file;

        }
        return null;

    }
}
