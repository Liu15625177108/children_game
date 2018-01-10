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
        import android.view.animation.Animation;
        import android.view.animation.RotateAnimation;
        import android.widget.ImageView;
        import android.widget.Toast;

public class game3_8 extends AppCompatActivity {
    SensorManager sensormanager;
    Vibrator vibrator;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_8);
        image=(ImageView)findViewById(R.id.imageView12);
        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        sensormanager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float valuex = Math.abs(sensorEvent.values[0]);
                // float valuey = Math.abs(sensorEvent.values[1]);
                //float valuez = Math.abs(sensorEvent.values[2]);
                int medumValue = 50;
                if (valuex > medumValue ){//|| valuey > medumValue || valuez > medumValue) {

                    RotateAnimation rotateAnimation=new RotateAnimation(0,360*2, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setDuration(3000);
                    // rotateAnimation.setRepeatCount(5);
                    image.startAnimation(rotateAnimation);
                    Toast t = Toast.makeText(game3_8.this, "", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.BOTTOM, 0, 0);
                    View ll = LayoutInflater.from(game3_8.this).inflate(R.layout.layout_yes, null);
                    t.setView(ll);
                    // t.show();
                    new myToast(t,500).myshow();
                    sensormanager.unregisterListener(this);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mydialog my1=new mydialog(game3_8.this);
                            my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_8.this,GameSelectView.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_8.this,game3_9.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.show();
                        }
                    },700);

                }

            }
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL );


    }
}
