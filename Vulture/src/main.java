/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1342960
 */
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class main extends JFrame{
    public static int WIDTH = 1600;
    public static int HEIGHT = 830;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        new main();
    }
    
    public main() throws FileNotFoundException {
        super("Vulture");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        
        //new PointLines( #of points, redraw bckgrnd, color, changing gradient, bouncy, changing size, fill in area)
        Vulture game = new Vulture();
        ((Component) game).setFocusable(true);
        getContentPane().add(game);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
}
