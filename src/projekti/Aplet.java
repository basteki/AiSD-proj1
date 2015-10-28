/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import java.awt.*;
import java.applet.*;
  
/**
 *
 * @author Idavor
 */
public class Aplet extends Applet {
     	

  	public void init() 
  	{
            }
 	public void paint(Graphics gr)
 	{
 	    Point p = new Point();
 	    Dimension r = this.size();
 
 		int x[] = new int[3],y[]= new int[3],n=3;
 		x[0]=10;x[1]=115;x[2]=63;
 		y[0]=10;y[1]=10;y[2]=140;
 
 		Color kolor;
 		kolor = new Color(255,0,0);
 		gr.setColor(kolor);
 		gr.drawPolygon(x,y,n);
 
 		x[0]+=125;x[1]+=125;x[2]+=125;
 		y[0]=10;y[1]=10;y[2]=140;
 		
 		kolor = new Color(0,255,0);
 		gr.setColor(kolor);
 		gr.fillPolygon(x,y,n);
    }
 }
 

