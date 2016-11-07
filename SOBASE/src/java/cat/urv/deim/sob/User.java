package cat.urv.deim.sob;

import java.util.Date;
public class User {

    private String firstName;
    private String lastName;
    private String lastName2;
    private String email;
    private String phone;
    private String alias;
    private String address;
    private Date data_naix;
    private String sexe;
    private String pass;
   
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getData_naix() {
        return data_naix;
    }

    public void setData_naix(Date data_naix) {
        this.data_naix = data_naix;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   
    

    public String getFirstName() {
        return fixNull(this.firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName2() {
        return fixNull(this.lastName2);
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }
    
    public String getLastName() {
        return fixNull(this.lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return fixNull(this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return fixNull(this.phone);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String fixNull(String in) {
        return (in == null) ? "" : in;
    }
    
    public String getSexe() {
        return fixNull(this.sexe);
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMessage() {

        return "\nFirst Name: " + getFirstName() + "\n"
                + "Last Name:  " + getLastName() + "\n"
                + "Email:      " + getEmail() + "\n"
                + "Phone:      " + getPhone() + "\n";
    }

  /*  @Override
    No se si asi retoranara todo de forma correcta.
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", lastName2=" + lastName2 + ", email=" + email + ", phone=" + phone + ", alias=" + alias + ", address=" + address + ", data_naix=" + data_naix + ", sexe=" + sexe + ", pass=" + pass + '}';
    }
    */
    
}
