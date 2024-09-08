package application.entities;

public class Client {
    private long intCPF;
    private String strPassword;

    public Client (long longCPF, String strPassword){
        this.intCPF = longCPF;
        this.strPassword = strPassword;
    }
}
