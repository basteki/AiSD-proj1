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
    
    static int n = 4;/* liczba punktów do wygenerowania*/
    static int MaxX = 300;      /*Maksymalna wartość osi x*/
    static int MaxY = 300;      /*Maksymalna wartość osi y*/
    /**
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        
        int i, j, k;
       
        int[] Xs = new int[n];
        int[] Ys = new int[n];
        int z = 0;
        PGenerator gen = new PGenerator();
        /*
        Xs[0]= 9;        Xs[1]= 8;        Xs[2]= 7;        Xs[3]= 6;    Xs[4]= 6;
        Xs[5]= 5;        Xs[6]= 4;        Xs[7]= 3;        Xs[8]= 2;    Xs[9]= 1;
        
        Ys[0]= 9;        Ys[1]= 8;        Ys[2]= 7;        Ys[3]= 6;    Ys[4]= 6;
        Ys[5]= 5;        Ys[6]= 4;        Ys[7]= 3;        Ys[8]= 2;    Ys[9]= 1;
        */
        
        Xs= gen.Generate(n, MaxX);
        Ys= gen.Generate(n, MaxY);
        
        OrderPoint ord = new OrderPoint();
        int[] x = ord.OrderX(Xs, Ys);
        int[] y = ord.OrdY(Ys);
        
        g.drawOval(x[0]-10, y[0]-10, 20, 20);
        
        int Xp, Yp,  Dx, Dy, Xtmp, Ytmp;
        int Xz = x[1]; //just for init
        int Yz = y[1];//just for init
        
        for(i = 0; i<n ; i++){
            g.drawOval(x[i]-5, y[i]-5, 10, 10);
        }
        
        OrderPoint jar = new OrderPoint();
        
        int idx  = 0;
        int p = idx;
        Xp=0;
        Yp=y[0];
        
        System.out.print("idx=");
        System.out.println(idx);
            
            
        z = jar.Jarvis(x, y, Xp, Yp, idx, n);
        
        g.drawLine(x[p], y[p], x[z], y[z]);
        
        Xp=x[p];
        Yp=y[p];
        
        idx = z;
        
        int l =n;
        
        while(z!=0 && l>0){
            
            p = idx;
            
            System.out.print("idx=");
            System.out.println(idx);
            
            
            z = jar.Jarvis(x, y, Xp, Yp, idx, n);
        
            g.drawLine(x[idx], y[idx], x[z], y[z]);
        
            Xp=x[p];
            Yp=y[p];
        
            idx = z;
            p = idx;
            l--;
        }
        /*
        //Rysowanie otoczki
        for(j = 0; j+1<n ; j++){
           
            Xp = x[j];
            Yp = y[j]; 
            
            for(k = j+1; k<n; k++){
            
                Xtmp=x[k];
                Ytmp=y[k];
                
                Dx = (Xtmp - Xp);
                Dy = (Ytmp - Yp);
                
                int C = 0; // poprawka dla cwiartek I-IV 
                
                if(Dx>0 && Dy>0){
                    C = 0;
                }else if(Dx>0 && Dy<0){
                     C = 180;   
                }else if(Dx<0 && Dy<0){
                     C = 180;  
                }else if(Dx<0 && Dy>0){
                     C = 360;  
                }
                
                double FItmp;
                double FI = 0;
                
                double D = (Dy/Dx);
                
                double radians = Math.toRadians(D);
                FItmp = Math.toDegrees(Math.atan(Math.sin(radians))) + C;
               
                
                
                if(FItmp>FI){
                    FI = FItmp;
                    Xz = Xtmp;
                    Yz = Ytmp;
                    
                }
                g.drawLine(Xp, Yp, Xz, Yz);//should be after first loop... it looks cool tho...
            }
            
            //g.drawLine(Xp, Yp, Xz, Yz);
            
            //g.drawPolygon (x, y, x.length);  
        }
        //g.drawLine(x[n-1], y[n-1], x[0], y[0]);
       */
  }
    
    
    
    public static void main(String[] args) {
                      
        int i;
                     
         
         JFrame window = new JFrame();
         window.setBounds(30, 30, MaxX+100, MaxY+100);
         window.getContentPane().add(new ProjektI());
         window.setVisible(true);
                       
         
                      
         }
    }

    

