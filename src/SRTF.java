import java.util.Comparator;
import java.util.List;

public class SRTF extends Scheduler{
    public SRTF(List<Process> initialProcesses)
    {
        super(initialProcesses);
    }

    @Override
    public void selectNextProcess()
    {
         if(readyQueue.isEmpty())
         {
             return;
         }

         readyQueue.sort(Comparator.comparingInt(Process::getRemainingTime));

         if(currentProcess == null)
         {
             currentProcess = readyQueue.removeFirst();
         }
         else
         {
             if(currentProcess.getRemainingTime() > readyQueue.getFirst().getRemainingTime())
             {
                 readyQueue.add(currentProcess);
                 currentProcess = readyQueue.removeFirst();
             }
         }
    }
}
