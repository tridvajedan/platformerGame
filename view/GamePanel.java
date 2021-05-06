package view;

import map.Block;
import map.BlockManager;
import map.MapGenerator;
import player.Player;
import util.CollisionType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    public Player player = new Player(50,350);
    public boolean isRunning = true;
    private Game game;
    private BlockManager blockManager = MapGenerator.generateMap();
    private Timer gameTimer = new Timer(5,this);
    private Thread movementThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(isRunning)
            {
                if(player.y > 1000)
                {
                    isRunning = false;
                }
                System.out.println("Player | X- " + player.x + " || Y- " + player.y);
                player.velx = 0;
                player.vely = 0;
                if(game.isPressed(KeyEvent.VK_A) && isHitting(new Player(player.x-5,player.y)) != CollisionType.SIDE_HIT)
                {
                    player.velx = -5;
                }
                else if(game.isPressed(KeyEvent.VK_D) && isHitting(new Player(player.x+5,player.y)) != CollisionType.SIDE_HIT)
                {
                    player.velx = 5;
                }
                if(game.isPressed(KeyEvent.VK_SPACE))
                {
                    player.startJump();
                }
                //System.out.println(isHitting(player));
                if( !player.isJumping && isHitting(player) == CollisionType.NO_HIT)
                {
                    player.isFalling = true;
                    player.vely = 5;
                }
                else
                {
                    player.jump();
                    player.isFalling = false;
                }
                player.move();
            }
        }
    });
    public GamePanel(Game game)
    {
        this.game = game;
        movementThread.start();
        gameTimer.start();
    }

    public CollisionType isHitting(Player player)
    {
        return blockManager.checkCollision(player);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(0,0,800,800);
        g.translate(-(player.x - 375),-(player.y - 375));
        blockManager.render(g);
        player.render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        blockManager.checkCollision(player);
        repaint();
    }
}
