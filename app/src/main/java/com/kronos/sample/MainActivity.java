package com.kronos.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kronos.router.Router;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    TextView imageView;
    @BindView(R.id.routerTesting)
    Button routerTesting;
    @BindView(R.id.routerBaidu)
    Button routerBaidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // RouterConstants.init();
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(() -> Log.i("MTag", "onGlobalLayout"));
    }

    @OnClick({R.id.routerTesting, R.id.routerBaidu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.routerTesting:
                Router.sharedRouter().open("https://github.com/leifzhang", this);
                break;
            case R.id.routerBaidu:
                Router.sharedRouter().open("https://wwww.baidu.com", this);
                break;
        }
    }
}
