package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Coordinator extends Remote {
    public void register (User u) throws RemoteException;
    public List<User> search(String FileName) throws RemoteException ;
}
