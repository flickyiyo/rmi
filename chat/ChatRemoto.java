import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatRemoto extends Remote {
    public void conectarUsuario(String username, String ip) throws RemoteException;

    public ArrayList<Mensaje> getMensajes() throws RemoteException;

    public void addMensaje(Mensaje mensaje) throws RemoteException;
}