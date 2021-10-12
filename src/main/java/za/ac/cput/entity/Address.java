package za.ac.cput.entity;
/**
 * Address Class
 * @author Shyam Prag
 * 218115873
 * 11/06/2021
 */

    public class Address {
        private final String street;
        private final String houseNumber;
        private final String zipCode;
        private final String city;

    //getters
    public static class Builder {
        private String street;
        private String houseNumber;
        private String zipCode;
        private String city;

        public Builder() {

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
    }

    private Address(Builder builder){
        this.street=builder.street;
        this.houseNumber=builder.houseNumber;
        this.zipCode=builder.zipCode;
        this.city=builder.city;
    }
        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", houseNumber='" + houseNumber + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }
