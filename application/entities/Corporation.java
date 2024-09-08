package application.entities;

public class Corporation {
    private long longCNPJ;
    private int strPassword;
    private int intSystemFee;
    private double balance = 50.0;
    private int iD;

    public Corporation (long longCNPJ, int strPassword, int intSystemFee, int iD){
        this.longCNPJ = longCNPJ;
        this.strPassword = strPassword;
        this.intSystemFee = intSystemFee;
        this.iD = iD;
    }

    public String toString(){
        return "CNPJ: " + longCNPJ + "\nID: " + iD;
    }

    public int getiD(){
        return iD;
    }

    public void withdrawMoney(double doubWithdrawalAmount){
        if(this.balance < doubWithdrawalAmount){
            System.out.println("Unavailable balance!");
        }else{
            this.balance -= doubWithdrawalAmount;
            this.balance = this.balance - ((double)this.intSystemFee / 100 * this.balance);
            System.out.printf("New balance available: R$ %.2f", this.balance);
        }
    }

    public void depositMoney(double doubDepositAmount){     
            this.balance = this.balance - ((double)this.intSystemFee / 100 * doubDepositAmount);
            this.balance += doubDepositAmount;
            System.out.printf("New balance available: R$ %.2f", this.balance);
    }
}
