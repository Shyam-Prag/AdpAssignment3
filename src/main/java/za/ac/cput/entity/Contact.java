package za.ac.cput.entity;

public class Contact {

    private String phone,mobile,email;

    private Contact(Builder builder){
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.phone = builder.phone;
    }

    public static class Builder{

    private String phone,mobile,email;

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Contact build(){
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
