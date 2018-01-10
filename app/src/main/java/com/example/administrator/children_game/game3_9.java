package com.example.administrator.children_game;



        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.DisplayMetrics;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

public class game3_9 extends AppCompatActivity {

    ImageView image,image2,image3;
    int screenWidth,screenHeight;
    mydialog my1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_9);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels - 50;
        image=(ImageView)findViewById(R.id.imageView1);
        image2=(ImageView)findViewById(R.id.imageView3);
        image3=(ImageView)findViewById( R.id.imageView4) ;
        image.setOnTouchListener(new View.OnTouchListener() {

            int lastX, lastY;
            int left1,right1,top1,bottom1;
            int view_height,view_width;
            public boolean onTouch(View v, MotionEvent motionEvent) {
                Toast t = Toast.makeText(game3_9.this, "", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.BOTTOM, 0, 0);
                View ll = LayoutInflater.from(game3_9.this).inflate(R.layout.layout_yes, null);
                t.setView(ll);
                myToast t1=new myToast(t,500);

                my1=new mydialog(game3_9.this);
                my1.dialogBuilder.withMessage("this is the last one");
                my1.dialogBuilder.setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it1=new Intent(game3_9.this,GameSelectView.class);
                        startActivity(it1);
                        finish();
                    }
                });
//                my1.dialogBuilder.setButton2Click(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent it1=new Intent(game3_5.this,game3_6.class);
//                        startActivity(it1);
//                        finish();
//                    }
//                });


                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:

                        left1=v.getLeft();
                        right1=v.getRight();
                        top1=v.getTop();
                        bottom1=v.getBottom();
                        lastX = (int) motionEvent.getRawX();
                        lastY = (int) motionEvent.getRawY();
                        view_height=v.getHeight();
                        view_width=v.getWidth();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int)motionEvent.getRawX() - lastX;
                        int dy = (int) motionEvent.getRawY() - lastY;

                        int left = v.getLeft() + dx;
                        int top = v.getTop() + dy;
                        int right = v.getRight() + dx;
                        int bottom = v.getBottom() + dy;
                        // 设置不能出界
                        if (left < 0-view_width/2) {
                            v.setVisibility(View.INVISIBLE);
                            image2.setVisibility(View.INVISIBLE);
                            image3.setVisibility(View.VISIBLE);
                            t1.myshow();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    my1.dialogBuilder.show();
                                }
                            },700);
                        }

                        if (right > screenWidth+view_width/2) {
                            v.setVisibility(View.INVISIBLE);
                            image2.setVisibility(View.INVISIBLE);
                            image3.setVisibility(View.VISIBLE);
                            t1.myshow();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    my1.dialogBuilder.show();
                                }
                            },700);
                        }

                        if (top < 0-view_height/2) {
                            v.setVisibility(View.INVISIBLE);
                            image2.setVisibility(View.INVISIBLE);
                            image3.setVisibility(View.VISIBLE);
                            t1.myshow();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    my1.dialogBuilder.show();
                                }
                            },700);
                        }

                        if (bottom > screenHeight+view_height/2) {
                            v.setVisibility(View.INVISIBLE);
                            image2.setVisibility(View.INVISIBLE);
                            image3.setVisibility(View.VISIBLE);
                            t1.myshow();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    my1.dialogBuilder.show();
                                }
                            },700);

                        }

                        v.layout(left, top, right, bottom);

                        lastX = (int) motionEvent.getRawX();
                        lastY = (int) motionEvent.getRawY();

                        break;
                    case MotionEvent.ACTION_UP:
                        v.layout(left1,top1,right1,bottom1);
                        break;
                }


                return true;
            }
        });
    }
}

