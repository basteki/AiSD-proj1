/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 *
 * @author BASTEKI
 */
public class ProjektI extends JComponent{
    
    
    static int n = 6;/* liczba punktów do wygenerowania*/
    static int m = 1000;/* liczba punktów do obliczania pola*/
    static int MaxX = 800;      /*Maksymalna wartość osi x*/
    static int MaxY = 800;      /*Maksymalna wartość osi y*/
    /**
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        
        int i, j, k;
       
        int[] X = new int[n];
        int[] Y = new int[n];
        int z = 0;
        PGenerator gen = new PGenerator();
         
        X= gen.Generate(n, MaxX);
        Y= gen.Generate(n, MaxY);
        
        /*do metody montecarlo*/
        int[] Xm = new int[n];
        int[] Ym = new int[n];
        int[] lines = new int[n];
        
        int countIn = 0;
        int countOut = 0;
        
        Xm= gen.Generate(m, MaxX);
        Ym= gen.Generate(m, MaxY);
        
        /*
        for(i =0; i<n; i++){
            System.out.print("X=");
            System.out.print(X[i]);
            System.out.print("    Y=");
            System.out.println(Y[i]);
        }
        System.out.println("");
        */
        
        OrderPoint ord = new OrderPoint();
        int[] x = ord.OrdX(X, Y);
        int[] y = ord.OrdY(Y);
        /*
        for(i =0; i<n; i++){
            System.out.print("x=");
            System.out.print(x[i]);
            System.out.print("   y=");
            System.out.println(y[i]);
        }
        System.out.println("");
        */
        
        g.drawOval(x[0]-10, y[0]-10, 20, 20);
        
        int Xp, Yp, Xs, Ys, Dx, Dy, Xtmp, Ytmp;
        int Xz = x[1]; //just for init
        int Yz = y[1];//just for init
        
        for(i = 0; i<n ; i++){
            g.drawOval(x[i]-5, y[i]-5, 10, 10);
        } 
            
          
        OrderPoint jar = new OrderPoint();
        
        int idx  = 0;
        int p = idx;
        Xp=x[0] - 10;
        Yp=y[0];
        /*
        System.out.print("idx=");
        System.out.println(idx);
        */   
            
        z = jar.Jarvis(x, y, Xp, Yp, idx, n);
        
        g.drawLine(x[p], y[p], x[z], y[z]);
        lines[0] = p;
        lines[1] = z;
        Xp=x[p];
        Yp=y[p];
        
        idx = z;
        
        int l =1;
        
        while(z!=0 ){
            
            p = idx;
            
            //System.out.print("idx=");
            //System.out.println(idx);
            
            
            z = jar.Jarvis(x, y, Xp, Yp, idx, n);
        
            g.drawLine(x[idx], y[idx], x[z], y[z]);
            
            lines[l]=p;
            lines[l+1]=z;
            
            Xp=x[p];
            Yp=y[p];
        
            idx = z;
            p = idx;
            l++;
        }
       
        MonteCarlo monte = new MonteCarlo(); 
           
        
        
        for(i=0; i<m; i++){
            if(monte.Intersect(x, y, lines, Xm[i], Ym[i])==2 || monte.Intersect(x, y, lines, Xm[i], Ym[i])==0){
                g.setColor(Color.RED);
                g.drawOval( Xm[i]-2, Ym[i]-2, 4, 4);
                g.setColor(Color.BLACK);
                countOut++;
            }
            else{
                g.setColor(Color.GREEN);
                g.drawOval(Xm[i]-2, Ym[i]-2, 4, 4);
                g.setColor(Color.BLACK);  
                countIn++;
            }
                
                
        }
        /*
        double field = ((countIn/countOut)*MaxX*MaxY);
        
        System.out.print("IN=  ");
        System.out.println(countIn);
        System.out.print("OUT=  ");
        System.out.println(countOut);
        System.out.print("Pole ~=  ");
        System.out.print(field);
        System.out.println("j^2");
        */
        
  }
    
    
    
    public static void main(String[] args) {            
               
             
         JFrame window = new JFrame();
         window.setBounds(30, 30, MaxX+100, MaxY+100);
         window.getContentPane().add(new ProjektI());
         window.setVisible(true);
                       
        }
    }

    

