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
public class Contact  {
    @Id
    @GeneratedValue
    private String id,email,mobile,name;

/*    public String getId() {
        return id;
    }*/

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
/*
        this.id = builder.id;
*/
        this.email = builder.email;
    }

    public static class Builder{

    private String id,email,mobile,name;

/*        public Builder id(String id) {
            this.id = id;
            return this;
        }*/

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
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
