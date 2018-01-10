package com.example.administrator.children_game;



        import android.content.Context;
        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

public class game3_3 extends AppCompatActivity {
    SensorManager sensormanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_3);
        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        Sensor sensor=sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //  Sensor sensor=sensormanager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        sensormanager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float valuex = Math.abs(sensorEvent.values[0]);
//                float valuey = Math.abs(sensorEvent.values[1]);
//                float valuez = Math.abs(sensorEvent.values[2]);
////
                if(valuex>58&&valuex<=90)
                {
                    Toast t= Toast.makeText(game3_3.this,"",Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM, 0, 0);
                    View ll = LayoutInflater.from(game3_3.this).inflate(R.layout.layout_yes, null);
                    t.setView(ll);
                    new myToast(t,1100).myshow();
                    sensormanager.unregisterListener(this);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mydialog my1=new mydialog(game3_3.this);
                            my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_3.this,GameSelectView.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_3.this,game3_4.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.show();
                        }
                    },700);
                }
                // tv.setText(String.valueOf(valuex));

            }
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL );

    }
}


