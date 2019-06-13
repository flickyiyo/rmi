import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Cliente extends JFrame {
    public static void main(String[] args) {
        
    }

    JButton submit;
    JLabel conver;
    JTextField mensaje;
    JTextField username;

    public Cliente() {
        this.setBounds(100, 100, 500, 500);
        this.setLayout(null);

        submit = new JButton();
        submit.setText("Enviar");
        submit.setBounds(30, 400, 100, 50);
        add(submit);

        conver = new JLabel();
        conver.setBounds(30, 10, 400, 500);
        

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}