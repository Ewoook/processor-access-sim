import java.util.List;

public class RR extends Scheduler{

    private int quantum;
    private int timeInSlice;

    public RR(List<Process> initialProcesses, int quantum)
    {
        super(initialProcesses);
        this.quantum = quantum;
        this.timeInSlice = 0;
    }

    @Override
    public void selectNextProcess()
    {
        if(currentProcess != null)
        {
            timeInSlice++;
            if (timeInSlice == quantum)
            {
                readyQueue.addLast(currentProcess);
                timeInSlice = 0;
                currentProcess = null;
            }
        }
        if(currentProcess == null && !readyQueue.isEmpty())
        {
            currentProcess = readyQueue.removeFirst();
            timeInSlice = 0;
        }

    }

}
