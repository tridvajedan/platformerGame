package map;

import player.Player;
import util.CollisionType;

import java.awt.*;

public class Block {
    public int x,y,width= 50,height = 50;
    public Rectangle hitbox;
    public Block(int x,int y)
    {
        this.x = x;
        this.y = y;
        hitbox = new Rectangle(x,y,width,height);
    }

    public Block(int x,int y,int width,int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitbox = new Rectangle(x,y,width,height);
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(24, 21, 21));
        g.fillRect(x,y,width,height);
    }

    public CollisionType checkCollision(Player player)
    {
        if(hitbox.intersects(new Rectangle(player.x,player.y+1,50,50)))
        {
            if(player.x-50 < x+width && player.x+50 > x && player.y+50 == y)
            {
                return CollisionType.TOP_HIT;
            }
            else{
                return CollisionType.SIDE_HIT;
            }
        }
        else
        {
            return CollisionType.NO_HIT;
        }
    }
}
