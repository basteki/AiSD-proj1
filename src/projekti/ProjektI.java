/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 *
 * @author BASTEKI
 */
public class ProjektI extends JComponent{
    
    static int n = 10;/* liczba punktów do wygenerowania*/
    static int MaxX = 1000;      /*Maksymalna wartość osi x*/
    static int MaxY = 1000;      /*Maksymalna wartość osi y*/
    /**
     * @param g
     */
    public void paint(Graphics g) {
        
        int i;
        int[] Xs = new int[n];
        int[] Ys = new int[n];
         
        PGenerator gen = new PGenerator();
        Xs= gen.Generate(n, MaxX);
        Ys= gen.Generate(n, MaxY);
        
        OrderPoint ord = new OrderPoint();
        int[] x = ord.OrderX(Xs, Ys);
        int[] y = ord.OrdY(Ys);
        
        g.drawOval(x[0]-15, y[0]-15, 30, 30);
        
        for(i = 1; i<n ; i++)
            g.drawOval(x[i]-5, y[i]-5, 10, 10);
        g.drawPolygon (x, y, x.length);    
  }
    
    
    public static void main(String[] args) {
                      
        int i;
                     
         
         JFrame window = new JFrame();
         window.setBounds(30, 30, MaxX, MaxY);
         window.getContentPane().add(new ProjektI());
         window.setVisible(true);
                       
         
                      
         }
    }
    

