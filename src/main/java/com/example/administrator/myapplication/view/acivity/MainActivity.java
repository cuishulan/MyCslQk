package com.example.administrator.myapplication.view.acivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.pretser.Prester;
import com.example.administrator.myapplication.pretser.ZsPrester;
import com.example.administrator.myapplication.view.Bean;
import com.example.administrator.myapplication.view.adapet.RecyAdapet;
import com.example.administrator.myapplication.view.inter.Im;
import com.example.administrator.myapplication.view.inter.JieKouHuiDiao;
import com.example.administrator.myapplication.view.inter.ZsIm;
import com.example.administrator.myapplication.view.util.Constant;
import com.example.administrator.myapplication.view.util.GlideImageLoader;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements Im,ZsIm {

    private Prester prester;
    private Banner banner;
    List<String> imageUrls=new ArrayList<>();
    private RecyclerView main_recy;
    private RecyAdapet recyAdapet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initid();
        initview();
        inbanner();
    }

    private void initid() {
        banner = findViewById(R.id.main_banner);
        main_recy = findViewById(R.id.main_recy);


    }

    private void initview() {
        prester = new Prester(this);
        ZsPrester zsPrester=new ZsPrester(this);
        Map<String, String> map=new HashMap<>();
        prester.GetBan(Constant.CATEGARY_URL,map);
        zsPrester.GetZs(Constant.CATEGARY_URL,map);
    }

    private void inbanner() {
        //设置banner样式...CIRCLE_INDICATOR_TITLE包含标题
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
banner.setOnBannerListener(new OnBannerListener() {
    @Override
    public void OnBannerClick(int position) {
        //点击吐司点击了
        Toast.makeText(MainActivity.this, "点击了第"+(position+1)+"张图片",Toast.LENGTH_LONG).show();
    }
});

    }
    @Override
    public void onSuccess(ResponseBody responseBody) {

        try {
            String json = responseBody.string();
            Bean bean = new Gson().fromJson(json, Bean.class);

            List<Bean.DataBean> data = bean.getData();
            for (int i = 0;i<data.size();i++){
                imageUrls.add(bean.getData().get(i).getIcon());
            }
            banner.setImages(imageUrls);
            banner.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess1(ResponseBody responseBody) {
        //获取数据
        try {
            String json = responseBody.string();
            Bean bean = new Gson().fromJson(json, Bean.class);
            List<Bean.TuijianBean.ListBean> list = bean.getTuijian().getList();
            recyAdapet = new RecyAdapet(this,list);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)   ;
            main_recy.setAdapter(recyAdapet);
            main_recy.setLayoutManager(linearLayoutManager);
            recyAdapet.Hui(new JieKouHuiDiao() {
                @Override
                public void dianzhong(int position) {
                    Toast.makeText(MainActivity.this, "点击了商品",Toast.LENGTH_LONG).show();
                }

                @Override
                public void changan(int position) {
                    Toast.makeText(MainActivity.this, "长按了商品",Toast.LENGTH_LONG).show();

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onError1(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        prester.detach();
    }
}
