package view;

import input.GameInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Game {
    public GameInput gameInput = new GameInput();
    private JFrame frame;
    private GamePanel gamePanel = new GamePanel(this);
    public Game(int width,int height,String title)
    {
        frame = new JFrame(title);
        frame.getContentPane().setPreferredSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.requestFocus();
        frame.addKeyListener(gameInput);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(gamePanel);
    }

    public boolean isPressed(int key)
    {
        return gameInput.isPressed(key);
    }
}
