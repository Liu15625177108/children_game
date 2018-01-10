package com.example.administrator.children_game;



//import android.animation.Animator;
//import android.content.Intent;
//import android.net.Uri;
//import android.support.annotation.ColorInt;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
//import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
//import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
//import com.romainpiel.shimmer.Shimmer;
//import com.romainpiel.shimmer.ShimmerTextView;
//
//
////import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
////import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
////import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    ShimmerTextView v;
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        button1 = (Button) findViewById(R.id.button1);
////        button2 = (Button) findViewById(R.id.button2);
////
////        button1.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                Intent it1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:10010"));
////                startActivity(it1);
////            }
////        });
////
////        button2.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                Intent it = new Intent();
////                it.setAction("android.intent.action.VIEW");
////                it.setData(Uri.parse("http://www.baidu.com"));
////                startActivity(it);
////            }
////        });
////
//        //******
//        ImageView icon = new ImageView(this); // Create an icon
//        icon.setImageDrawable(getDrawable(R.drawable.a));
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
//        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
//                .addSubActionView(button1)
//                .addSubActionView(button2)
//                // ...
//                .attachTo(actionButton)
//                .build();
///* *** */
////
//        Shimmer shimmer;
//        shimmer = new Shimmer();
//        v=(ShimmerTextView) findViewById(R.id.shimmer_tv);
//        Shimmer shimmer1 = shimmer.setRepeatCount(100)
//                .setDuration(500)
//                .setStartDelay(300)
//                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
////                .setAnimat1orListener(new Animator.AnimatorListener() {
////                });
//        shimmer1.start(v);
//   }
//
//
//}

               import android.animation.ObjectAnimator;
               import android.animation.ValueAnimator;
               import android.content.Intent;
               import android.net.Uri;
               import android.os.Bundle;
               import android.support.v7.app.ActionBarActivity;
               import android.util.Log;
               import android.view.Menu;
               import android.view.MenuInflater;
               import android.view.MenuItem;
               import android.view.View;
               import android.view.animation.AccelerateDecelerateInterpolator;
               import android.view.animation.Animation;
               import android.widget.AdapterView;
               import android.widget.Button;
               import android.widget.ImageView;
               import android.widget.ListView;
               import android.widget.TextView;
               import android.widget.Toast;

               import com.daimajia.androidanimations.library.specials.RollInAnimator;
               import com.daimajia.slider.library.Animations.BaseAnimationInterface;
               import com.daimajia.slider.library.Animations.DescriptionAnimation;
               import com.daimajia.slider.library.Indicators.PagerIndicator;
               import com.daimajia.slider.library.SliderLayout;
               import com.daimajia.slider.library.SliderTypes.BaseSliderView;
               import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
               import com.daimajia.slider.library.SliderTypes.TextSliderView;
               import com.daimajia.slider.library.Tricks.ViewPagerEx;

               import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mDemoSlider;
    private  Button button1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView5) ;
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        imageView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animator.start();
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
//        button1=(Button)findViewById(R.id.button7);
//        button1.setOnClickListener( new View.OnClickListener(){
//            public void onClick(View v){
//                System.exit(0);
//            }
//        });

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
//        file_maps.put("Hannibal",R.drawable.c);
//        file_maps.put("Big Bang Theory",R.drawable.d);
//        file_maps.put("House of Cards",R.drawable.a);
//        file_maps.put("Game of Thrones", R.drawable.b);
//          file_maps.put("a",R.drawable.a_2);
        file_maps.put("b",R.drawable.animals_7_1);
//        file_maps.put("c",R.drawable.e);
        file_maps.put("d", R.drawable.animals_12_1);

        for(String name : file_maps.keySet()){
            // TextSliderView textSliderView = new TextSliderView(this);
            DefaultSliderView defaultSliderView=new DefaultSliderView(this);
            // initialize a SliderLayout
            defaultSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information

//            textSliderView.bundle(new Bundle());
//            textSliderView.getBundle()
//                    .putString("extra",name);
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle()
                    .putString("extra",name);
            // mDemoSlider.addSlider(textSliderView);
            mDemoSlider.addSlider(defaultSliderView);
            ;
        }
        // mDemoSlider.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.stopAutoCycle();
        //mDemoSlider.setCustomAnimation(new RollInAnimator());
        // mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(MainActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });


    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

//        Toast.makeText(this,slider.getBundle().get("extra") + "",
//                Toast.LENGTH_SHORT).show();
        String symbol=(String)slider.getBundle().get("extra");
        switch(symbol)
        {
            case "d":
                Intent it=new Intent(this,game2.class);
                startActivity(it);
                break;
//            case "a":
//                Intent it1=new Intent(this,game1.class);
//                startActivity(it1);
//                break;
            case "b":
                Intent it2=new Intent(this,GameSelectView.class);
                startActivity(it2);
                break;
            default:
                System.exit(0);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.main,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_custom_indicator:
//                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
//                break;
//            case R.id.action_custom_child_animation:
//                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
//                break;
//            case R.id.action_restore_default:
//                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//                break;
//            case R.id.action_github:
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
//                startActivity(browserIntent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo",
                "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}

