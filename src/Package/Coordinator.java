package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Coordinator extends Remote {
    public void register (User u) throws RemoteException;
    public User search(String FileName) throws RemoteException ;
}
