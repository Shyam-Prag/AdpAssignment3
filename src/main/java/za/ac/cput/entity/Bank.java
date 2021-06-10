package za.ac.cput.entity;

/**
 * Bank Class
 * @author Emeka Thato Nwamadi
 * 219404070
 * 10/06/2021
 */

public class Bank {
    private String name;

    //getters
    public static class bankBuilder {
        private String name;

        public bankBuilder() {

        }

        public bankBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Bank build(){
            return new Bank(this);
        }
    }
    private Bank(bankBuilder builder){
        this.name=builder.name;

    }

    public Bank(String name) {
        this.name = name;
    }

    //        create bank account function
    public void create() {
        this.name="First National Bank";

    }







}



