package work1;

import java.io.File;

public abstract class FileHandler implements IHandler {
    private final FileType fileType;
    private IHandler nextFileHandler;
    protected static ProcessBuilder builder = new ProcessBuilder();

    public FileHandler(FileType type){
        this.fileType = type;
    }

    public FileType getFileType(){
        return fileType;
    }

    protected String getFileExtension(File file){
        String fileName = file.getName();
       return fileName.substring(fileName.lastIndexOf(".") + 1);

    }

    public static FileHandler createChain(FileHandler... handlers){
        if(handlers.length == 0)
            return new DefaultFileHandler();

        int i;

        for(i = 1; i < handlers.length; i++){
            handlers[i - 1].setNextHandler(handlers[i]);
        }
        handlers[i - 1].setNextHandler(new DefaultFileHandler());
        return handlers[0];
    }
    @Override
    public void setNextHandler(IHandler handler) {
           this.nextFileHandler = handler;
    }

    protected boolean processNextHandler(File file){
            return  this.nextFileHandler.process(file);
    }

    private static class DefaultFileHandler extends FileHandler{
        public DefaultFileHandler(){
            super(null);
        }
        @Override
        public boolean process(File file) {
            String fileName = file.getName();
            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

            System.out.println("File extension type ." + fileExtension + " is not recognized.");
            return true;
        }



    }

}
