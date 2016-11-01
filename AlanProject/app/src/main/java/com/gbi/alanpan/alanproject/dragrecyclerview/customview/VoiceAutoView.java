package com.gbi.alanpan.alanproject.dragrecyclerview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by alan.pan on 2016/11/1.
 */
public class VoiceAutoView extends View {

    public VoiceAutoView(Context context) {
        this(context, null);
    }

    public VoiceAutoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VoiceAutoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int mWidth;
        int mHeight;
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        /**
         * 设置宽度
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY)// match_parent , accurate
        {
            Log.e("xxx", "EXACTLY");
            mWidth = specSize;
        } else {
            // 由图片决定的宽
//            int desireByImg = getPaddingLeft() + getPaddingRight() + mImage.getWidth();
//            // 由字体决定的宽
//            int desireByTitle = getPaddingLeft() + getPaddingRight() + mTextBound.width();
            mWidth = getMeasuredWidth();
            if (specMode == MeasureSpec.AT_MOST)// wrap_content
            {
//                int desire = Math.max(desireByImg, desireByTitle);
//                mWidth = Math.min(desire, specSize);
                mWidth = getMeasuredWidth();
                Log.e("xxx", "AT_MOST");
            }
        }

        /***
         * 设置高度
         */

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY)// match_parent , accurate
        {
            mHeight = specSize;
        } else {
//            int desire = getPaddingTop() + getPaddingBottom() + mImage.getHeight() + mTextBound.height();
            mHeight = getMeasuredHeight();
            if (specMode == MeasureSpec.AT_MOST)// wrap_content
            {
//                mHeight = Math.min(desire, specSize);
                mHeight = getMeasuredHeight();
            }
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        //去锯齿
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);


//        canvas.drawRect(10, 150, 70, 190, paint);
        RectF re1 = new RectF(10, 200, 270, 330);

        canvas.drawRoundRect(re1, 8, 8, paint);
//        RectF rel1 = new RectF(10, 240, 70, 270);

//        canvas.drawLine(100,100,300,100,paint);
//        canvas.drawLine(100,100,100,200,paint);
//        canvas.drawLine(300,100,350,150,paint);
//        canvas.drawLine(300,200,350,150,paint);
//        canvas.drawLine(100,200,300,200,paint);

        //定义一个Path对象,封闭成一个三角形
        Path path1 = new Path();
        path1.moveTo(270, 240);
        path1.lineTo(270, 280);
        path1.lineTo(290, 260);
        path1.close();
        //根据path进行绘制,绘制三角形
        canvas.drawPath(path1, paint);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        RectF rectF = new RectF(20, 20, 100, 100);
        canvas.drawArc(rectF, 119, 125, false, paint);
        RectF rectF2 = new RectF(35, 35, 100, 85);
        canvas.drawArc(rectF2, 115, 130, false, paint);
        RectF rectF3 = new RectF(45, 45, 100, 75);
        canvas.drawArc(rectF3, 110, 140, false, paint);
    }
}
