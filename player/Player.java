package player;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Player {
    public int x,y,velx=0,vely=0;
    private int jumpHeight = 14;
    private ScheduledExecutorService jumpCooldown = Executors.newScheduledThreadPool(1);
    public Runnable jumping = new Runnable() {
        @Override
        public void run() {
            canJump = true;
        }
    };
    public boolean isJumping = false;
    public boolean isFalling = true;
    public boolean canJump = true;

    public Player(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public void startJump()
    {
        if(canJump)
        {
            canJump = false;
            isJumping = true;
        }
    }

    public void jump() {
        if(isJumping) {
            y += -jumpHeight;
            jumpHeight--;
            if (jumpHeight == 0) {
                jumpHeight = 14;
                isJumping = false;
                jumpCooldown.schedule(jumping, 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void move()
    {
        x += velx;
        y += vely;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
    }


}
