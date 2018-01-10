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
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.Toast;

public class game3_2 extends AppCompatActivity {
    SensorManager sensormanager;
    ImageView v1,v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_2);
        v1=(ImageView)findViewById(R.id.imageView_game3_2_1);
        v2=(ImageView)findViewById(R.id.imageView_game3_2_2);

        sensormanager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        //Sensor sensor=sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor sensor=sensormanager.getDefaultSensor(Sensor.TYPE_LIGHT);


        sensormanager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] <= 3) {


                    Handler myhandle=new Handler();
                    myhandle.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            v2.setVisibility(View.VISIBLE);
                            v1.setVisibility(View.INVISIBLE);
                            Toast t=Toast.makeText(game3_2.this,"",Toast.LENGTH_SHORT);
                            t.setGravity(Gravity.BOTTOM,0,0);
                            View ll= LayoutInflater.from(game3_2.this).inflate(R.layout.layout_yes,null);
                            t.setView(ll);
                            new myToast(t,500).myshow();
                        }
                    },1000);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mydialog my1=new mydialog(game3_2.this);
                            my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_2.this,GameSelectView.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_2.this,game3_3.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.show();
                        }
                    },700);


                    sensormanager.unregisterListener(this);
                }

            }
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL );

    }

}
