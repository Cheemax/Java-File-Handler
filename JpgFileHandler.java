package work1;

import java.io.File;
import java.io.IOException;

public class JpgFileHandler extends FileHandler {

    public JpgFileHandler(){
        super(FileType.JPG);
    }
    @Override
    public boolean process(File file) {
        if(this.getFileExtension(file).toLowerCase().equals(this.getFileType())){
            try {
                builder.command("C:\\WINDOWS\\system32\\mspaint.exe", file.getAbsolutePath()).start();
                return true;
            }catch(IOException ex){
                return processNextHandler(file);
            }

        }
        return processNextHandler(file);
    }
}
