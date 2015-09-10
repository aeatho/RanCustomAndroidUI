package com.demo.demomutiprogress;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    Context mContext = MainActivity.this;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * �ڵ������
     */
    public void onProgress(View v){
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }

    /*
     *  GridViewʵ��ˮƽͼ���ص�
     */
    public void onGridView(View v){
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
    
    /*
     *  ʵ��ˮƽͼ���ص�
     */
    public void onOverlay(View v){
        Intent intent = new Intent(this, OverlayActivity.class);
        startActivity(intent);
    }
}
