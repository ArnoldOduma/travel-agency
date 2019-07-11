package models;
import org.sql2o.Connection;
import java.util.Objects;
import java.util.List;

public class SignUp {
    private String name;
    private String email;
    private String password;
    private int id;

    public  SignUp(String name, String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUp signUp = (SignUp) o;
        return id == signUp.id &&
                Objects.equals(name, signUp.name) &&
                Objects.equals(email, signUp.email) &&
                Objects.equals(password, signUp.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, id);
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO signup (name, email, password) VALUES (:name, :email, :password);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("email", this.email)
                    .addParameter("password", this.password)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<SignUp> all(){
        String sql = "SELECT * FROM signup;";
        try(org.sql2o.Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(SignUp.class);
        }
    }
    }

