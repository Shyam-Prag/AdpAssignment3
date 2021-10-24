package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Contact.java
 * Entity Contact
 * @author Sayed Abdurra'uf Peters 218149859
 */

@Entity
@Table(name = "Contact")
public class Contact implements Serializable {
    @Id
    private String id;
    private String email,mobile,name;


    public Contact(){

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    private Contact(Builder builder){
        this.name = builder.name;
        this.mobile = builder.mobile;
        this.id = builder.id;
        this.email = builder.email;
    }

    public static class Builder{

    private String id,email,mobile,name;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder copy(Contact contact){
            this.id = contact.id;
            this.name = contact.name;
            this.mobile = contact.mobile;
            this.email = contact.email;
            return this;
        }
        public Contact build(){
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + id + '\'' +
                '}';
    }
}
