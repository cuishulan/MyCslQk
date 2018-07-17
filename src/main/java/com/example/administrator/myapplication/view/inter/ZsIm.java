package com.example.administrator.myapplication.view.inter;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public interface ZsIm {
    void onSuccess1(ResponseBody responseBody);
    void onError1(Throwable throwable);
}
