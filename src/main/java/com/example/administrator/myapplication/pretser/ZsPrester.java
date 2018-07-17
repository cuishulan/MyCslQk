package com.example.administrator.myapplication.pretser;

import com.example.administrator.myapplication.mondel.ZsMondel;
import com.example.administrator.myapplication.view.inter.ZsIm;
import com.example.administrator.myapplication.view.inter.ZsIp;

import java.util.Map;

import okhttp3.ResponseBody;

public class ZsPrester implements ZsIp{

    ZsMondel zsMondel;
    ZsIm zsIm;
    public   ZsPrester(ZsIm zsIm){

        zsMondel = new ZsMondel(this);
        this.zsIm=zsIm;
    }

    public void GetZs(String categaryUrl, Map<String, String> map) {
        zsMondel.GetZs(categaryUrl,map);
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
     zsIm.onSuccess1(responseBody);
    }

    @Override
    public void onError(Throwable throwable) {
zsIm.onError1(throwable);
    }
}
