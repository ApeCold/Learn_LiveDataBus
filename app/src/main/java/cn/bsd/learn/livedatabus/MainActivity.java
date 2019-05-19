package cn.bsd.learn.livedatabus;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LiveDataBus.get().with("MainActivity",Huawei.class).observe(this, new Observer<Huawei>() {
            @Override
            public void onChanged(@Nullable Huawei huawei) {
                if(huawei!=null){
                    Toast.makeText(MainActivity.this,huawei.getType()+"",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void sendMessage(View view) {
        Huawei huawei = new Huawei("华为","MATE_X");
        LiveDataBus.get().with("MainActivity",Huawei.class).postValue(huawei);
//        LiveDataBus.get().with("MainActivity",Huawei.class).postValue(true);
    }

    public void jumpActivity(View view) {
        startActivity(new Intent().setClass(MainActivity.this,TwoActivity.class));
    }

}
