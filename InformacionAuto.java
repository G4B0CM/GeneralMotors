import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InformacionAuto extends JFrame implements ActionListener {
    private JLabel titulo,titulo1, subtitulo, imagen;
    private JTextArea cuadro;
    JButton aceptar, volver;
    private String modelo="",ruta="",tablaC="";
    private String[] tabla;

    public InformacionAuto(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        modelo = Automoviles.autoD;
        ruta = Automoviles.rutaD;
        tabla = Automoviles.tablaD;
        setTitle("INFORMACIÓN " + modelo);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());

        titulo = new JLabel(modelo);
        titulo.setBounds(253,5,300,30);
        titulo.setFont(new Font("Prototype",3,30));
        titulo.setForeground(new Color(255, 207, 0));
        add(titulo);

        titulo1 = new JLabel(modelo);
        titulo1.setBounds(255,7,300,30);
        titulo1.setFont(new Font("Prototype",3,30));
        titulo1.setForeground(new Color(0, 0, 0));
        add(titulo1);

        imagen = new JLabel(new ImageIcon(getClass().getResource(ruta)));
        imagen.setBounds(10,50,700,350);
        add(imagen);

        subtitulo = new JLabel("Características y modelos " +modelo);
        subtitulo.setBounds(20,400,600,30);
        subtitulo.setFont(new Font("Prototype",3,25));
        subtitulo.setForeground(new Color(255, 207, 0));
        add(subtitulo);

        for(int i =0; i<16;i+=4){
            if(tabla[i]!=null){
            tablaC += ("Modelo: "+ tabla[i]+"\n");
            tablaC += ("Precio: "+ tabla[i+1]+"\n");
            tablaC += ("Características: "+ tabla[i+2]+"\n");
            tablaC += tabla[i+3]+"\n";}
            else{
                break;
            }
        }

        cuadro = new JTextArea();
        cuadro.setText(tablaC);
        cuadro.setFont(new Font("Andale Mono",0,14));
        cuadro.setForeground(new Color(38, 38, 38));
        cuadro.setEditable(false);
        cuadro.setFocusable(false);
        cuadro.setBounds(20,430,675,Automoviles.medidas[0]);//solo se delimita el scroll panel
        add(cuadro);

        aceptar = new JButton("COMPRAR");
        aceptar.setBounds(590,Automoviles.medidas[1],100,30);
        aceptar.addActionListener(this);
        add(aceptar);

        volver = new JButton("Atrás");
        volver.setBounds(20,Automoviles.medidas[1],100,30);
        volver.addActionListener(this);
        add(volver);

    }

    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar){
            Facturacion tomaDeDatos = new Facturacion();
            tomaDeDatos.setBounds(0,0,400,400);
            tomaDeDatos.setVisible(true);
            tomaDeDatos.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(evento.getSource()==volver){
            Automoviles ventana = new Automoviles();
            ventana.setBounds(0,0,690,600);
            ventana.setResizable(false);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }

    }

    /*public static void main(String[] args) {
        InformacionAuto ventana = new InformacionAuto();
        ventana.setBounds(0,0,720,780);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }*/
}
