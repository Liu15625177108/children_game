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

public class game3_6 extends AppCompatActivity implements View.OnClickListener{


    ImageView i[]=new ImageView[5];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_6);
        i[0]=(ImageView)findViewById(R.id.imageview_3_6_1);
        i[1]=(ImageView)findViewById(R.id.imageview_3_6_2);
        i[2]=(ImageView)findViewById(R.id.imageview_3_6_3);
        i[3]=(ImageView)findViewById(R.id.imageview_3_6_4);
        i[4]=(ImageView)findViewById(R.id.imageview3_6_true);
        for(int i1=0;i1<5;i1++)
            i[i1].setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Toast t= Toast.makeText(game3_6.this,"",Toast.LENGTH_SHORT);
        t.setGravity(Gravity.BOTTOM, 0, 0);
        View ll = LayoutInflater.from(game3_6.this).inflate(R.layout.layout_yes, null);
        t.setView(ll);
        Toast t1= Toast.makeText(game3_6.this,"",Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.BOTTOM, 0, 0);
        View ll1 = LayoutInflater.from(game3_6.this).inflate(R.layout.layout_no, null);
        t1.setView(ll1);
        switch (view.getId()){
            case R.id.imageview3_6_true:
                new myToast(t,500).myshow();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mydialog my1=new mydialog(game3_6.this);
                        my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3_6.this,GameSelectView.class);
                                startActivity(it1);
                                finish();
                            }
                        });
                        my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it1=new Intent(game3_6.this,game3_7.class);
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

