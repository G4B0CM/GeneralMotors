import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Administrador extends JFrame implements ActionListener{
    private JLabel titulo,usuario,contra;
    private JTextField user,pass;
    JButton aceptar;
    private String contenidoFactura;

    public Administrador(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());
        setTitle("ADMINISTRADOR");
        titulo = new JLabel("Consola de Administrador");
        titulo.setBounds(30,10,230,30);
        titulo.setFont(new Font("Bernard MT",3,18));
        add(titulo);

        usuario = new JLabel("Usuario");
        usuario.setBounds(40,40,200,30);
        add(usuario);

        user = new JTextField();
        user.setBounds(40,70,200,25);
        add(user);

        contra = new JLabel("Contraseña");
        contra.setBounds(40,110,200,30);
        add(contra);

        pass = new JTextField();
        pass.setBounds(40,140,200,25);
        add(pass);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(95,200,100,30);
        aceptar.addActionListener(this);
        add(aceptar);


    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar){
            if(comprobarUC()){
                contenidoFactura = leerArchivo("Facturas.txt");
                if (contenidoFactura != null) {
                    this.setVisible(false);
                    MostrarFacturas tomaDeDatos = new MostrarFacturas();
                    tomaDeDatos.setBounds(0,0,380,425);
                    tomaDeDatos.setVisible(true);
                    tomaDeDatos.setLocationRelativeTo(null);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"No se pudo leer el archivo.");
                    Automoviles ventana = new Automoviles();
                    ventana.setBounds(0,0,690,600);
                    ventana.setResizable(false);
                    ventana.setVisible(true);
                    ventana.setLocationRelativeTo(null);
                    this.setVisible(false);
                }
            }
        }
    }
    public boolean comprobarUC(){
        boolean son=false;
        String usuario = "admin",contra = "1234",usuario1 = "",contra2 = "";
        usuario1= user.getText();
        contra2 = pass.getText();
        if (usuario1.equals(usuario)) {
            if(contra2.equals(contra)){
                JOptionPane.showMessageDialog(null,"Acceso concedido");
                son=true;
            }
            else{
                if(contra2.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Llena el campo contraseña");
                }
                JOptionPane.showMessageDialog(null,"Contraseña Incorrecta");
            }
        }
        else {
            if(usuario1.isEmpty()){
                JOptionPane.showMessageDialog(null,"Llena el campo usuario");
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuario Invalido");
            }
        }
        return son;
    }
    public static String leerArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            FileReader lector = new FileReader(archivo);
            BufferedReader lectorLimpio = new BufferedReader(lector);
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = lectorLimpio.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            lectorLimpio.close();
            lector.close();
            return contenido.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
