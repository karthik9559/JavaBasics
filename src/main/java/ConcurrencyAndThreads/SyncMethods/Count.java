package ConcurrencyAndThreads.SyncMethods;

public class Count {
    private int val = 0;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public synchronized void increament(int offset){
        val+=offset;
    }

}
