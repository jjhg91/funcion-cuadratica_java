/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcioncuadratica2;

/**
 *
 * @author JHG-7
 */
public class Calcular {
    public float a;
    private float b;
    private float c;
    private float[] x = new float[5];
    private float[] y = new float[5];
    
    public Calcular(){
        
    }
    
    
    public void calcula(float a, float b, float c){
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.x[2] = verticeX(this.a, this.b);
        this.y[2] = encontrarY(this.a, this.b, this.c, x[2]);
        this.x[3] = encontrarX(this.a, this.b, this.c)[0];
        this.y[3] = 0;
        this.x[1] = encontrarX(this.a, this.b, this.c)[1];
        this.y[1] = 0;
        this.x[0] = 0;
        this.y[0] = encontrarY(this.a, this.b, this.c, x[0]);
        
        this.x[4] = 0;
        this.y[4] = 0;
    }
    
    
    public void calcula2(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.x[2] = verticeX(this.a, this.b);
        this.x[1] = x[2] -1;
        this.x[0] = x[2] -2;
        this.x[3] = x[2] +1;
        this.x[4] = x[2] +2;
        
        this.y[2] = encontrarY(this.a, this.b, this.c, x[2]);
        this.y[1] = encontrarY(this.a, this.b, this.c, x[1]);
        this.y[0] = encontrarY(this.a, this.b, this.c, x[0]);
        this.y[3] = encontrarY(this.a, this.b, this.c, x[3]);
        this.y[4] = encontrarY(this.a, this.b, this.c, x[4]);
        
    }
    
    
    
    private static float verticeX(float a, float b){
        float vx;
        
        vx = (-1*b)/(2*a);
        return vx;
    }
    

    
    private static float[] encontrarX(float a, float b, float c){
        float[] x = new float[2];
        float xx;
        xx = (float)Math.sqrt((float)Math.pow(b,2)-4*a*c);
        x[0] = (xx + (-b))/2*a;
        x[1] = ((-1*b) - xx)/2*a;
        
        return x;
    }
    
    
    private static float encontrarY(float a, float b, float c, float x) {
        float y;
        if(b >=0){
            y = a * (float)Math.pow(x,2) + (b*x) + c;
        }else{
            y = a * (float)Math.pow(x,2) - (-b*x) + c;

        }
        return y;
    }
    
    public void getTodo(){
        System.out.println(
                "X1: "+this.x[0]+"Y1: "+this.y[0]+"\n"+
                "X2: "+this.x[1]+"Y2: "+this.y[1]+"\n"+
                "X3: "+this.x[2]+"Y3: "+this.y[2]+"\n"+
                "X4: "+this.x[3]+"Y4: "+this.y[3]+"\n"+
                "A: "+this.a+"\n"+
                "B: "+this.b+"\n"+
                "C: "+this.c
        
        );
    }
    
    public float[] getX(){
        return this.x;
    }
    
    public float[] getY(){
        return this.y;
    }
    
}
