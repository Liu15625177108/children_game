package com.example.administrator.children_game;




        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.format.Time;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Timer;

public class game3_4 extends AppCompatActivity implements View.OnClickListener {

    ImageView i1,i2,i3,i4,i5;
    TextView t_hour,t_min;
    int minute,hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_4);
        i1=(ImageView)findViewById(R.id.imageView3_4_1);
        i2=(ImageView)findViewById(R.id.imageView3_4_2);
        i3=(ImageView)findViewById(R.id.imageView3_4_3);
        i4=(ImageView)findViewById(R.id.imageView3_4_4);
        i5=(ImageView)findViewById(R.id.imageView3_4_btn);
        t_hour=(TextView)findViewById(R.id.textView_hour);
        t_min=(TextView)findViewById(R.id.textView_minute);
        hour=12;
        minute=30;
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        t_hour.setOnClickListener(this);
        t_min.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView3_4_1:
                if(hour==23)
                    hour=0;
                else
                    hour++;
                if(hour<=9)
                    t_hour.setText("0"+String.valueOf(hour));
                else
                    t_hour.setText(String.valueOf(hour));
                break;
            case R.id.imageView3_4_2:
                if(minute==59)
                    minute=0;
                else minute++;
                if(minute<=9)
                    t_min.setText("0"+String.valueOf(minute));
                else
                    t_min.setText(String.valueOf(minute));
                break;
            case R.id.imageView3_4_3:
                if(hour==0)
                    hour=23;
                else
                    hour--;
                if(hour<=9)
                    t_hour.setText("0"+String.valueOf(hour));
                else
                    t_hour.setText(String.valueOf(hour));
                break;
            case R.id.imageView3_4_4:
                if(minute==0)
                    minute=59;
                else
                    minute--;
                if(minute<=9)
                    t_min.setText("0"+String.valueOf(minute));
                else
                    t_min.setText(String.valueOf(minute));
                break;
            case R.id.imageView3_4_btn:
                Time t=new Time();
                t.setToNow();
                int m=t.minute;
                if(m==minute&&hour==t.hour) {
                    Toast t1 = Toast.makeText(game3_4.this, "", Toast.LENGTH_SHORT);
                    t1.setGravity(Gravity.BOTTOM, 0, 0);
                    View ll1 = LayoutInflater.from(game3_4.this).inflate(R.layout.layout_yes, null);
                    t1.setView(ll1);
                    new myToast(t1,200).myshow();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mydialog my1=new mydialog(game3_4.this);
                            my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_4.this,GameSelectView.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent it1=new Intent(game3_4.this,game3_5.class);
                                    startActivity(it1);
                                    finish();
                                }
                            });
                            my1.dialogBuilder.show();
                        }
                    },700);

                }else{
                    Toast t1 = Toast.makeText(game3_4.this, "", Toast.LENGTH_SHORT);
                    t1.setGravity(Gravity.BOTTOM, 0, 0);
                    View ll1 = LayoutInflater.from(game3_4.this).inflate(R.layout.layout_no, null);
                    t1.setView(ll1);
                    new myToast(t1,200).myshow();
                }
                break;



        }
    }
}

