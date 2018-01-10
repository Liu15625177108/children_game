package com.example.administrator.children_game;



        import android.content.Context;
        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;


        import android.os.Handler;
        import android.os.Message;
        import android.os.Vibrator;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

        import java.io.IOException;
        import java.util.Timer;
        import java.util.TimerTask;


        import java.util.logging.LogRecord;

public class game3_5 extends AppCompatActivity {

    ImageView view1, view2, view_btn, view_true;
    boolean sym = false;
    SensorManager sensormanager;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_5);
        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        view1 = (ImageView) findViewById(R.id.imageView_3_5_1);
        view2 = (ImageView) findViewById(R.id.imageView_3_5_2);
        view_true = (ImageView) findViewById(R.id.imageview_3_5_true);
        view_btn = (ImageView) findViewById(R.id.imageView_3_5_btn);
        view_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        sym = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        sym=false;
                        break;
                }
                return true;
            }
        });
        sensormanager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float valuex = Math.abs(sensorEvent.values[0]);
                float valuey = Math.abs(sensorEvent.values[1]);
                float valuez = Math.abs(sensorEvent.values[2]);
                int medumValue = 40;
                if (valuex > medumValue || valuey > medumValue || valuez > medumValue) {
                    if(sym==false) {


                        Toast t1=Toast.makeText(game3_5.this,"",Toast.LENGTH_SHORT);
                        t1.setGravity(Gravity.BOTTOM,0,0);
                        View ll= LayoutInflater.from(game3_5.this).inflate(R.layout.layout_no,null);
                        t1.setView(ll);
                        new myToast(t1,500).myshow();
                        view1.setVisibility(View.INVISIBLE);
                        view2.setVisibility(View.VISIBLE);

                        Handler myhandle=new Handler();
                        myhandle.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view1.setVisibility(View.VISIBLE);
                                view2.setVisibility(View.INVISIBLE);
                            }
                        },1500);




                    }else{
                        view1.setVisibility(View.INVISIBLE);
                        view_true.setVisibility(View.VISIBLE);

                        Toast t=Toast.makeText(game3_5.this,"",Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.BOTTOM,0,0);
                        View ll= LayoutInflater.from(game3_5.this).inflate(R.layout.layout_yes,null);
                        t.setView(ll);
                        new myToast(t,500).myshow();
                        sensormanager.unregisterListener(this);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mydialog my1=new mydialog(game3_5.this);
                                my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent it1=new Intent(game3_5.this,GameSelectView.class);
                                        startActivity(it1);
                                        finish();
                                    }
                                });
                                my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent it1=new Intent(game3_5.this,game3_6.class);
                                        startActivity(it1);
                                        finish();
                                    }
                                });
                                my1.dialogBuilder.show();
                            }
                        },700);
                    }

                }

            }
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL );




    }
}

