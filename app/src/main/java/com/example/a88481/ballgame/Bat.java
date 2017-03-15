package com.example.a88481.ballgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;


/**
 * Created by 88481 on 2017/3/15 0015.
 */

public class Bat {
    private SceneView sceneView;

    private int color = Color.BLUE;

    private Point position;

    private Size size = new Size(250,50);

    public Bat(SceneView sceneView){
        this.sceneView = sceneView;

        this.position = new Point(100, 200);
    }

    public Rect getFrame(){
        return new Rect(this.position.x,this.position.y,
                this.position.x + this.size.getWidth(),
                this.position.y + this.size.getHeight());
    }

    public void move(int x){
        this.position.x = x;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.color);

        this.position.y = this.sceneView.getBottom() - 200;

        canvas.drawRect(this.position.x,
                this.position.y,
                this.position.x + this.size.getWidth(),
                this.position.y + this.size.getHeight(),
                paint);

    }

}
