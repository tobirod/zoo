package zoo;

public class RodentCage extends Accessories {
    private int rcPrice;
    private String accType = "Rodent Cage";
    
    public RodentCage(String accType, int rcPrice) {
        super();
        this.rcPrice = rcPrice;
    }
    public RodentCage()
    {
    }
    public int getRcPrice() {
        return rcPrice;
    }
    public void setRcPrice(int rcPrice) {
        this.rcPrice = rcPrice;
    }
    public String getAccType()
    {
        return this.accType;
    }
}
