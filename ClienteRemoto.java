
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ClienteRemoto extends JFrame implements ChatInterface {

    private static final long serialVersionUID = 1L;

    String username = "Edgar";
    String ip;
    JLabel lblUsername;
    JTextArea txtContent;
    JTextField txtMsg;

    public static void main(String[] args) {
        new ClienteRemoto();
    }

    public ClienteRemoto() {

        this.setLayout(null);
        this.setBounds(10, 10, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.lblUsername = new JLabel(username);
        lblUsername.setBounds(30, 400, 200, 50);

        this.setVisible(true);
    }

    @Override
    public void enviarMensajes() throws RemoteException {

    }

    @Override
    public void recivirMensaje() throws RemoteException {

    }

}
