package com.example.a88481.ballgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by 88481 on 2017/3/15 0015.
 */

public class Ball {

    private int color = Color.RED;

    private Point position = new Point(40,60);

    private Speed speed = new Speed(10,10);

    private int radius = 30;

    private SceneView sceneView;

    public Ball(SceneView sceneView){
        this.sceneView = sceneView;
    }

    public void run(){

        this.position.x += this.speed.getX();
        this.position.y += this.speed.getY();

        if((this.position.x - this.radius < this.sceneView.getLeft())||
                (this.position.x + this.radius > this.sceneView.getRight()))
        {
            this.speed.setX(-this.speed.getX());
        }

        if((this.position.y - this.radius < this.sceneView.getTop())||
                (this.position.y + this.radius > this.sceneView.getBottom()))
        {
            this.speed.setY(-this.speed.getY());
        }

        Rect batFrame = this.sceneView.getBatFrame();

        if (this.position.x > batFrame.left &&
                this.position.y + this.radius > batFrame.top &&
                this.position.x < batFrame.right)
        {
            this.speed.setY(-this.speed.getY());
        }

    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.color);

        canvas.drawCircle(this.position.x,this.position.y,this.radius,paint);
    }

}
