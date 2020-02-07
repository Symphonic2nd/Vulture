/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1342960
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Vulture extends JPanel{
    
    public Prey player;
    public Apple apple;
    public ArrayList<Predator> predator = new ArrayList<>();
    public int score;
    public int phase;
    
    public Vulture() {
        score = 0;
        phase = 0;
        player = new Prey((int)(Math.random() * 100), (int)(Math.random() * 100) + 600);
        apple = new Apple((int)(Math.random() * 100) + 800, (int)(Math.random() * 100) + 600);
        predator = new ArrayList<Predator>();
        predator.add(new Predator((int)(Math.random() * 100) + 1500, (int)(Math.random() * 100) + 600));
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        window.setColor(Color.WHITE);
        window.drawString("Score: " + score, 10, 10);
        window.setColor(Color.BLUE);
        window.fillRect(player.x, player.y, 10, 10);
        window.setColor(Color.GREEN);
        window.fillRect(apple.x, apple.y, 10, 10);
        window.setColor(Color.RED);
        for (int i = 0; i < predator.size(); i++) {
            window.fillRect(predator.get(i).x, predator.get(i).y, 10, 10);
        }
    }
}
