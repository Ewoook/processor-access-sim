import java.util.List;

public class FCFS extends Scheduler{

    public FCFS(List<Process> initialProcesses)
    {
        super(initialProcesses);
    }

    @Override
    protected void selectNextProcess()
    {
        if(currentProcess != null)
        {
            return;
        }

        if(!readyQueue.isEmpty())
        {
            currentProcess = readyQueue.removeFirst();
        }
    }
}
