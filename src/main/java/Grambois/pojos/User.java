package Grambois.pojos;

public class User {
    private String mail;
    private String pwd;

    public User(){

    }

    public User(String mail, String pwd) {
        this.mail = mail;
        this.pwd = pwd;
    }

    public User(UserDto userDto){
        this.mail = userDto.getMail();
        this.pwd = userDto.getPwd();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
