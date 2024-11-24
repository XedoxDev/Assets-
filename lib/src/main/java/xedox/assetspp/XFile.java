package xedox.assetspp;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class XFile extends File implements IXFile {

    public XFile(String name) {
        super(name);
    }

    public XFile(String path, String name) {
        super(new File(path), name);
    }

    public XFile(File path, String name) {
        super(path, name);
    }

    public XFile(File path, File name) {
        super(path, name.getName());
    }

    @Override
    public String read() {
        StringBuilder buffer = new StringBuilder();
        try (FileReader isr = new FileReader(this);
                BufferedReader br = new BufferedReader(isr); ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\n");
            }
        } catch (IOException err) {
            Log.e(TAG, err.getMessage());
        }
        return buffer.toString();
    }

    @Override
    public boolean write(String text) {
        try (FileWriter writer = new FileWriter(this); ) {
            writer.write(text);
            return true;
        } catch (Exception err) {
            Log.e(TAG, err.getMessage());
        }
        return false;
    }

    @Override
    public boolean mkfile() {
        try {
            return createNewFile();
        } catch (Exception err) {
            Log.e(TAG, err.getMessage());
        }
        return false;
    }
}
