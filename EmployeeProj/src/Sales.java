public class Sales extends Permanent implements IBusinessTrip{

    int incentive;

    public Sales(String id, String name, int pay, int incentive) {
        super(id, name, pay);
        this.incentive = incentive;
    }

    @Override
    public int getPay() {
        return super.getPay() + getIncentive();
    }


    public int getIncentive() {
        return incentive;
    }

    public void setIncentive(int incentive) {
        this.incentive = incentive;
    }

    @Override
    public void goBusinessTrip(int day) {
        setIncentive(incentive+100000*day);
    }
}
