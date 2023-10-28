import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame implements ActionListener {
    private JLabel titulo,titulo1,mensaje,derechos,logo;
    private GeneralMotors captiva,colorado,groove,joy;
    public static String[] auto = new String[4];
    public static double[] precio = new double[4];
    public static String[][] tabla = new String[4][16];
    private String linkCaptiva = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/captiva";
    private String linkColorado = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/colorado";
    private String linkGroove = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/groove";
    private String linkJoy = "https://www.autocosmos.com.ec/catalogo/vigente/chevrolet/joy";
    private JTextField nombre;
    JButton aceptar;
    public static String nombreU;
    public Main(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculadora de Progresos");
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());

        logo = new JLabel(new ImageIcon(getClass().getResource("imagenes/GMGP.png")));
        logo.setBounds(150,40,100,100);
        add(logo);

        titulo = new JLabel("Sistema de compra de vehículos");
        titulo.setBounds(50,150,350,40);
        titulo.setFont(new Font("Prototype",3,20));
        titulo.setForeground(new Color (54, 111, 211));
        add(titulo);
        titulo1 = new JLabel("Sistema de compra de vehículos");
        titulo1.setBounds(52,152,350,40);
        titulo1.setFont(new Font("Prototype",3,20));
        titulo1.setForeground(new Color (0, 0, 0));
        add(titulo1);

        mensaje = new JLabel("Ingrese su nombre: ");
        mensaje.setBounds(50,180,200,40);
        mensaje.setFont(new Font("Andale Mono",1,14));
        mensaje.setForeground(new Color(0,0,0));
        add(mensaje);

        nombre = new JTextField();
        nombre.setBounds(50,215,300,25);
        add(nombre);

        aceptar = new JButton("Siguiente");
        aceptar.addActionListener(this);
        aceptar.setBounds(150,260,100,30);
        add(aceptar);

        derechos = new JLabel("©Todos los derechos reservados");
        derechos.setBounds(100,300,200,30);
        derechos.setForeground(new Color(0,0,0));
        add(derechos);

        captiva = new GeneralMotors(linkCaptiva);
        auto[0]= captiva.titulo;
        precio[0]=Double.parseDouble(String.valueOf(captiva.price));
        tabla[0]=captiva.tabla;

        colorado = new GeneralMotors(linkColorado);
        auto[1]= colorado.titulo;
        precio[1]=Double.parseDouble(String.valueOf(colorado.price));
        tabla[1]=colorado.tabla;

        groove = new GeneralMotors(linkGroove);
        auto[2]= groove.titulo;
        precio[2]=Double.parseDouble(String.valueOf(groove.price));
        tabla[2]=groove.tabla;

        joy = new GeneralMotors(linkJoy);
        auto[3]= joy.titulo;
        precio[3]=Double.parseDouble(String.valueOf(joy.price));
        tabla[3]=joy.tabla;
    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar) {
            nombreU = nombre.getText();
            if(nombreU.isEmpty()){
                JOptionPane.showMessageDialog(null,"Rellene el campo 'Nombre'");
            }
            else{
                Automoviles ventana = new Automoviles();
                ventana.setBounds(0,0,690,600);
                ventana.setResizable(false);
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                this.setVisible(false);
            }
        }
    }
    public static void main(String[] args) {
        Main interfaz = new Main();
        interfaz.setBounds(0,0,410,400);
        interfaz.setVisible(true);
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);

    }

}