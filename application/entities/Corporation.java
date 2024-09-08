package application.entities;

public class Corporation {
    private long longCNPJ;
    private String strPassword;
    private int intSystemFee;

    public Corporation (long longCNPJ, String strPassword, int intSystemFee){
        this.longCNPJ = longCNPJ;
        this.strPassword = strPassword;
        this.intSystemFee = intSystemFee;
    }
}
