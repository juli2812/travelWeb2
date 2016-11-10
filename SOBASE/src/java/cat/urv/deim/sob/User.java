package cat.urv.deim.sob;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class User {

    private String firstName;
    private String lastName;
    private String lastName2;
    private String email;
    private String phone;
    private String alias;
    private String address;
    private Calendar data_naix;
    private String sexe;
    private String pass;

    public User(String firstName, String lastName, String lastName2, String email, String phone, String alias, String address, Calendar data_naix, String sexe, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.phone = phone;
        this.alias = alias;
        this.address = address;
        this.data_naix = data_naix;
        this.sexe = sexe;
        this.pass = pass;
    }
    
    public User(){
    }

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

    public String getRegconfirmat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getData_naix().getTime();
        String date = sdf.format(data);
        return "<h2>Registre confirmat</h2>"
                + "<b>Nom: " + getFirstName() + "</b><br>"
                + "<b>Cognom:  " + getLastName() + "</b><br>"
                + "<b>Cognom 2:  " + getLastName2() + "</b><br>"
                + "<b>Pass:      " + getPass() + "</b><br>"
                + "<b>E-mail:      " + getEmail() + "</b><br>"
                + "<b>Telèfon:      " + getPhone() + "</b><br>"
                + "<b>Sexe:  " + getSexe() + "</b><br>"
                + "<b>Data naixement:  " + date + "</b><br>";
    }
    public String getInfoAccount() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data =  getData_naix().getTime();
        String date = sdf.format(data);
        String passLong="";
        for(int i=0; i<getPass().length(); i++){
            passLong=passLong+"*";
        }
        return "<h2>Registre confirmat</h2>"
                + "<b>Nom complert:    </b>" + getLastName()+" "+ getLastName2() +", "+ getFirstName() + "<br>"
                + "<b>Nom:             </b>" + getFirstName() + "<br>"
                + "<b>Cognom:          </b>" + getLastName() + "<br>"
                + "<b>Cognom 2:        </b>" + getLastName2() + "<br>"
                + "<b>Sexe:            </b>" + getSexe() + "<br>"
                + "<b>Data naixement:  </b>" + date + "<br>"
                + "<b>Usuari:          </b>" + getAlias() + "<br>"
                + "<b>Pass:            </b>" + passLong + "<br>"
                + "<b>E-mail:          </b>" + getEmail() + "<br>"
                + "<b>Adreça:          </b>" + getAddress() + "<br>"
                + "<b>Telèfon:         </b>" + getPhone() + "<br>";
    }
    
    public String getMessage() {

        return "\nFirst Name: " + getFirstName() + "\n"
                + "Last Name:  " + getLastName() + "\n"
                + "Email:      " + getEmail() + "\n"
                + "Phone:      " + getPhone() + "\n";
    }
}