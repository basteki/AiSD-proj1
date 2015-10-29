/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

/**
 *
 * @author BASTEKI
 */
public class OrderPoint{
    public int[] OrderX(int[] x, int[] y){
       
        int i;
        int tmp;
        
        for(i = 0; i < x.length; i++ ){
            if(y[i] >= y[0]){
                if(y[i] > y[0]){
                    tmp = y[i];
                    y[i] = y[0];
                    y[0] = tmp;
                
                    tmp = x[i];
                    x[i] = x[0];
                    x[0] = tmp;
                }
                else{
                    if(y[i] < y[0]){
                        tmp = y[i];
                        y[i] = y[0];
                        y[0] = tmp;
                
                        tmp = x[i];
                        x[i] = x[0];
                        x[0] = tmp;
                    }
                }
            }
                
        }
                
        return x;
    }
    public int[] OrdY(int[] y){
        
        return y;
    }
    
    public int Jarvis(int[] x, int[] y, int Xp, int Yp, int idx, int n){
        
        int k;
            
           
        
        double FI = 0;   
        for(k = 0; k<n; k++){            
            
            
                int Xtmp=x[k];
                int Ytmp=y[k];
               
                double A = Math.sqrt((x[idx]-Xp)*(x[idx]-Xp)+(y[idx]-Yp)*(y[idx]-Yp));
                double B = Math.sqrt((Xtmp-x[idx])*(Xtmp-x[idx])+(Ytmp-y[idx])*(Ytmp-y[idx])) ;
                double C = Math.sqrt((Xtmp-Xp)*(Xtmp-Xp)+(Ytmp-Yp)*(Ytmp-Yp)) ;
            
                double Angle = Math.acos(((C*C)-(A*A)-(B*B))/(-2*A*B)); 
                
                System.out.print("angle=");
                System.out.println(Angle);
                
                if(Angle>FI){
                    idx = k;
                    FI = Angle;
                     
                }              
        }
        System.out.print("FI=");
        System.out.println(FI);  
        
        return idx;
    }
}