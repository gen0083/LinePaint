package jp.gcreate.sample.linepaint;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Copyright 2016 G-CREATE
 */
public class PathPaintView extends View implements View.OnTouchListener{
    private Paint paint, drawPaint;
    private Bitmap drawBitmap;
    private Canvas drawCanvas;
    private Path path;

    public PathPaintView(Context context) {
        this(context, null);
    }

    public PathPaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathPaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PathPaintView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        setOnTouchListener(this);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);

        drawPaint = new Paint();

        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(drawBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(drawBitmap, 0, 0, drawPaint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getActionMasked();
        switch (action){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                onTouchDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                onTouchMove(event);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                onTouchUp(event);
                break;
        }
        drawCanvas.drawPath(path, paint);
        invalidate();
        return true;
    }

    private void onTouchDown(MotionEvent e){
        path.reset();
        path.moveTo(e.getX(), e.getY());
    }

    private void onTouchMove(MotionEvent e){
        path.lineTo(e.getX(), e.getY());
    }

    private void onTouchUp(MotionEvent e){
        path.lineTo(e.getX(), e.getY());
    }
}
