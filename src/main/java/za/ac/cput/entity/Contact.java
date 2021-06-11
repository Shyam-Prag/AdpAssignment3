package za.ac.cput.entity;
/**
 * Contact.java
 * Entity Contact
 * @author Sayed Abdurra'uf Peters 218149859
 */
public class Contact {

    private String phone,email,mobile,name;

    private Contact(Builder builder){
        this.name = builder.name;
        this.mobile = builder.mobile;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class Builder{

    private String phone,email,mobile,name;

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder name(String email) {
            this.name = email;
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
                ", phone='" + phone + '\'' +
                '}';
    }
}
