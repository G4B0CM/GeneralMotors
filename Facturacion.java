import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.util.Random;
public class Facturacion extends JFrame implements ActionListener{
    private JLabel titulo,nombre,ci,tel,sector,fecha,modelo,valor,valorIva,logo;
    private JTextField id,telf,sec;
    JButton aceptar, volver;
    private String model="";
    private Random random;
    private int codigo=0;
    private double precio=0;
    public static String nombreF="",cedulaF="",teleF="",direccionF="",valorF="",fechaF="",codigoF="",modeloF="";

    public Facturacion(){
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("DATOS PARA FACTURACION");
        setIconImage(new ImageIcon(getClass().getResource("imagenes/logoGM.png")).getImage());

        model= Automoviles.autoD;
        precio = Automoviles.precioD;
        random = new Random();
        codigo = random.nextInt(900000) + 100000;

        titulo = new JLabel("DATOS PARA FACTURACION");
        titulo.setBounds(60,5,300,30);
        titulo.setFont(new Font("Prototype",1,20));
        titulo.setForeground(new Color(25, 67, 144));
        add(titulo);

        nombre = new JLabel(Main.nombreU);
        nombre.setBounds(20,50,125,30);
        nombre.setFont(new Font("Prototype",3,14));
        nombre.setForeground(new Color(0,0,0));
        add(nombre);

        ci = new JLabel("#Cédula: ");
        ci.setBounds(20,80,150,25);
        ci.setFont(new Font("Andale Mono",1,12));
        ci.setForeground(new Color(0,0,0));
        add(ci);

        id = new JTextField();
        id.setBounds(20,105,125,25);
        add(id);

        tel = new JLabel("Teléfono: ");
        tel.setBounds(20,135,125,25);
        tel.setFont(new Font("Andale Mono",1,12));
        tel.setForeground(new Color(0,0,0));
        add(tel);

        telf = new JTextField();
        telf.setBounds(20,160,125,25);
        add(telf);

        sector = new JLabel("Dirección:");
        sector.setBounds(20,190,125,25);
        sector.setFont(new Font("Andale Mono",1,12));
        sector.setForeground(new Color(0,0,0));
        add(sector);

        sec = new JTextField();
        sec.setBounds(20,215,125,25);
        add(sec);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(240,300,100,30);
        aceptar.addActionListener(this);
        add(aceptar);

        volver = new JButton("Atrás");
        volver.setBounds(20,300,100,30);
        volver.addActionListener(this);
        add(volver);

        modelo= new JLabel(model);
        modelo.setBounds(220,40,170,40);
        modelo.setFont(new Font("Andale Mono",3,14));
        modelo.setForeground(new Color(0, 0, 0));
        add(modelo);

        valor = new JLabel("Precio: "+decimales(precio));
        valor.setBounds(220,80,170,25);
        valor.setFont(new Font("Andale Mono",1,12));
        valor.setForeground(new Color(0,0,0));
        add(valor);

        valorIva = new JLabel("Precio IVA: "+ decimales(precio*1.12));
        valorIva.setBounds(220,105,150,25);
        valorIva.setForeground(new Color(0,0,0));
        add(valorIva);

        fecha = new JLabel("Fecha: "+fechaHoy());
        fecha.setBounds(220,130,170,25);
        fecha.setForeground(new Color(0,0,0));
        add(fecha);

        logo = new JLabel(new ImageIcon(getClass().getResource("imagenes/GMGP.png")));
        logo.setBounds(220,160,100,100);
        add(logo);
    }
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource()==aceptar){
            boolean flag = false;
            nombreF = Main.nombreU;
            cedulaF = id.getText();
            teleF= telf.getText();
            direccionF = sec.getText();
            valorF = decimales(precio*1.12);
            fechaF = fechaHoy();
            codigoF = String.valueOf(codigo);
            modeloF = Automoviles.autoD;
            if (cedulaF.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene el campo 'Cédula'");
            } else if (!esCadenaDeNumeros(cedulaF) || cedulaF.length() != 10) {
                JOptionPane.showMessageDialog(null, "El campo 'Cédula' debe contener 10 números");
            } else if (teleF.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene el campo 'Teléfono'");
            } else if (!esCadenaDeNumeros(teleF) || teleF.length() != 10) {
                JOptionPane.showMessageDialog(null, "El campo 'Teléfono' debe contener 10 números");
            } else if (direccionF.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llene el campo 'Dirección'");
            } else {
                flag = true;
                FacturaFinal ventana = new FacturaFinal();
                ventana.setBounds(0,0,385,480);
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                this.setVisible(false);
            }
        }
        else if(evento.getSource()==volver){
            Automoviles ventana = new Automoviles();
            ventana.setBounds(0,0,690,600);
            ventana.setResizable(false);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            this.setVisible(false);
        }
    }
    public String fechaHoy(){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define un formato para mostrar la fecha y hora (opcional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime.toString();
    }
    public String decimales(double precio){
        DecimalFormat df = new DecimalFormat("0.00");

        // Formatea el número con dos decimales.
        String numeroFormateado = df.format(precio);
        return numeroFormateado;
    }
    public static boolean esCadenaDeNumeros(String cadena) {
        return cadena.matches("[0-9]+");
    }
}
