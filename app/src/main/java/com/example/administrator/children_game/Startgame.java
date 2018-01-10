package com.example.administrator.children_game;




        import android.animation.ObjectAnimator;
        import android.animation.ValueAnimator;
        import android.content.Intent;
        import android.provider.ContactsContract;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.AccelerateDecelerateInterpolator;
        import android.view.animation.Animation;
        import android.view.animation.RotateAnimation;
        import android.widget.Button;
        import android.widget.ImageView;

        import com.romainpiel.shimmer.Shimmer;
        import com.romainpiel.shimmer.ShimmerTextView;

public class Startgame extends AppCompatActivity implements View.OnClickListener {
    Button start,exit;
    Intent it;
    ShimmerTextView v;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startgame);

        Shimmer shimmer;
        shimmer = new Shimmer();
        v=(ShimmerTextView) findViewById(R.id.shimmer_tv);
        Shimmer shimmer1 = shimmer.setRepeatCount(100)
                .setDuration(2000)
                .setStartDelay(100)
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
//                .setAnimat1orListener(new Animator.AnimatorListener() {
//                });
        shimmer1.start(v);
        ImageView image_ok,image_exit,image_bg;
        image_bg=(ImageView)findViewById(R.id.imageView_background);
        image_ok=(ImageView)findViewById(R.id.imageView_ok);
        image_exit=(ImageView)findViewById(R.id.imageView_exit);
//        RotateAnimation rotateAnimation=new RotateAnimation(0,360*2, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(3000);
//        rotateAnimation.setRepeatCount(ValueAnimator.INFINITE);
//        // rotateAnimation.setRepeatCount(5);
//        image_bg.startAnimation(rotateAnimation);
        ObjectAnimator animator = ObjectAnimator.ofFloat(image_bg, "rotation", 0f, 360f);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        image_bg.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animator.start();
        image_ok.setOnClickListener(this);
        image_exit.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.imageView_ok:
                Intent it=new Intent(this,MainActivity.class);
                startActivity(it);
                break;
            case R.id.imageView_exit:
                finish();
        }
    }


}

