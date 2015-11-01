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
    
    public int[] OrdX(int[] x, int[] y){
       
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
       
        //System.out.print("Xs=");
        //System.out.println(x[idx]); 
        
        //System.out.print("Ys=");
        //System.out.println(y[idx]);
        
        double FI = 0;   
        int s = idx;
        
        for(k = 0; k<n; k++){            
                   
                double A = Math.sqrt(  ((x[s]-Xp)*(x[s]-Xp))  +  ((y[s]-Yp)*(y[s]-Yp))  );
                double B = Math.sqrt(  ((x[k]-x[s])*(x[k]-x[s]))  +  ((y[k]-y[s])*(y[k]-y[s]))  ) ;
                double C = Math.sqrt(  ((x[k]-Xp)*(x[k]-Xp))  +  ((y[k]-Yp)*(y[k]-Yp))  ) ;
            
                double par = (  ((C*C)-(A*A)-(B*B))  /  (-2*A*B) );
                
                double Angle = Math.acos(par); 
                /*
                System.out.print("angle=");
                System.out.println(Angle);
                */
                if(Angle>=FI){
                    idx = k;
                    FI = Angle;
                     
                }              
        }
        /*
        System.out.print("FI=");
        System.out.println(FI);  
        
        System.out.print("Xp=");
        System.out.println(Xp); 
        
        System.out.print("Yp=");
        System.out.println(Yp);
        
        System.out.print("Xs=");
        System.out.println(x[idx]);
        
        System.out.print("Ys=");
        System.out.println(y[idx]);
        */
        return idx;
    }
}