package work1;

import java.io.File;
import java.io.IOException;

public class TextFileHandler extends FileHandler {

    public TextFileHandler(){
        super(FileType.TEXT);
    }
    @Override
    public boolean process(File file) {

        if(this.getFileExtension(file).toLowerCase().equals(this.getFileType())){
            try {
                builder.command(System.getenv("SystemRoot") + "\\system32\\notepad.exe", file.getAbsolutePath()).start();
                return true;
            }catch(IOException ex){
                return processNextHandler(file);
            }

        }
        return processNextHandler(file);
    }

}
