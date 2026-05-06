public class Process {

    private String id;
    private int arrivalTime;
    private int burstTime;
    private int remainingTime;
    private int waitingTime;

    public Process(String id, int arrivalTime, int burstTime)
    {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        this.remainingTime = burstTime;
        this.waitingTime = 0;
    }

    // Konstruktor kopiujący
    public Process(Process innyProcess) {
        this.id = innyProcess.id;
        this.arrivalTime = innyProcess.arrivalTime;
        this.burstTime = innyProcess.burstTime;

        this.remainingTime = innyProcess.burstTime;
        this.waitingTime = 0;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        return String.format("%s [Zgłoszenie: %3d | Czas wykonania: %2d]", id, arrivalTime, burstTime);
    }
}


