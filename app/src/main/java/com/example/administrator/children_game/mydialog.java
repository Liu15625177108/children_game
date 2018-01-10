package com.example.administrator.children_game;

/**
 * Created by Administrator on 2018/1/10.
 */


        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.view.View;

        import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
        import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
        import com.gitonway.lee.niftymodaldialogeffects.lib.effects.FlipH;

        import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/4.
 */
public class mydialog {
    NiftyDialogBuilder dialogBuilder;


    mydialog(final Context context) {
        dialogBuilder = NiftyDialogBuilder.getInstance(context);

        dialogBuilder
                .withTitle("提示")
                .withMessage("恭喜你通关成功，请到下一关")
                .withEffect(Effectstype.Newspager)

                .withTitleColor("#000000")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor(0xf5d79f)
                .withButton1Text("选关")
                .withButton2Text("next");
//                   .setContentView(View.inflate(context, R.layout.layout_view, null));

    }
}

