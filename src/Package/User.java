package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {
    public void print(String s) throws RemoteException;
}
