/*
 * @Project: GZJK
 * @Author: BMR
 * @Date: 2015��9��8��
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.demo.demomutiprogress;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/** 
* @ClassName: OverlayLayout 
* @Description: ͼƬˮƽ�ص��ؼ�
* @author BMR
* @date 2015��9��8�� ����4:04:56 
*/

class OverlayLayout extends RelativeLayout {
    
    // =============================================================================
    // Child views
    // =============================================================================
    // ��ʼ������
    private List<Drawable> mImgList = new ArrayList<Drawable>();//ջ������±���ʾ���ʼ����������ʾ
    private int mWidth;
    //���Զ�ȡ����
    private int imageSize;
    private int overlayWidth;
    
    private int maxCount; // ����ó�����ͼƬ��ʾ����
    private int imgNum; // ʵ����ʾ��ͼƬ����
    
    private Context mContext;
    
    // =============================================================================
    // Constructor
    // =============================================================================
    public OverlayLayout(Context context) {
        this(context, null);
    }
    
    public OverlayLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public OverlayLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.overlay);
        imageSize = mTypedArray.getDimensionPixelSize(R.styleable.overlay_imageSize, 30);
        overlayWidth = mTypedArray.getDimensionPixelSize(R.styleable.overlay_overlayWidth, 8);
        this.mWidth = Tools.dip2px(mContext, Tools.getScreenWidth((Activity)mContext));
    }
    
    
    /**
     * ����Ҫ���õĻ��ƺ���������Ҫ��ʾ��ͼƬList�Ϳؼ����
     * List<Drawable> imgList
     * int width
     */
    public void initOverlay(List<Drawable> imgList, int width) {
        this.mWidth = width;
        this.mImgList = imgList;
        drawOverlay();
    }
    
    /**
     * ���»��ƺ���������Ҫ��ʾ��ͼƬList
     * List<Drawable> imgList
     * int width
     */
    public void updateOverlay(List<Drawable> imgList) {
        this.mImgList = imgList;
        drawOverlay();
    }
    
    public void drawOverlay() {
        // ���������ʾ��ͼƬ��Ŀ
        maxCount = (mWidth-overlayWidth) / (imageSize - overlayWidth);
        // ����ʵ��Ҫ���Ƶ�ͼƬ��Ŀ
        imgNum = Math.min(maxCount, mImgList.size());
        removeAllViews();
        for (int i = 0; i < imgNum; i++) {
            int index = mImgList.size() - imgNum + i;
            int left = (imgNum - i - 1) * (imageSize - overlayWidth);
            addDrawable(mImgList.get(index), left);
        }
    }
    
    
    private void addDrawable(Drawable drawable, int left){
        ImageView imageView = new ImageView(mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(imageSize,
            imageSize);
        int top = 0;
        int right = 0;
        int bottom = 0;
        layoutParams.setMargins(left, top, right, bottom);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(drawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(imageView);
    }

    
}
