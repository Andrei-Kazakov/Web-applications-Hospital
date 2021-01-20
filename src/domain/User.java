package domain;

public class User extends Entity {
    private String login;
    private String password;
    private Role role;
    //private String name
    //private String adress;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String toString(){
        return "User [login=" + login + ", password=" + password + ", role=" + role + ", getID()=" + getId()  + "]";
    }

    //public String getName() {return name;}

   // public void setName(String name) {this.name = name;}

   // public String getAdress() {return adress;}

   // public void setAdress(String adress) {this.adress = adress;    }

}
