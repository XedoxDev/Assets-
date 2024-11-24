package xedox.assetspp;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * example for use:
 * Assets.from(youContext).asset("name.txt").toPath("your/path/for/copy").copy();
 */

public class Assets implements IAssets {

    public static final String TAG = "Assets++";

    private Context context;

    private String assetName;
    private String toPathCopy;

    public Assets(Context context, String assetName) {
        this.context = context;
        this.assetName = assetName;
        toPathCopy = "";
    }

    public Assets(Context context) {
        this.context = context;
        this.assetName = "";
        toPathCopy = "";
    }

    public Assets(Context context, String assetName, String toPathCopy) {
        this.context = context;
        this.assetName = assetName;
        this.toPathCopy = toPathCopy;
    }

    public String readAsset() {
        StringBuilder buffer = new StringBuilder();
        try (InputStream is = context.getAssets().open(assetName);
                InputStreamReader isr = new InputStreamReader(is);
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

    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getToPathCopy() {
        return this.toPathCopy;
    }

    public void setToPathCopy(String toPathCopy) {
        this.toPathCopy = toPathCopy;
    }

    public Assets asset(String assetName) {
        this.assetName = assetName;
        return this;
    }

    public Assets copy() {
        if (assetName == null
                || assetName.isEmpty()
                || toPathCopy == null
                || toPathCopy.isEmpty()) {
            Log.e(
                    TAG,
                    "copy() failed: assetName or toPathCopy is null or empty. assetName: "
                            + assetName
                            + ", toPathCopy: "
                            + toPathCopy);
            return this;
        }

        try {
            IXFile output = new XFile(toPathCopy, assetName);
            if (!output.write(readAsset())) {
                Log.e(
                        TAG,
                        "copy() failed: write operation failed. assetName: "
                                + assetName
                                + ", toPathCopy: "
                                + toPathCopy);
                return this;
            }
            IXFile path = new XFile(toPathCopy);
            if (!path.mkdirs()) {
                Log.e(TAG, "copy() failed: mkdirs operation failed. toPathCopy: " + toPathCopy);
                return this;
            }
            output.mkfile();
        } catch (Exception e) {
            Log.e(TAG, "copy() failed: IO exception occurred.", e);
            return this;
        }
        return this;
    }

    public Assets toPath(String path) {
        this.toPathCopy = path;
        return this;
    }

    public static Assets from(Context context) {
        return new Assets(context);
    }
}
