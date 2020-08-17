package work1;

import java.io.File;
import java.io.IOException;

public class HtmlFileHandler extends  FileHandler {

    public HtmlFileHandler(){
        super(FileType.HTML);
    }
    @Override
    public boolean process(File file) {
        if(this.getFileExtension(file).toLowerCase().equals(this.getFileType())){
            try {
                builder.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", file.getAbsolutePath()).start();
                return true;
            }catch(IOException ex){
                return processNextHandler(file);
            }

        }
        return processNextHandler(file);
    }
}
