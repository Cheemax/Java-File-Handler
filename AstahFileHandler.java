package work1;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class AstahFileHandler extends FileHandler {
   public AstahFileHandler(){
       super(FileType.ASTA);
   }
    @Override
    public boolean process(File file) {
        if(this.getFileExtension(file).toLowerCase().equals(this.getFileType())){
            try {
                builder.command("C:\\Program Files\\astah-professional\\astah-pro.exe", file.getAbsolutePath()).start();
                return true;
            }catch(IOException ex){
                return processNextHandler(file);
            }

        }
        return processNextHandler(file);
    }

}
