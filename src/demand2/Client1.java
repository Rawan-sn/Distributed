package demand2;

import java.io.File;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client1 {

    public static void main(String args[]) {
        try {
            String url = "rmi://localhost:2020/Reverser";
            Scanner sc = new Scanner(System.in);
            LocateRegistry.createRegistry(2022);
            Registry registry = LocateRegistry.getRegistry("localhost", 2022);
            Coordinator strf = (Coordinator) Naming.lookup(url);
            User user = new UserImpl();
            ////////////////////////////////////
            List<String> files = new ArrayList<>();
            user.setNameUser("user1");
            File directory = new File("C:\\Users\\ranee\\IdeaProjects\\NewDistributed\\" + user.getNameUser());
             File[] filename = directory.listFiles();
            for (File f : filename) {
                files.add(f.getName().replace(".txt", ""));
                System.out.println(f.getName().replace(".txt", ""));
            }
            System.out.println("Client0000000000000000000000000000000");

            User stub = (User) UnicastRemoteObject.exportObject(user, 0);
            MainUser mainUser = new MainUser();
            mainUser.setFiles(files);
            mainUser.setUser(stub);
            registry.bind("Reverser_1", stub);
            strf.register(mainUser);
             System.out.println("Client "+user.getNameUser()+ " ready");
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
                        System.out.println("--------------------------");
                        System.out.println("kkkkkkkkkkkkkkk");
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
