import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Automoviles extends JFrame implements ActionListener {
    private JLabel titulo,titulo1,nombre,carro[],costo[];
    JButton fotos[],admin;
    private String linkCaptiva = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/captiva";
    private String linkColorado = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/colorado";
    private String linkGroove = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/groove";
    private String linkJoy = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/joy";

    private String[] auto = new String[4];
    private double[] precio = new double[4];
    private String[][] tabla = new String[4][16];
    //private GeneralMotors captiva,colorado,groove,joy;
    private String nombreI="";
    public static String autoD="",rutaD="";
    public static double precioD=0;
    public static int[] medidas = new int[3];
    public static String[] tablaD = new String[16];
    public Automoviles(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("CATÁLOGO");
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());

        titulo = new JLabel("CATÁLOGO");
        titulo.setBounds(253,5,300,30);
        titulo.setFont(new Font("Prototype",3,30));
        titulo.setForeground(new Color(255, 207, 0));
        add(titulo);

        titulo1 = new JLabel("CATÁLOGO");
        titulo1.setBounds(255,7,300,30);
        titulo1.setFont(new Font("Prototype",3,30));
        titulo1.setForeground(new Color(0, 0, 0));
        add(titulo1);

        nombreI=Main.nombreU;

        carro = new JLabel[4];
        costo = new JLabel[4];
        fotos = new JButton[4];

        auto[0]= Main.auto[0];
        precio[0]=Double.parseDouble(String.valueOf(Main.precio[0]));
        tabla[0]=Main.tabla[0];

        auto[1]= Main.auto[1];
        precio[1]=Double.parseDouble(String.valueOf(Main.precio[1]));
        tabla[1]=Main.tabla[1];

        auto[2]= Main.auto[2];
        precio[2]=Double.parseDouble(String.valueOf(Main.precio[2]));
        tabla[2]=Main.tabla[2];

        auto[3]= Main.auto[3];
        precio[3]=Double.parseDouble(String.valueOf(Main.precio[3]));
        tabla[3]=Main.tabla[3];

        nombre = new JLabel(nombreI + " da click en un auto para más información: ");
        nombre.setBounds(70,50,400,30);
        nombre.setFont(new Font("Prototype",3,14));
        nombre.setForeground(new Color(0,0,0));
        add(nombre);

        carro[0] = new JLabel(auto[0]);
        carro[0].setBounds(70,80,200,30);
        carro[0].setFont(new Font("Prototype",3,18));
        carro[0].setForeground(new Color(0,0,0));
        add(carro[0]);

        carro[1] = new JLabel(auto[1]);
        carro[1].setBounds(360,80,200,30);
        carro[1].setFont(new Font("Prototype",3,18));
        carro[1].setForeground(new Color(0,0,0));
        add(carro[1]);

        carro[2] = new JLabel(auto[2]);
        carro[2].setBounds(70,300,200,30);
        carro[2].setFont(new Font("Prototype",3,18));
        carro[2].setForeground(new Color(0,0,0));
        add(carro[2]);

        carro[3] = new JLabel(auto[3]);
        carro[3].setBounds(360,300,200,30);
        carro[3].setFont(new Font("Prototype",3,18));
        carro[3].setForeground(new Color(0,0,0));
        add(carro[3]);

        costo[0] = new JLabel("Desde "+ String.valueOf(precio[0]*1000)+"0 $");
        costo[0].setBounds(70,250,200,30);
        costo[0].setFont(new Font("Prototype",3,18));
        costo[0].setForeground(new Color(0,0,0));
        add(costo[0]);

        costo[1] = new JLabel("Desde "+ String.valueOf(precio[1]*1000)+"0 $");
        costo[1].setBounds(360,250,200,30);
        costo[1].setFont(new Font("Prototype",3,18));
        costo[1].setForeground(new Color(0,0,0));
        add(costo[1]);

        costo[2] = new JLabel("Desde "+ String.valueOf(precio[2]*1000)+"0 $");
        costo[2].setBounds(70,480,200,30);
        costo[2].setFont(new Font("Prototype",3,18));
        costo[2].setForeground(new Color(0,0,0));
        add(costo[2]);

        costo[3] = new JLabel("Desde "+ String.valueOf(precio[3]*1000)+"0 $");
        costo[3].setBounds(360,480,200,30);
        costo[3].setFont(new Font("Prototype",3,18));
        costo[3].setForeground(new Color(0,0,0));
        add(costo[3]);

        fotos[0] = new JButton(new ImageIcon(getClass().getResource("imagenes/captivaP.png")));
        fotos[0].setBounds(70,110,250,140);
        fotos[0].setBackground(new Color(162, 162, 162));
        fotos[0].addActionListener(this);
        add(fotos[0]);

        fotos[1] = new JButton(new ImageIcon(getClass().getResource("imagenes/coloradoP.png")));
        fotos[1].setBounds(360,110,250,140);
        fotos[1].setBackground(new Color(162, 162, 162));
        fotos[1].addActionListener(this);
        add(fotos[1]);

        fotos[2] = new JButton(new ImageIcon(getClass().getResource("imagenes/grooveP.png")));
        fotos[2].setBounds(70,330,250,140);
        fotos[2].setBackground(new Color(162, 162, 162));
        fotos[2].addActionListener(this);
        add(fotos[2]);

        fotos[3] = new JButton(new ImageIcon(getClass().getResource("imagenes/joyP.png")));
        fotos[3].setBounds(360,330,250,140);
        fotos[3].setBackground(new Color(162, 162, 162));
        fotos[3].addActionListener(this);
        add(fotos[3]);

        admin = new JButton(".");
        admin.setBounds(0,550,700,100);
        admin.addActionListener(this);
        add(admin);
    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==fotos[0]){
            autoD = auto[0];
            precioD = precio[0]*1000;
            tablaD = tabla[0];
            rutaD = "imagenes/captiva.png";
            medidas[0] = 290;
            medidas[1]= 730;
            medidas[2]= 810;
            InformacionAuto ventana = new InformacionAuto();
            ventana.setBounds(0,0,720, medidas[2]);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);

        }
        else if(evento.getSource()==fotos[1]){
            autoD = auto[1];
            precioD = precio[1]*1000;
            tablaD = tabla[1];
            rutaD = "imagenes/colorado.png";
            medidas[0] = 290;
            medidas[1]= 730;
            medidas[2]=810;
            InformacionAuto ventana = new InformacionAuto();
            ventana.setBounds(0,0,720, medidas[2]);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(evento.getSource()==fotos[2]){
            autoD = auto[2];
            precioD = precio[2]*1000;
            tablaD = tabla[2];
            rutaD = "imagenes/grooveMP.png";
            medidas[0] = 140;
            medidas[1]= 580;
            medidas[2]= 660;
            InformacionAuto ventana = new InformacionAuto();
            ventana.setBounds(0,0,720, medidas[2]);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(evento.getSource()==fotos[3]){
            autoD = auto[3];
            precioD = precio[3]*1000;
            tablaD = tabla[3];
            rutaD = "imagenes/joyMP.png";
            medidas[0] = 80;
            medidas[1]= 520;
            medidas[2]=600;
            InformacionAuto ventana = new InformacionAuto();
            ventana.setBounds(0,0,720,medidas[2]);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(evento.getSource()==admin){
            Administrador ventana = new Administrador();
            ventana.setBounds(0,0,300,300);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
}
