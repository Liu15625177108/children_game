package com.example.administrator.children_game;




        import android.content.Context;
        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Handler;
        import android.os.Vibrator;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

public class game3 extends AppCompatActivity implements View.OnClickListener{

    SensorManager sensormanager;
    Vibrator vibrator;
    ImageView tv,tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);


        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // Sensor sensor=sensormanager.getDefaultSensor(Sensor.TYPE_LIGHT);
        tv2 = (ImageView) findViewById(R.id.imageView_game3_2);
        tv4 = (ImageView) findViewById(R.id.imageView_game3_4);
        tv3 = (ImageView) findViewById(R.id.imageView_game3_3);
        tv1 = (ImageView) findViewById(R.id.imageView_game3_1);
        tv = (ImageView) findViewById(R.id.imageView_game3_true);
        tv.setClickable(false);
        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        sensormanager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float valuex = Math.abs(sensorEvent.values[0]);
                float valuey = Math.abs(sensorEvent.values[1]);
                float valuez = Math.abs(sensorEvent.values[2]);
                int medumValue = 50;
                if (valuex > medumValue || valuey > medumValue || valuez > medumValue) {

                    tv.setVisibility(View.VISIBLE);
                    tv.setClickable(true);
                    tv2.setVisibility(View.INVISIBLE);
                    sensormanager.unregisterListener(this);
                }

            }
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL );


//       tv.setOnClickListener(new View.OnClickListener() {
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_game3_true:
                Toast t = Toast.makeText(game3.this, "", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM, 0, 0);
                View ll = LayoutInflater.from(game3.this).inflate(R.layout.layout_yes, null);
                t.setView(ll);
                // t.show();
                new myToast(t,200).myshow();
                new Handler().postDelayed(new Runnable() {//延时操作
                    @Override
                    public void run() {
                        mydialog my1=new mydialog(game3.this);
                        my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3.this,GameSelectView.class);
                                startActivity(it1);
                                finish();
                            }
                        });
                        my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3.this,game3_2.class);
                                startActivity(it1);
                                finish();
                            }
                        });
                        my1.dialogBuilder.show();
                    }
                },700);

                break;
            default:
                Toast t1 = Toast.makeText(game3.this, "", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.BOTTOM, 0, 0);
                View ll1 = LayoutInflater.from(game3.this).inflate(R.layout.layout_no, null);
                t1.setView(ll1);
                new myToast(t1,200).myshow();
                //t1.show();

        }
//        });


    }

}
