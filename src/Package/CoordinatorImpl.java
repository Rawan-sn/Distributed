package Package;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorImpl implements Coordinator{
    List users = new ArrayList();
    public void register (User u) throws RemoteException
    {
        users.add(u);
    }
    public void sendMsg(String s) throws RemoteException
    {
        for(int i=0; i<users.size(); i++){
            User u = (User) users.get(i);
            u.print(s);
        }
    }

}
