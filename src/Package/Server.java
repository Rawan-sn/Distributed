package Package;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends CoordinatorImpl{

    public Server() throws RemoteException {}

    public static void main(String args[]) {
        try {
            CoordinatorImpl obj = new CoordinatorImpl();
            Coordinator stub = (Coordinator) UnicastRemoteObject.exportObject(obj, 0);
            LocateRegistry.createRegistry(1901);
            Registry registry = LocateRegistry.getRegistry("localhost",1901);
            registry.bind("Reverser", stub);
            System.err.println("Server ready");
        }

        catch (RemoteException e) {
            System.err.println("Server Remote exception: " + e.toString());
            e.printStackTrace();
        }
        catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
