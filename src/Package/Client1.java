package Package;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Client1 {

    public static void main(String args[]) {
        try {
            String url = "rmi://localhost:1900/Reverser";
            Scanner sc = new Scanner(System.in);
            LocateRegistry.createRegistry(1905);
            Registry registry = LocateRegistry.getRegistry("localhost", 1905);
            Coordinator strf = (Coordinator) Naming.lookup(url);
            User user = new UserImpl();
            user.setNameUser("userOne");
            File directory = new File("C:\\Users\\Mostafa\\Desktop\\Nour\\project\\my-app\\" + user.getNameUser());
             File[] filename = directory.listFiles();
            for (File f : filename) {
                user.addFiles(f.getName().replace(".txt", ""));
                System.out.println(f.getName().replace(".txt", ""));
            }
            User stub = (User) UnicastRemoteObject.exportObject(user, 0);
            registry.bind("Reverser_1", stub);
            strf.register(stub);
             System.out.println("Clien "+user.getNameUser()+ " ready");
            while (true) {
                System.out.println("What file do you want to download please enter name file :");
                String search = sc.next();
                List<User> list_user = strf.search(search);
                if (!list_user.isEmpty()) {
                    for (int i = 0; i < list_user.size(); i++) {
                        System.out.print("the file found in user ----> : ");
                        System.out.print(list_user.get(i).getNameUser() + "\t");
                    }
                    System.out.println("");
                    for (int i = 0; i < list_user.size(); i++) {
                        list_user.get(i).download(search, user);
                    }
                } else {
                    System.out.println("the file is not found ");
                }
                System.out.println("To exit 0");
                int choice = sc.nextInt();
                if (choice == 1) {
                    return;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
