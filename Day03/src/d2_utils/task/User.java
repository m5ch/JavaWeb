package d2_utils.task;

/**
 * @ Classname User
 * @ Description TODO
 * @ Date 2022/5/15 14:27
 * @ Created by 落尘
 */
public class User {
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id,String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
