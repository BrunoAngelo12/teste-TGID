package application.entities;

public class Client {
    private long longCPF;
    private int strPassword;
    private double balance = 0.0;
    private int iD;

    public Client (long longCPF, int strPassword, int iD){
        this.longCPF = longCPF;
        this.strPassword = strPassword;
        this.iD = iD;
    }

    public String toString(){
        return "CPF: " + longCPF + "\nID: " + iD;
    }

    public int getiD(){
        return iD;
    }

    public int getStrPassword(){
        return strPassword;
    }
}
