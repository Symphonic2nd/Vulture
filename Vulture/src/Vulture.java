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
    
    public Vulture() {
        
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        window.setColor(Color.WHITE);
        window.drawString("Score", 10, 50);
    }
}
