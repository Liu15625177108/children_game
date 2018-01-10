package com.example.administrator.children_game;

/**
 * Created by Administrator on 2018/1/10.
 */



        import android.widget.Toast;

        import java.util.Timer;
        import java.util.TimerTask;

/**
 * Created by Administrator on 2018/1/2.
 */

public class myToast {
    Toast t;
    int time;
    public  myToast(Toast t1,int time1){
        t=t1;
        time=time1;
    }
    void myshow(){
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                t.show();
            }
        },0,3500);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                t.cancel();
                timer.cancel();
            }
        },time);
    }

}


