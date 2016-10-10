package zoo;

public class Terrarium extends Accessories {
    private int terrPrice;
    private String accType = "Terrarium";
    
    public Terrarium(String accType, int terrPrice) {
        super();
        this.terrPrice = terrPrice;
    }
    public Terrarium()
    {
    }
    public int getTerrPrice() {
        return terrPrice;
    }
    public void setTerrPrice(int terrPrice) {
        this.terrPrice = terrPrice;
    }
    public String getAccType()
    {
        return this.accType;
    }
}
