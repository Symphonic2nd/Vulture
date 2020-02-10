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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class Vulture extends JPanel{
    public Eagle elmosworld;
    public Prey player;
    public Apple apple;
    public ArrayList<Predator> predator = new ArrayList<>();
    public int score;
    public int phase;
    public boolean go;
    public boolean add;
    public String direction;
    
    public Vulture() {
        add = false;
        score = 1;
        phase = 0;
        direction = "";
        go = false;
        elmosworld = new Eagle((int)(Math.random() * 100) + 800, (int)(Math.random() * 100) + 350);
        player = new Prey((int)(Math.random() * 100), (int)(Math.random() * 100) + 350);
        apple = new Apple((int)(Math.random() * 100) + 800, (int)(Math.random() * 100) + 350);
        predator = new ArrayList<Predator>();
        predator.add(new Predator((int)(Math.random() * 100) + 1490, (int)(Math.random() * 100) + 350));
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (phase == 0 && (e.getKeyCode() >= 37 && e.getKeyCode()<= 40)) {
                    go = true;
                    if (e.getKeyCode() == 37) {
                        direction = "left";
                    }
                    else if (e.getKeyCode() == 38) {
                        direction = "up";
                    }
                    else if (e.getKeyCode() == 39) {
                        direction = "right";
                    }
                    else if (e.getKeyCode() == 40) {
                        direction = "down";
                    }
                }
//                if (phase == 0 && e.getKeyCode() == 32) {
//                    //predator.add(new Predator((int)(Math.random() * 1500), (int)(Math.random() * 830)));
//                    predator.add(new Predator((int)(Math.random() * 100) + 1490, (int)(Math.random() * 830)));
//                }
                if (phase == 1 && e.getKeyCode() == 32) {
                    phase = 0;
                    player = new Prey((int)(Math.random() * 100), (int)(Math.random() * 100) + 350);
                    predator = new ArrayList<Predator>();
                    predator.add(new Predator((int)(Math.random() * 100) + 1490, (int)(Math.random() * 100) + 350));
                    score = 1;
                }
                
                repaint();
            }
        });
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, 1600, 850);
        window.setColor(Color.RED);
        window.drawRect(0, 1, 1599, 829);
        window.setColor(Color.WHITE);
        window.drawString("Score: " + score, 10, 15);
        window.setColor(Color.BLUE);
        window.fillOval(player.x, player.y, 10, 10);
        //window.setColor(Color.GREEN);
        //window.fillRect(apple.x, apple.y, 10, 10);
        window.setColor(Color.RED);
        for (int i = 0; i < predator.size(); i++) {
            window.fillRect(predator.get(i).x, predator.get(i).y, 10, 10);
        }
        window.setColor(Color.GREEN);
        window.fillOval(elmosworld.x, elmosworld.y, 10, 10);
        
        if (go) {
            if (direction.equals("left") && player.x > 1) {
                player.setCoord(player.x - 1, player.y);
            }
            else if (direction.equals("right") && player.x + 10 < 1599) {
                player.setCoord(player.x + 1, player.y);
            }
            else if (direction.equals("up") && player.y > 1) {
                player.setCoord(player.x, player.y - 1);
            }
            else if (direction.equals("down") && player.y + 10 < 830) {
                player.setCoord(player.x, player.y + 1);
            }
            
            for (int i = 0; i < predator.size(); i++) {
                if (predator.get(i).x < player.x) {
                    int r = (int)(Math.random() * 2);
                    predator.get(i).setX(predator.get(i).x + r);
                }
                else if (predator.get(i).x > player.x) {
                    int r = (int)(Math.random() * 2);
                    predator.get(i).setX(predator.get(i).x - r);
                }
                if (predator.get(i).y < player.y) {
                    int r = (int)(Math.random() * 2);
                    predator.get(i).setY(predator.get(i).y + r);
                }
                else if (predator.get(i).y > player.y) {
                    int r = (int)(Math.random() * 2);
                    predator.get(i).setY(predator.get(i).y - r);
                }
                
                if (predator.get(i).y == player.y && predator.get(i).x == player.x) {
                    go = false;
                    phase = 1;
                }
            }
            
            
            
            int r = (int)(Math.random() * (500 - score * 4));
            if (r == 0) { 
                for (int i = -1; i < 0; i++) {
                    predator.add(new Predator((int)(Math.random() * 1600), (int)(Math.random() * 800)));
                    score++;
                }
            }
            if (predator.size() > 0) {
                if (elmosworld.x < predator.get(0).x) {
                    int w = (int)(Math.random() * 2);
                    elmosworld.setX(elmosworld.x + w);
                }
                else if (elmosworld.x > predator.get(0).x) {
                    int w = (int)(Math.random() * 2);
                    elmosworld.setX(elmosworld.x - w);
                }   
                if (elmosworld.y < predator.get(0).y) {
                    int w = (int)(Math.random() * 2);
                    elmosworld.setY(elmosworld.y + w);
                }
                else if (elmosworld.y > predator.get(0).y) {
                    int w = (int)(Math.random() * 2);
                    elmosworld.setY(elmosworld.y - w);
                }
                
                if (elmosworld.x == predator.get(0).x && elmosworld.y == predator.get(0).y) {
                    predator.remove(0);
                }
            }
            
        }
        
        if (phase == 1) {
            window.setColor(Color.WHITE);
            window.drawString("You have been Vultured: " + score, 700, 400);
            window.drawString("Press SPACE to restart", 700, 425);
            
        }
        repaint();
    }
}
