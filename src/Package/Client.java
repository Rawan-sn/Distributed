package Package;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {
        Coordinator c = (Coordinator)
                Naming.lookup("rmi://localhost/chatting");
        User u = new UserImpl();
        UnicastRemoteObject.exportObject(u);
        c.register(u);
    }
}
