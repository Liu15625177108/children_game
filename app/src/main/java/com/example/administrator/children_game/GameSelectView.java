package com.example.administrator.children_game;



        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.media.Image;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.ViewTreeObserver;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

public class GameSelectView extends AppCompatActivity {
    final static int gameNum = 9;
    int row=3;
    int col=gameNum/row;

    LinearLayout[] selectRow = new LinearLayout[row];
    ImageView[] selectButton = new ImageView[gameNum];
    ViewGroup parent;
    ViewGroup []child = new ViewGroup[row];

    LinearLayout.LayoutParams mLayoutParams;

    TextView[] selectNum = new TextView[gameNum];
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Intent it[]=new Intent[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select_view);

        parent = (ViewGroup)findViewById(R.id.gameSelectView);

        mLayoutParams = new LinearLayout.LayoutParams(300,300);
        mLayoutParams.setMargins(10,10,10,10);
        it[0]=new Intent(this,game3.class);
        it[1]=new Intent(this,game3_2.class);
        it[2]=new Intent(this,game3_3.class);
        it[3]=new Intent(this,game3_4.class);
        it[4]=new Intent(this,game3_5.class);
        it[5]=new Intent(this,game3_6.class);
        it[6]=new Intent(this,game3_7.class);
        it[7]=new Intent(this,game3_8.class);
        it[8]=new Intent(this,game3_9.class);

        for(int i=0;i<row;i++){
            selectRow[i] = new LinearLayout(this);
            parent.addView(selectRow[i]);

            for(int j=0;j<col;j++){
                selectButton[i*row+j] = new ImageView(this);
                selectButton[i*row+j].setId(View.generateViewId());

//                selectButton[i*row+j].setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.tile));
                selectButton[i*row+j].setBackgroundResource(R.drawable.tile);

                addButton(i*row+j,selectRow[i]);
                addOnClickListener(i*row+j,selectButton[i]);

            }

        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                bitmap = Bitmap.createBitmap(200,200,Bitmap.Config.ARGB_8888);

                canvas = new Canvas(bitmap);
                paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setTextSize(100);
                canvas.drawText(Integer.toString(i*row+j+1),80,130,paint);
                selectButton[i*row+j].setImageBitmap(bitmap);
            }
        }





    }

    public void addOnClickListener(int id, ImageView imageView){
        switch (id){
            case  0:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){

                        startActivity(it[0]);

                    }
                });
                break;

            case 1:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[1]);
                    }
                });
                break;
            case 2:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[2]);
                    }
                });
                break;
            case 3:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[3]);
                    }
                });
                break;
            case 4:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[4]);
                    }
                });
                break;
            case 5:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[5]);
                    }
                });
                break;
            case 6:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[6]);
                    }
                });
                break;
            case 7:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[7]);
                    }
                });
                break;
            case 8:
                selectButton[id].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        startActivity(it[8]);
                    }
                });
                break;
            default:
                break;

        }


    }

    public void addButton(int id,ViewGroup parent){
        parent.addView(selectButton[id],mLayoutParams);
    }
}

