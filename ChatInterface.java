import java.rmi.Remote;
import java.rmi.RemoteException;

interface ChatInterface extends Remote {
    public void recivirMensaje() throws RemoteException;

    public void enviarMensajes() throws RemoteException;
}