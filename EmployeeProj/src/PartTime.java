public class PartTime extends Employee implements IBusinessTrip {

    int time;
    int payPerTime;

    public PartTime(String id, String name, int time, int payPerTime) {
        super(id,name);
        this.time = time;
        this.payPerTime = payPerTime;
    }


    @Override
    public void goBusinessTrip(int day) {
        setTime(time+day*24);
    }

    public int getPay() {
        return time * payPerTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPayPerTime() {
        return payPerTime;
    }

    public void setPayPerTime(int payPerTime) {
        this.payPerTime = payPerTime;
    }

    @Override
    public String toString() {
        return super.toString() + ", 급여: " + getPay();
    }
}
