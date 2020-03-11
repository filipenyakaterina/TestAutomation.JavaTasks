package classes.entity;

public class Customer extends Person {
    private long creditCardNum;
    private String bankAccountNum;

    public Customer(long Id, String name, String patronymic, String surname, Address address, long creditCardNum, String bankAccountNum) {
        super(Id, name, patronymic, surname, address);
        this.creditCardNum = creditCardNum;
        this.bankAccountNum = bankAccountNum;
    }

    public long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(String bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", CreditCardNum='" + creditCardNum + '\'' +
                ", BankAccountNum='" + bankAccountNum + '\'' +
                "}\n";
    }
}
