package com.example.administrator.myapplication.mondel;

import android.util.Log;

import com.example.administrator.myapplication.view.inter.Ip;
import com.example.administrator.myapplication.view.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MonDel {
    Ip ip;
    public MonDel(Ip ip){
        this.ip=ip;
    };
    public void GetBan(String categaryUrl, Map<String, String> map) {
        RetrofitUtil.getService().doPost(categaryUrl, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        Log.d("Aaaa",responseBody.toString());
                      ip.onSuccess(responseBody);
                    }
                    @Override
                    public void onError(Throwable e) {
                ip.onError(e);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
