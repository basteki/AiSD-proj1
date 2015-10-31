/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 *
 * @author BASTEKI
 */
public class ProjektI extends JComponent{
    
    
    
    
    static int n =6;/* liczba punktów do wygenerowania*/
    static int MaxX = 300;      /*Maksymalna wartość osi x*/
    static int MaxY = 300;      /*Maksymalna wartość osi y*/
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
        /*
        X[0]=10;
        Y[0]=10;  
                
        X[1]=50;
        Y[1]=80;  
                
        X[2]=20;
        Y[2]=90;
        
        */
        
        /*
        X[0]=40;
        Y[0]=40;  
                
        X[1]=60;
        Y[1]=100;  
                
        X[2]=80;
        Y[2]=40;
        
        X[3]=40;
        Y[3]=120;
        
        X[4]=140;
        Y[4]=140; 
        
        X[5]=160;
        Y[5]=140; 
        */
        //X[0]= 90;        X[1]= 110;        X[2]= 70;        X[3]= 60;    X[4]= 60;
       // X[5]= 50;        X[6]= 40;        X[7]= 30;        X[8]= 20;    X[9]= 10;
        
       // Y[0]= 20;        Y[1]= 110;        Y[2]= 70;        Y[3]= 60;    Y[4]= 60;
       // Y[5]= 50;        Y[6]= 140;        Y[7]= 30;        Y[8]= 20;    Y[9]= 10;
        
       
        X= gen.Generate(n, MaxX);
        Y= gen.Generate(n, MaxY);
        
        for(i =0; i<n; i++){
            System.out.print("X=");
            System.out.print(X[i]);
            System.out.print("    Y=");
            System.out.println(Y[i]);
            
        }
        System.out.println("");
        
        OrderPoint ord = new OrderPoint();
        int[] x = ord.OrdX(X, Y);
        int[] y = ord.OrdY(Y);
        
        for(i =0; i<n; i++){
            System.out.print("x=");
            System.out.print(x[i]);
            System.out.print("   y=");
            System.out.println(y[i]);
        }
        
        System.out.println("");
        
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
               
                  
         JFrame window = new JFrame();
         window.setBounds(30, 30, MaxX+100, MaxY+100);
         window.getContentPane().add(new ProjektI());
         window.setVisible(true);
                       
         
                      
         }
    }

    

