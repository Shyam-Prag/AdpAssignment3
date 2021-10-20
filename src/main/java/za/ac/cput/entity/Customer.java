package za.ac.cput.entity;

/* Customer.java
 Entity for the Customer
 Author: Cameron Noemdo 219115443
 Date: 10/06/21
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer
{
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Customer()
    {

    }

    private Customer (Builder build)
    {
        this.id=build.id;
        this.firstName=build.firstName;
        this.lastName= build.lastName;
    }

    public String getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }


    public static class Builder
    {
        private String id,firstName, lastName;

        public Builder setID(String id)
        {
            this.id=id;
            return this;
        }

        public Builder setFirstName(String firstName)
        {
            this.firstName=firstName;
            return this;
        }

        public Builder setLastName (String lastName)
        {
            this.lastName=lastName;
            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }

        public Builder copy(Customer customer)
        {
            this.id= customer.id;
            this.firstName= customer.firstName;
            this.lastName= customer.lastName;
            return this;
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
