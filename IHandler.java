package work1;

import java.io.File;

public interface IHandler {
    public abstract boolean process(File file);
    public abstract void setNextHandler(IHandler handler);
}
