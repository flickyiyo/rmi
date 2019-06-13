import java.rmi.*;
import java.rmi.activation.*;
import java.util.ArrayList;
import java.util.Properties;
import java.net.InetAddress;

public class Server extends Activatable implements ChatRemoto {

    private static final long serialVersionUID = 1L;

    private ArrayList<Mensaje> mensajes = new ArrayList<>();
    private ArrayList<String> ips = new ArrayList<>();

    public Server(ActivationID a, MarshalledObject m) throws RemoteException {
        super(a, 0);
    }
    
    @Override
    public void conectarUsuario(String username, String ip) throws RemoteException {
        this.ips.add(ip);
    }

    @Override
    public ArrayList<Mensaje> getMensajes() throws RemoteException {
        return this.mensajes;
    }
    

    @Override
    public void addMensaje(Mensaje mensaje) throws RemoteException {
        this.mensajes.add(mensaje);
    }



    public static void main(String[] args) {
        try {
            Properties p = new Properties();
            p.put("java.security.policy", "policy");
            ActivationGroupDesc.CommandEnvironment ace = null;
            ActivationGroupDesc ejemplo = new ActivationGroupDesc(p, ace);
            ActivationGroupID agi = ActivationGroup.getSystem().registerGroup(ejemplo);
            MarshalledObject m = null;
            ActivationDesc desc = new ActivationDesc(agi, "MiClaseRemota2", "file://C:/tmp", m);
            ChatRemoto mir = (ChatRemoto) Activatable.register(desc);
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            Naming.rebind("//" + InetAddress.getLocalHost().getHostAddress() + ":" + 1223 + "/PruebaRMI", mir);

        } catch (Exception ex) {
            System.out.println(" java -Djava.security.policy=policy MiClaseRemota2 1223");
            ex.printStackTrace();
        }
    }

}