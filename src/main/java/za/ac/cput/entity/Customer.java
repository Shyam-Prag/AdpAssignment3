package za.ac.cput.entity;

public class Customer
{
    private String firstName, lastName;

    private Customer (Builder build)
    {
        this.firstName=build.firstName;
        this.lastName= build.lastName;
    }

    public static class Builder
    {
        private String firstName, lastName;

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
    }
}
