package com.example.administrator.children_game;




        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

public class game3_7 extends AppCompatActivity implements View.OnClickListener{

    ImageView image[]=new ImageView[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_7);
        image[0]=(ImageView)findViewById(R.id.imageView3_7_true);
        image[1]=(ImageView)findViewById(R.id.imageView3_7_2);
        image[2]=(ImageView)findViewById(R.id.imageView3_7_3);
        image[3]=(ImageView)findViewById(R.id.imageView3_7_4);
        image[4]=(ImageView)findViewById(R.id.imageView3_7_5);
        image[5]=(ImageView)findViewById(R.id.imageView3_7_1);
        for(int i=0;i<6;i++)
            image[i].setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast t= Toast.makeText(game3_7.this,"",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM, 0, 0);
        View ll = LayoutInflater.from(game3_7.this).inflate(R.layout.layout_yes, null);
        t.setView(ll);
        Toast t1= Toast.makeText(game3_7.this,"",Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.BOTTOM, 0, 0);
        View ll1 = LayoutInflater.from(game3_7.this).inflate(R.layout.layout_no, null);
        t1.setView(ll1);
        switch(view.getId()){
            case R.id.imageView3_7_true:
                new myToast(t,500).myshow();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mydialog my1=new mydialog(game3_7.this);
                        my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3_7.this,GameSelectView.class);
                                startActivity(it1);
                                finish();
                            }
                        });
                        my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3_7.this,game3_8.class);
                                startActivity(it1);
                                finish();
                            }
                        });
                        my1.dialogBuilder.show();
                    }
                },700);
                break;
            default:
                new myToast(t1,500).myshow();

        }
    }
}
