package demand2;


import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

//    public void print() throws RemoteException {
//        System.out.println("fffffffffff");
//        files.add("first");
//        for (int i = 0; i < files.size(); i++) {
//            System.out.print(files.get(i));
//        }
//    }



    // todo
    @Override
    public void download(String file_name, User u) throws RemoteException {
        System.out.println("llllllllllllllll");



            int i = 0;
            File file = new File("C:\\Users\\ranee\\IdeaProjects\\NewDistributed\\" + userName +"\\" + file_name + ".txt");
            FileInputStream fis = null;
            try {
                System.out.println(file+"fileeeeeeeee");

                System.out.println("fjjjjjjjjjj");
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                Logger.getLogger(e.getMessage());
            }
            int r = 0;
            try {
                System.out.println("fjjjjjjjjj11111j");
                byte[] byteArray = new byte[fis.available()];
                while ((r = fis.read()) != -1) {
                    System.out.println("fjjjjjjjjj11111j");
                    byteArray[i] = (byte) r;
                    i++;
                }
                u.receive(byteArray, u.getNameUser(), file_name);
            } catch (IOException ex) {

            }

    }


    @Override
    public void setNameUser(String Name) {
        this.userName = Name;
    }

    @Override
    public String getNameUser() {
        return this.userName;
    }

    @Override
    public void receive(byte[] byteArray, String nameUser, String file_name) {
        System.out.println("receiveeeeeeeeeeeeee");
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\ranee\\IdeaProjects\\NewDistributed\\" + nameUser + "\\" + file_name + ".txt");
            try {
                for (int j = 0; j < byteArray.length; j++) {
                    myWriter.write((char) byteArray[j]);
                }
                files.add(file_name);
            } catch (IOException ex) {
                Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            myWriter.close();
            System.out.println("This file is received");

        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }


}
