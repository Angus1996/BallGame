package com.example.a88481.ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.os.Message;

/**
 * Created by 88481 on 2017/3/15 0015.
 */

public class SceneView extends View {

    private Ball ball;
    private Bat bat;
    private Player player;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what){
                case 1:
                    invalidate();
                    break;
            }
        }
    };

    private Thread thread = new Thread(){
        @Override
        public void run() {
            while(true){
                try {
                    sleep(20);

                    Message message = new Message();
                    message.what = 1;

                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public SceneView(Context context) {
        super(context);

        this.ball = new Ball(this);
        this.bat = new Bat(this);

        this.thread.start();
    }

    public Rect getBatFrame(){
        return this.bat.getFrame();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.ball.run();

        this.ball.draw(canvas);
        this.bat.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:

                this.bat.move((int)event.getX());
                this.invalidate();

                break;
        }


        return true;
    }
}
