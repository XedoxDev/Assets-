package xedox.assetspp;

public interface IXFile {
    
    public static final String TAG = "IXFile";
    
    public String read();
    public boolean write(String text);
    
    public boolean mkdirs();
    public boolean mkfile();
}
