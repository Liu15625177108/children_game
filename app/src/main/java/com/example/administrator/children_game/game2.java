package com.example.administrator.children_game;



//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ImageView;
//
//import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
//import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
//import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
//
//public class game2 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game2);
//
////        ImageView icon = new ImageView(this); // Create an icon
////        icon.setImageDrawable(getDrawable(R.drawable.a));
//
//        FloatingActionButton actionButton;
//        actionButton = new FloatingActionButton.Builder(this)
//        // .setContentView(icon)
//
//                .build();
//
//        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
//// repeat many times:
//       SubActionButton button1 = itemBuilder.build();
////        SubActionButton button2 = itemBuilder.setContentView(itemIcon).build();
//       // SubActionButton button1 = itemBuilder.build();
//        SubActionButton button2 = itemBuilder.build();
//        SubActionButton button3 = itemBuilder.build();
//
//        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
//                .addSubActionView(button1)
//                .addSubActionView(button2)
//                .addSubActionView(button3)
//                // ...
//                .attachTo(actionButton)
//                .build();
//
//    }
//}


        import java.io.File;
        import java.io.FileOutputStream;

        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.graphics.BitmapFactory;
        import android.graphics.Matrix;
        import android.graphics.Rect;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.Bitmap.CompressFormat;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.support.v7.app.AppCompatActivity;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.View.OnTouchListener;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.RelativeLayout;
        import android.widget.Toast;

public class game2 extends AppCompatActivity{//} implements OnClickListener{
    private Button btn_save, btn_resume;
    private ImageView iv_canvas;
    private Bitmap baseBitmap;
    private Canvas canvas;
    private Paint paint;
    private Context context;
    Button[] btn_set = new Button[5];
    private View.OnClickListener click = new View.OnClickListener() {

        Bitmap bitmap,srcBitmap,baseBitmap;
        ImageView imageView,image_ok,image_cancel;
        ViewGroup viewGroup;
        @Override
        public void onClick(View v) {
            imageView =new ImageView(game2.this);
            image_ok = new ImageView(game2.this);
            image_cancel = new ImageView(game2.this);
            imageView.setOnTouchListener(new View.OnTouchListener() {

                boolean ifClick = false;
                int lastX, lastY;
                int view_height,view_width;
                @Override
                public boolean onTouch(View v, MotionEvent motionEvent) {

                    switch (motionEvent.getAction()){
                        case MotionEvent.ACTION_DOWN:

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
//                                    if (left < 0) {
//
//                                    }
//
//                                    if (right > screenWidth+view_width/2) {
//                                        v.setVisibility(View.INVISIBLE);
//                                        image2.setVisibility(View.INVISIBLE);
//                                        image3.setVisibility(View.VISIBLE);
//                                        t1.myshow();
//                                    }
//
//                                    if (top < 0-view_height/2) {
//                                        v.setVisibility(View.INVISIBLE);
//                                        image2.setVisibility(View.INVISIBLE);
//                                        image3.setVisibility(View.VISIBLE);
//                                        t1.myshow();
//                                    }
//
//                                    if (bottom > screenHeight+view_height/2) {
//                                        v.setVisibility(View.INVISIBLE);
//                                        image2.setVisibility(View.INVISIBLE);
//                                        image3.setVisibility(View.VISIBLE);
//                                        t1.myshow();
//                                    }

                            v.layout(left, top, right, bottom);

                            lastX = (int) motionEvent.getRawX();
                            lastY = (int) motionEvent.getRawY();

                            break;
                        case MotionEvent.ACTION_UP:
                            AlertDialog alertDialog;
                            alertDialog = new AlertDialog.Builder(imageView.getContext()).setTitle("")
                                    .setMessage("确认要将图片放在这里？")
                                    .setIcon(R.mipmap.ic_launcher)
                                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            canvas.drawBitmap(srcBitmap,imageView.getLeft(),imageView.getTop(),null);
                                            imageView.setVisibility(View.INVISIBLE);
                                        }
                                    })
                                    .setNegativeButton("否",null)
                                    .create();
                            alertDialog.show();
                            break;
                    }


                    return true;
                }
            });
            viewGroup = (ViewGroup)findViewById(R.id.board);
            srcBitmap = Bitmap.createBitmap(iv_canvas.getWidth()/8,iv_canvas.getHeight()/8,Bitmap.Config.ARGB_8888);
            baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth()/8,iv_canvas.getHeight()/8,Bitmap.Config.ARGB_8888);

            switch (v.getId()) {
                case R.id.btn_resume:
                    resumeCanvas();
                    break;
                case R.id.btn_change_color:
                    if(paint.getColor() == Color.RED)
                        paint.setColor(Color.BLACK);
                    else if(paint.getColor() == Color.BLACK)
                        paint.setColor(Color.RED);
//                    Toast.makeText(MainActivity.this, "change color", 0).show();
                    break;
                case R.id.btn_add_picture:
                    Canvas canvas1 = new Canvas(srcBitmap);

                    bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.animals_3);

                    bitmap = small(bitmap,0.125f,0.125f);
                    canvas1.drawBitmap(bitmap,0,0,null);

                    image_ok.setImageBitmap(baseBitmap);

                    imageView.setImageBitmap(srcBitmap);

                    RelativeLayout.LayoutParams mRlayoutParams = new RelativeLayout.LayoutParams(srcBitmap.getWidth(),srcBitmap.getHeight());
                    mRlayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

                    viewGroup.addView(imageView,mRlayoutParams);
//                    RelativeLayout.LayoutParams mRLP = new RelativeLayout.LayoutParams(srcBitmap.getWidth(),srcBitmap.getHeight());
//                    mRLP.addRule(RelativeLayout.ALIGN_BOTTOM,imageView.getId());
//                    viewGroup.addView(image_ok,mRLP);

                    Toast.makeText(game2.this,"请拖动图片到你想要的位置",Toast.LENGTH_LONG).show();

                    break;

                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        context = getBaseContext();
        // 初始化一个画笔，笔触宽度为5，颜色为红色
        paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);

        iv_canvas = (ImageView) findViewById(R.id.iv_canvas);
//        btn_save = (Button) findViewById(R.id.btn_save);
        btn_resume = (Button) findViewById(R.id.btn_resume);
        btn_set[0] = (Button)findViewById(R.id.btn_add_picture);
        btn_set[1] = (Button)findViewById(R.id.btn_change_color);

//        btn_save.setOnClickListener(click);
        btn_set[0].setOnClickListener(click);
        btn_set[1].setOnClickListener(click);
        btn_resume.setOnClickListener(click);
        iv_canvas.setOnTouchListener(touch);
//        iv_canvas.setBackgroundResource(R.drawable.back2);
    }

    private View.OnTouchListener touch = new OnTouchListener() {
        // 定义手指开始触摸的坐标
        float startX;
        float startY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                // 用户按下动作
                case MotionEvent.ACTION_DOWN:
                    // 第一次绘图初始化内存图片，指定背景为白色
                    if (baseBitmap == null) {
                        //  bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.back2);//.copy(Bitmap.Config.ARGB_8888,true);
                        baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth(),
                                iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);


                        canvas = new Canvas(baseBitmap);
//                        canvas.drawColor(Color.GREEN);


                    }
                    // 记录开始触摸的点的坐标
                    startX = event.getX();
                    startY = event.getY();
                    iv_canvas.setImageBitmap(baseBitmap);
                    break;
                // 用户手指在屏幕上移动的动作
                case MotionEvent.ACTION_MOVE:
                    // 记录移动位置的点的坐标
                    float stopX = event.getX();
                    float stopY = event.getY();

                    //根据两点坐标，绘制连线
                    canvas.drawLine(startX, startY, stopX, stopY, paint);

                    // 更新开始点的位置
                    startX = event.getX();
                    startY = event.getY();

                    // 把图片展示到ImageView中
                    iv_canvas.setImageBitmap(baseBitmap);
                    break;
                case MotionEvent.ACTION_UP:

                    break;
                default:
                    break;
            }
            return true;
        }
    };




    private static Bitmap small(Bitmap bitmap,float sx,float sy) {
        Matrix matrix = new Matrix();
        matrix.postScale(sx,sy); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        return resizeBmp;
    }
//    /**
//     * 保存图片到SD卡上
//     */
//    protected void saveBitmap() {
//        try {
//            // 保存图片到SD卡上
//            File file = new File(Environment.getExternalStorageDirectory(),
//                    System.currentTimeMillis() + ".png");
//            FileOutputStream stream = new FileOutputStream(file);
//            baseBitmap.compress(CompressFormat.PNG, 100, stream);
//            Toast.makeText(MainActivity.this, "保存图片成功", 0).show();
//
//            // Android设备Gallery应用只会在启动的时候扫描系统文件夹
//            // 这里模拟一个媒体装载的广播，用于使保存的图片可以在Gallery中查看
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
//            intent.setData(Uri.fromFile(Environment
//                    .getExternalStorageDirectory()));
//            sendBroadcast(intent);
//        } catch (Exception e) {
//            Toast.makeText(MainActivity.this, "保存图片失败", 0).show();
//            e.printStackTrace();
//        }
//    }

    /**
     * 清除画板
     */
    protected void resumeCanvas() {
        // 手动清除画板的绘图，重新创建一个画板
        if (baseBitmap != null) {
            baseBitmap = Bitmap.createBitmap(iv_canvas.getWidth(),
                    iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(baseBitmap);
            canvas.drawColor(Color.WHITE);
            iv_canvas.setImageBitmap(baseBitmap);
            Toast.makeText(game2.this, "清除画板成功，可以重新开始绘图", Toast.LENGTH_SHORT).show();
        }
    }
}
