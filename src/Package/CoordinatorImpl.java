package Package;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorImpl implements Coordinator{
    List<User> users = new ArrayList<>();
    @Override
    public void register (User u) throws RemoteException
    {
        users.add(u);
    }

    @Override
    public List<User> search(String fileName) throws RemoteException {
        List<User> list = new ArrayList<>();
        for(int i=0 ;i<users.size();i++){
            boolean c = users.get(i).search(fileName);
            if(c){
                list.add(users.get(i));

            }

        }
        return list;
    }


}
