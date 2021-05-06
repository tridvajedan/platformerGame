package map;

import java.util.Random;

public class MapGenerator {


    public static BlockManager generateMap()
    {
        Block block = new Block(0,700,250,100);
        BlockManager blockManager = new BlockManager();
        blockManager.addBlock(block);
        Random r = new Random();
        for(int i = 1; i < 50;i++)
        {
            int yGap = r.nextInt(350);
            int xGap = r.nextInt(500);
            int w = r.nextInt(2500);
            int h = r.nextInt(2500);
            yGap = yGap/10;
            w = w/10;
            h = h/10;
            while(xGap < 31) {
                xGap = r.nextInt(50);
            }
            xGap = xGap/10;
            Block block1 = blockManager.blocks.get(i-1);
            blockManager.addBlock(new Block(block1.x+ block1.width+xGap,block1.y- block1.height-yGap,w,h));
        }
        return blockManager;
    }
}
