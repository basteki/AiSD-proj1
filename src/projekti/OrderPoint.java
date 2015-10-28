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
}
