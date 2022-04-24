package Package;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserImpl implements User {
    String userName;

    List<String> files = new ArrayList<>();

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void print() throws RemoteException {
        System.out.println("fffffffffff");
        files.add("first");
        for (int i = 0; i < files.size(); i++) {
            System.out.print(files.get(i));
        }
    }

    @Override
    public boolean search(String fileName) throws RemoteException {
        print();
        for (String file : files) {
            if (files.contains(fileName)) {
                return true;
            }
        }
        return false;
    }

    // todo
    @Override
    public void download(String file_name, User u) throws RemoteException {
        if (list_name.contains(file_name)) {
            BufferedInputStream inputStream = null;
            FileInputStream fileInputStream = null;
            int i = 0;
            File file = new File("C:\\Users\\asus\\Documents\\ProjectFile" + name);
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                Logger.getLogger(e.getMessage());
            }
            int r = 0;
            try {
                byte[] byteArray = new byte[fis.available()];
                while ((r = fis.read()) != -1) {
                    byteArray[i] = (byte) r;
                    i++;
                }
                u.recive(byteArray, u.get_Name(), name_file);
            } catch (IOException ex) {

            }
        }
    }


}
