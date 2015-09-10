/*
*@Project: GZJK
*@Author: BMR
*@Date: 2015��9��8��
*@Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.demo.demomutiprogress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;

/** 
* @ClassName: Tools 
* @Description: TODO
* @author BMR
* @date 2015��9��8�� ����12:19:20 
*/
@SuppressLint("NewApi")
public class Tools {
    
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * ��pxֵת��Ϊdip��dpֵ����֤�ߴ��С����
     *
     * @param context
     * @param pxValue��DisplayMetrics��������density��
     * @return
     */
    public static int px2dip(Context context, float pxValue) {

        final float scale = context.getResources().getDisplayMetrics().density;

        return (int) (pxValue / scale + 0.5f);
    }
    
    public static void setDrawableToBkg(View view, Drawable drawable){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN ){
            view.setBackground(drawable);
        }else
        {
            view.setBackgroundDrawable(drawable);
        }
        
    }
    
    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
}

