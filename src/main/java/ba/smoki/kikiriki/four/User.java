package ba.smoki.kikiriki.four;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return userName;
    }

    public boolean login(){
        return "root".equals(userName) && "root".equals(password);
    }
    public User() {

    }

}
