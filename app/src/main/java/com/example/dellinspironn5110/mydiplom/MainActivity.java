package com.example.dellinspironn5110.mydiplom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnAct1;
    Button btnAct2;
    Button btnAct3;
    Button btnAct4;
    Button btnAct5;
    Button btnAct6;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct1 = (Button) findViewById(R.id.btnAct1);
        btnAct1.setOnClickListener(this);
        btnAct2 = (Button) findViewById(R.id.btnAct2);
        btnAct2.setOnClickListener(this);
        btnAct3 = (Button) findViewById(R.id.btnAct3);
        btnAct3.setOnClickListener(this);
        btnAct4 = (Button) findViewById(R.id.btnAct4);
        btnAct4.setOnClickListener(this);
        btnAct5 = (Button) findViewById(R.id.btnAct5);
        btnAct5.setOnClickListener(this);
        btnAct6 = (Button) findViewById(R.id.btnAct6);
        btnAct6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAct1:
                Intent intent1 = new Intent(this, Activity1.class);
                startActivity(intent1);
                break;
            case R.id.btnAct2:
                Intent intent2 = new Intent(this, Activity2.class);
                startActivity(intent2);
                break;
            case R.id.btnAct3:
                Intent intent3 = new Intent(this, Activity3.class);
                startActivity(intent3);
                break;
            case R.id.btnAct4:
                Intent intent4 = new Intent(this, Activity4.class);
                startActivity(intent4);
                break;
            case R.id.btnAct5:
                Intent intent5 = new Intent(this, Activity5.class);
                startActivity(intent5);
                break;
            case R.id.btnAct6:
                Intent intent6 = new Intent(this, Activity6.class);
                startActivity(intent6);
                break;
            default:
                break;
        }
    }
}
