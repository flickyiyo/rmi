import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;
import java.net.InetAddress;

public class MiClaseRemota2 extends Activatable implements MiInterfazRemota {
    public MiClaseRemota2(ActivationID a, MarshalledObject m) throws RemoteException {
        super(a, 0);
    }

    @Override
    public void miMetodo1() throws RemoteException {
        System.out.println(123);
    }

    @Override
    public int miMetodo2() throws RemoteException {
        return 12;
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
            MiInterfazRemota mir = (MiInterfazRemota) Activatable.register(desc);
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            Naming.rebind("//" + InetAddress.getLocalHost().getHostAddress() + ":" + args[0] + "/PruebaRMI", mir);

        } catch (Exception ex) {
            System.out.println(" java -Djava.security.policy=policy MiClaseRemota2 1234");
            ex.printStackTrace();
        }
    }
}