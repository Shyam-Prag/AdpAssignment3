package za.ac.cput.entity;

import javax.persistence.*;

/**
 * Address Class
 * @author Shyam Prag
 * 218115873
 * 11/06/2021
 */
    @Entity
    @Table(name = "Address")
    public class Address {
        @Id
        private  String uuid;
        private  String street;
        private  String houseNumber;
        private  String zipCode;
        private  String city;

        public Address(){

        }

        private Address(Builder builder){
        this.uuid = builder.uuid;
        this.street=builder.street;
        this.houseNumber=builder.houseNumber;
        this.zipCode=builder.zipCode;
        this.city=builder.city;
    }
        public String getUuid() {
            return uuid;
        }
        public String getStreet(){
            return street;
        }
        public String getHouseNumber(){
            return houseNumber;
        }
        public String getZipCode(){
            return zipCode;
        }
        public String getCity(){
            return city;
        }

        public static class Builder {
        private String uuid;
        private String street;
        private String houseNumber;
        private String zipCode;
        private String city;

        public Builder() {
        }

       public Builder setUuid(String uuid){
            this.uuid =uuid;
            return this;
       }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;

        }
        public Address build(){
            return new Address(this);
        }
        public Builder copy(Address address){
            this.uuid = address.uuid;
            this.street = address.street;
            this.houseNumber = address.houseNumber;
            this.zipCode = address.zipCode;
            this.city = address.city;
            return this;
        }
    }
    @Override
    public String toString() {
        return "Address{" +
                "unique ID = " + uuid + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
