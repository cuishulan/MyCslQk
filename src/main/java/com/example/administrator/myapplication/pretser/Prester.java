package com.example.administrator.myapplication.pretser;

import com.example.administrator.myapplication.mondel.MonDel;
import com.example.administrator.myapplication.view.inter.Im;
import com.example.administrator.myapplication.view.inter.Ip;

import java.util.Map;

import okhttp3.ResponseBody;

import static android.os.Build.VERSION_CODES.M;

public class Prester implements Ip{

    private final MonDel monDel;
    Im im;
    public Prester(Im im){
        monDel = new MonDel(this);
        this.im=im;
    };
    public void GetBan(String categaryUrl, Map<String, String> map) {
        monDel.GetBan(categaryUrl,map);

    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        im.onSuccess(responseBody);
    }

    @Override
    public void onError(Throwable throwable) {
        im.onError(throwable);

    }

   public void detach() {
        if (im!=null)
        {
            im=null;
        }
    }
}
