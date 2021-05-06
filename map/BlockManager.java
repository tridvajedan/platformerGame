package map;

import player.Player;
import util.CollisionType;

import java.awt.*;
import java.util.ArrayList;

public class BlockManager {
    public ArrayList<Block> blocks = new ArrayList<>();

    public BlockManager()
    {

    }

    public void addBlock(Block block)
    {
        blocks.add(block);
    }

    public void render(Graphics g)
    {
        for(Block block : blocks)
        {
            block.render(g);
        }
    }
    public CollisionType checkCollision(Player player)
    {
        for(Block block:blocks)
        {
           return block.checkCollision(player);
        }
        return CollisionType.NO_HIT;
    }
}
