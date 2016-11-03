package cat.urv.deim.sob;

import java.util.Calendar;
public class User {

    private String firstName;
    private String lastName;
    private String lastName2;
    private String email;
    private String phone;
    private String alias;

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

    public Calendar getData_naix() {
        return data_naix;
    }

    public void setData_naix(Calendar data_naix) {
        this.data_naix = data_naix;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    private String address;
    private Calendar data_naix;
    private String sexe;
    private String pass;
    

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
}
