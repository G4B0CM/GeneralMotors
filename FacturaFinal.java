import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class FacturaFinal extends JFrame implements ActionListener {
    private JLabel titulo;
    private JTextArea cuadro;
    private JScrollPane barra;
    JButton aceptar, volver;
    private String factura;

    public FacturaFinal(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());
        titulo = new JLabel("Revise si los datos son correctos: ");
        titulo.setBounds(10,10,400,18);
        titulo.setFont(new Font("Prototype",1,18));
        add(titulo);

        factura = "\nFactura n# " + Facturacion.codigoF + "\n"
        + "Nombre: "+ Facturacion.nombreF +"\n"
        + "Cédula: "+ Facturacion.cedulaF + "\n"
                + "Teléfono: "+ Facturacion.teleF + "\n"
                + "Dirección: "+ Facturacion.direccionF + "\n"
                + "Fecha: "+ Facturacion.fechaF + "\n"
                + "Modelo: "+ Facturacion.modeloF + "\n"
                + "Precio: "+ Facturacion.valorF + "\n";


        cuadro = new JTextArea();
        cuadro.setText(factura);
        cuadro.setFont(new Font("Andale Mono",1,16));
        barra = new JScrollPane(cuadro);// se pone el scroll panel dentro del cuadrado
        barra.setBounds(10, 40, 350, 360); //solo se delimita el scroll panel
        add(barra);

        aceptar = new JButton("Finalizar Compra!");
        aceptar.setBounds(200,400,160,25);
        aceptar.addActionListener(this);
        add(aceptar);

        volver = new JButton("Volver");
        volver.setBounds(20,400,100,25);
        volver.addActionListener(this);
        add(volver);
    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar){
            JOptionPane.showMessageDialog(null,Facturacion.nombreF
            + " gracias por tu compra");
            //agregarFacturaAlArchivo(factura,"Facturas.txt");
            guardarFacturaEnArchivo(factura,"Facturas.txt");
            Automoviles ventana = new Automoviles();
            ventana.setBounds(0,0,690,600);
            ventana.setResizable(false);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        else if(evento.getSource()==volver){
            Facturacion tomaDeDatos = new Facturacion();
            tomaDeDatos.setBounds(0,0,400,400);
            tomaDeDatos.setVisible(true);
            tomaDeDatos.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
    public static void guardarFacturaEnArchivo(String factura, String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            FileWriter escritor = new FileWriter(archivo,true);
            BufferedWriter limpiador = new BufferedWriter(escritor);
            limpiador.write(factura);
            limpiador.close();
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

