package Package;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl  implements User{
    List<String> files = new ArrayList<String>();




    public void print() throws RemoteException
    {
        System.out.println("fffffffffff");
        files.add("first");
        for(int i=0 ;i<files.size();i++){
            System.out.print(files.get(i).toString());
        }
    }


    @Override
    public boolean search(String fileName) throws RemoteException {
        print();
        for(int i=0 ;i<files.size();i++){

            if(files.contains(fileName)){
               return true;

            }
        }
        return false;
    }

    @Override
    public void download() throws RemoteException {

    }
}
