package zoo;

public class Aquarium extends Accessories {
    private int aqPrice;
    private String accType = "Aquarium";
    
    public Aquarium(String accType, int aqPrice) {
        super();
        this.aqPrice = aqPrice;
    }
    public Aquarium()
    {
    }
    public int getAqPrice() {
        return aqPrice;
    }
    public void setAqPrice(int aqPrice) {
        this.aqPrice = aqPrice;
    }
    public String getAccType()
    {
        return this.accType;
    }
}
