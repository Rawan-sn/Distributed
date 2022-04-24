package demand2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface User extends Remote {

    public boolean search(String fileName) throws RemoteException;
    public void download(String file_name, User u) throws  RemoteException;  // todo

    // todo
    public void addFiles(String fileName) throws  RemoteException;;
    public void setNameUser(String Name) throws  RemoteException;;
    public String getNameUser() throws  RemoteException;;
    public void receive(byte[] byteArray, String nameUser, String file_name) throws  RemoteException;;
}
