package Package;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Server{
    public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Coordinator c = new CoordinatorImpl();
        UnicastRemoteObject.exportObject(c);
        Naming.bind("chatting", c);
    }
}
