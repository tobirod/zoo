package zoo;

public class BirdCage extends Accessories {
    private int bcPrice;
    private String accType = "Bird Cage";
    
    public BirdCage(String accType, int bcPrice) {
        super();
        this.bcPrice = bcPrice;
    }
    public BirdCage()
    {
    }
    public int getBcPrice() {
        return bcPrice;
    }
    public void setBcPrice(int bcPrice) {
        this.bcPrice = bcPrice;
    }
    public String getAccType()
    {
        return this.accType;
    }
}
