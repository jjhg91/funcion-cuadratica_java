/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcioncuadratica2;

import static funcioncuadratica2.FuncionCuadratica2.datos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JHG-7
 */
public class Plano extends JPanel{
        ArrayList<JLabel> numerod = new ArrayList<JLabel>();
        ArrayList<JLabel> numeroi = new ArrayList<JLabel>();
        int multi = 1;
    public Plano(){
        
        
        this.setBackground(Color.WHITE);
        this.setBounds(200, 0, 600, 600);
        this.setLayout(null);
       
        
        
        //AGREGANDO NUMERO AL PLANO CARTECIANO
        for(int i=0; i < 20;i++){
            // NUMEROS DE ARRIBA ABAJO
            numerod.add(new JLabel(""+(10-i)));
            numerod.get(i).setBounds(this.getWidth()/2, i*30, 50, 10);
            this.add(numerod.get(i));
            //NUMEROS DE IZQUIERDA A DERECHA
            numeroi.add(new JLabel(""+(-10+i)));
            numeroi.get(i).setBounds(i*30, this.getHeight()/2, 50, 10);
            this.add(numeroi.get(i));
   
        }
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //CUADRICULA
        g.setColor(Color.LIGHT_GRAY);
        for(int i=1; i < 20;i++){
            g.drawLine(0, i*30, this.getWidth(), i*30);
            g.drawLine(i*30, 0, i*30, this.getHeight());
        }
        
        
        
        //PLANO CARTECIANO
        g.setColor(Color.RED);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        
        //PUNTOS
        
        for(int i = 0; i < 5;i++){
            g.fillOval((int)(((datos.getX()[i]/this.multi)+10)*30), (int)((((-1*(int)datos.getY()[i])/this.multi)+10)*30), 10, 10);

            

        }
        
     
        
    }
    
    
    
    
        public void numeros(){

            //QUE NUMEROS PONER 
            float nx = datos.getX()[0];
            float ny = datos.getY()[0];
            float max = 9;
            for(int i = 0; i < 4; i++){
                if(datos.getX()[i] < 0 || datos.getY()[i] < 0){
                    if((-1*datos.getX()[i]) > nx){
                        nx = -1*datos.getX()[i];
                    }
                    if((-1*datos.getY()[i]) > ny){
                        ny = -1*datos.getY()[i];
                    }
                }
                if(datos.getX()[i] > 0 || datos.getY()[i] > 0){
                    if(datos.getX()[i] > nx){
                        nx = datos.getX()[i];
                    }
                    if(datos.getY()[i] > ny){
                        ny = datos.getY()[i];
                    }
                }

            }
            if(ny > nx && ny > max){
                max = ny;
            }else{this.multi=1;}
            if(nx > ny && nx > max){
                max = nx;
            }else{this.multi=1;}
            int aa=9;
            for(int i=1; aa < max;i++){
                aa=i*9;
                this.multi=i;
            }
        
        
        
            //AGREGANDO NUMERO AL PLANO CARTECIANO
            for(int i=0; i < 19;i++){
                // NUMEROS DE ARRIBA ABAJO
                numerod.get(i).setText(""+((10-i)*multi));
                //NUMEROS DE IZQUIERDA A DERECHA
                numeroi.get(i).setText(""+((-10+i)*multi));

            }
        
        

        }
    
    

}
