package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Coordinator extends Remote {
    public void register (User u) throws RemoteException;
    public void sendMsg(String s) throws RemoteException ;
}
