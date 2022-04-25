package demand2;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorImpl implements Coordinator {
    List<User> users = new ArrayList<>();
    List<String> files = new ArrayList<>();
    List<MainUser> mainUsers = new ArrayList<>();
//
    @Override
    public String register (MainUser u) throws RemoteException
    {
        System.out.println("ddddddddddddddddd");
        mainUsers.add(u);
        return "aa";
    }




    @Override
    public List<User> search(String fileName) throws RemoteException {
        List<User> list = new ArrayList<>();
        boolean isfound = false;
        for(int i=0 ;i<mainUsers.size();i++){
           for(int j=0 ; j<mainUsers.get(i).files.size() ; j++){
               if(mainUsers.get(i).files.get(j).contains(fileName)){
                   isfound = true;
               }
               else{ isfound= false;}

           if(isfound == true){
               list.add(mainUsers.get(i).user);
           }
        }

    }

return list;}

}



