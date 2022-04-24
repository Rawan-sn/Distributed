package Package;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {

    public boolean search(String fileName) throws RemoteException;
    public void download(String file_name, User u) throws  RemoteException;  // todo

    // todo
    void addFiles(String fileName);
    void setNameUser(String Name);
    String getNameUser();

}
