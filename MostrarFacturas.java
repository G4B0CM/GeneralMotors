import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MostrarFacturas extends JFrame implements ActionListener {
    private JLabel titulo;
    private JTextArea cuadro;
    private JScrollPane barra;
    JButton aceptar;
    private String contenidoFactura;
    public MostrarFacturas(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());
        contenidoFactura = Administrador.leerArchivo("Facturas.txt");
        titulo = new JLabel("Facturas");
        titulo.setBounds(10, 10, 230, 30);
        titulo.setFont(new Font("Bernard MT", 3, 18));
        add(titulo);

        cuadro = new JTextArea();
        cuadro.setText(contenidoFactura);
        barra = new JScrollPane(cuadro);
        barra.setBounds(10, 40, 350, 300);
        add(barra);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(260, 350, 100, 25);
        aceptar.addActionListener(this);
        add(aceptar);


    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar){
            Automoviles ventana = new Automoviles();
            ventana.setBounds(0,0,690,600);
            ventana.setResizable(false);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }

}
