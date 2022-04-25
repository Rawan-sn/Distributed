package demand2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Coordinator extends Remote {
    public String register (MainUser u) throws RemoteException;
    public List<User> search(String FileName) throws RemoteException ;
}
