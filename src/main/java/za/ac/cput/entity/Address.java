package za.ac.cput.entity;

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

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder city(String city) {
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



}
