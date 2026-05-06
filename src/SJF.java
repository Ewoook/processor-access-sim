import java.util.Comparator;
import java.util.List;

public class SJF extends Scheduler{

    public SJF(List<Process> initialProcesses)
    {
        super(initialProcesses);
    }

    @Override
    public void selectNextProcess()
    {
       if(currentProcess != null)
       {
           return;
       }
       else if(!readyQueue.isEmpty())
       {
           readyQueue.sort(Comparator.comparingInt(Process::getBurstTime));
           currentProcess = readyQueue.removeFirst();

       }
    }
}
