package Package;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorImpl implements Coordinator{
    List<User> users = new ArrayList<User>();
    public void register (User u) throws RemoteException
    {
        users.add(u);
    }

    @Override
    public User search(String fileName) throws RemoteException {
        for(int i=0 ;i<users.size();i++){
            boolean c = users.get(i).search(fileName);
            if(c==true){
           return users.get(i);}

        }
        return null;
    }


}
