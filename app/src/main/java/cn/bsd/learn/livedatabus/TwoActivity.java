package cn.bsd.learn.livedatabus;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        LiveDataBus.get().with("MainActivity",Huawei.class).observe(this, new Observer<Huawei>() {
            @Override
            public void onChanged(@Nullable Huawei huawei) {
                if(huawei!=null){
                    Toast.makeText(TwoActivity.this,huawei.getType()+"",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void sendMessage(View view) {
        Huawei huawei = new Huawei("华为","MATE_20");
        LiveDataBus.get().with("MainActivity",Huawei.class).postValue(huawei);
    }

}
