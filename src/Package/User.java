package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    public boolean search(String fileName) throws RemoteException;
    public void download() throws RemoteException;
}
