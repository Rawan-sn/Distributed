package demand2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainUser implements Serializable {
    String userName;
    User user ;
    List<String> files = new ArrayList<>();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }
}
