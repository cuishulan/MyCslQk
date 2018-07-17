package com.example.administrator.myapplication.mondel;

import android.util.Log;

import com.example.administrator.myapplication.view.inter.ZsIp;
import com.example.administrator.myapplication.view.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ZsMondel {
    ZsIp zsIp;
    public ZsMondel(ZsIp zsIp){
        this.zsIp=zsIp;
    }
    public void GetZs(String categaryUrl, Map<String, String> map) {
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
                        zsIp.onSuccess(responseBody);
                    }
                    @Override
                    public void onError(Throwable e) {
                        zsIp.onError(e);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    }

