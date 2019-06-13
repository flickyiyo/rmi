import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;

class ServidorRemoto implements ChatInterface {

    public static void main(String[] args) {
        try {
            ChatInterface chat = new ServidorRemoto();
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);
            String port = ":1223";
            Naming.rebind("//" + ip + port + "/chat", chat);
        } catch (Exception ex) {
        }
    }

    public ServidorRemoto() {

    }

    @Override
    public void enviarMensajes() throws RemoteException {

    }

    @Override
    public void recivirMensaje() throws RemoteException {

    }
}