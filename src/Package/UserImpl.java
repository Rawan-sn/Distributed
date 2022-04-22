package Package;

import java.rmi.RemoteException;

public class UserImpl  implements User{
    public void print(String s) throws RemoteException
    {
        System.out.println(s);
    }
}
