package xedox.assetspp;

import android.content.Context;

public interface IAssets {
    public String readAsset();

    public String getAssetName();

    public String getToPathCopy();

    public Assets asset(String assetName);

    public Assets copy() ;

    public Assets toPath(String path);
}
