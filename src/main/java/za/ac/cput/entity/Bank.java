package za.ac.cput.entity;

import za.ac.cput.factory.BankFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

/**
 * Bank Class
 * @author Emeka Thato Nwamadi
 * 219404070
 * 10/06/2021
 */

@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue
    private  String uuid;
    private  String bankName;
    private  String bankBranch;
    private  String zipCode;
    private  String city;

    public Bank(){

    }

    private Bank(Builder builder){
        this.uuid = builder.uuid;
        this.bankName=builder.bankName;
        this.bankBranch=builder.bankBranch;
        this.zipCode=builder.zipCode;
        this.city=builder.city;
    }
    public String getUuid() {
        return uuid;
    }
    public String getBankName(){
        return bankName;
    }
    public String getBankBranch(){
        return bankBranch;
    }
    public String getZipCode(){
        return zipCode;
    }
    public String getCity(){
        return city;
    }

    public static class Builder {
        private String uuid;
        private String bankName;
        private String bankBranch;
        private String zipCode;
        private String city;

        public Builder() {
        }

        public Builder setUuid(String uuid){
            this.uuid =uuid;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setBankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
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
        public Bank build(){
            return new Bank(this);
        }
        public Builder copy(Bank bank){
            this.uuid = bank.uuid;
            this.bankName = bank.bankName;
            this.bankBranch = bank.bankBranch;
            this.zipCode = bank.zipCode;
            this.city = bank.city;
            return this;
        }
    }
    @Override
    public String toString() {
        return "Bank{" +
                "unique ID = " + uuid + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
