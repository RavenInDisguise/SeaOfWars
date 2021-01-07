/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seaswar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jennifer
 */
public class SeasWar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int color1 = 10;
        int color2 = 10;
        int color3 = 80;
        convertMatrixToGUI(color1, color2, color3);
    }
    private static void convertMatrixToGUI(int color1, int color2, int color3) {
    int cantidad1 = (color1*600)/100; //GRIS - 180
    int cantidad2 = (color2*600)/100; //AZUL - 240
    int cantidad3 = (color3*600)/100; //VERDE - 180
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;
    
    String [][]matrix = new String[21][31];
    JButton [][]butt = new JButton[21][31];

    JFrame f = new JFrame("Matriz de civilización");
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(21, 31));

    for(int r=0; r<=20; r++){
        for(int c=0; c<=30; ){
            butt[r][c] = new JButton(matrix[r][c]);
            butt[r][c].setPreferredSize(new Dimension(40, 40));
            if (r==0 && c==0){
                butt[r][c].setBackground(Color.WHITE);
                p.add(butt[r][c]);
                c++;
            }
            else if (r==0){
                butt[r][c].setBackground(Color.WHITE);
                butt[r][c].setText(""+c);
                p.add(butt[r][c]);
                c++;
            }
            else if (c==0){
                butt[r][c].setBackground(Color.WHITE);
                butt[r][c].setText(""+r);
                p.add(butt[r][c]);
                c++;
            }else{
                int caso = (int) (Math.random() * 3) + 1;
                switch (caso) {
                    case 1:
                        if (cont1<cantidad1){
                            butt[r][c].setBackground(Color.LIGHT_GRAY);
                            p.add(butt[r][c]);
                            cont1+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    case 2:
                        if (cont2<cantidad2){
                            butt[r][c].setBackground(Color.BLUE);
                            p.add(butt[r][c]);
                            cont2+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                    default:
                        if (cont3<cantidad3){
                            butt[r][c].setBackground(Color.GREEN);
                            p.add(butt[r][c]);
                            cont3+=1;
                            c++;
                            continue;
                        }else{
                            continue;
                        }
                        
                }
            }
        }
    }

    f.add(p);
    f.pack();
    f.setVisible(true);
}
    
}
