package com.xiaxiao.miaowu.thirdframework.glide;


import com.xiaxiao.miaowu.Listener.MyListener;

import java.io.File;

/**
 * Created by xiaxiao on 2017/1/12.
 */

public abstract class OnGlideGIFListener implements MyListener {
//    public abstract  void success(byte[] resource);
    public abstract  void success(File gifFile);
    public abstract  void failed();
}
