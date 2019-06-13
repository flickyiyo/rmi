import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cliente extends JFrame {
    public static String ip;
    public static void main(String[] args) {
        ip = args[0];
        new Cliente();
    }

    JButton submitBtn;
    JLabel converLbl;
    JTextField mensajetxt;
    JTextField usernametxt;
    String username;
    ChatRemoto chat;
    public Cliente() {
        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);

        submitBtn = new JButton();
        submitBtn.setText("Enviar");
        submitBtn.setBounds(30, 400, 100, 50);
        
        add(submitBtn);

        converLbl = new JLabel();
        converLbl.setBounds(30, 10, 400, 500);
        add(converLbl);

        usernametxt = new JTextField();
        usernametxt.setBounds(150, 400, 100, 50);
        usernametxt.setText("Edgar");
        
        add(usernametxt);
        submitBtn.addActionListener(ev -> {
            System.out.println(mensajetxt.getText());
        });
        usernametxt.addActionListener(ev -> {
            username = usernametxt.getText();
        });
        mensajetxt = new JTextField();
        mensajetxt.setBounds(30, 350, 300, 25);
        add(mensajetxt);
        try {
            chat = (ChatRemoto)java.rmi.Naming.lookup("//" + ip + "PruebaRMI");
        } catch (Exception e) {
            //TODO: handle exception
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void EnviarMensaje() {

    }

    public void getMensajes() {
        ArrayList<Mensaje> mensajes = chat.getMensajes();
        String lbltext = "";
        for (Mensaje mensaje: mensajes) {
            lbltext.concat(mensaje.username+": " +mensaje.mensaje+"\n");
        }
        this.converLbl.setText(lbltext);
    }
}