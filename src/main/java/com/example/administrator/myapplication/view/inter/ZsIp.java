package com.example.administrator.myapplication.view.inter;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public interface ZsIp {
    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);
}
