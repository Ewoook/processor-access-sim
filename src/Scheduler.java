import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Scheduler {

    protected List<Process> newProcesses;
    protected LinkedList<Process> readyQueue;
    protected List<Process> completedProcesses;

    protected Process currentProcess;
    protected int currentTime;

    public Scheduler(List<Process> initialProcesses)
    {
        this.newProcesses = new ArrayList<>();
        for(Process p : initialProcesses)
        {
            this.newProcesses.add(new Process(p));
        }

        this.readyQueue = new LinkedList<>();
        this.completedProcesses = new ArrayList<>();
        this.currentTime = 0;
        this.currentProcess = null;
    }

    protected abstract void selectNextProcess();

    public void runSim()
    {
        while(!newProcesses.isEmpty() || !readyQueue.isEmpty() || currentProcess != null)
        {
            Iterator<Process> iterator = newProcesses.iterator();
            while(iterator.hasNext())
            {
                Process p = iterator.next();
                if (p.getArrivalTime() == currentTime) {
                    readyQueue.add(p);
                    iterator.remove();
                }
            }
            selectNextProcess();

            if(currentProcess != null)
            {
                int temp = currentProcess.getRemainingTime();
                temp--;
                if(temp == 0)
                {
                    completedProcesses.add(currentProcess);
                    currentProcess = null;
                }
                else
                {
                    currentProcess.setRemainingTime(temp);
                }
            }

            for(Process p2 : readyQueue)
            {
                int temp = p2.getWaitingTime();
                temp++;
                p2.setWaitingTime(temp);
            }

            currentTime++;

        }
    }

    public double getAverageWaitingTime()
    {
        double timeSum = 0;

        for(Process p : completedProcesses)
        {
            timeSum+=p.getWaitingTime();
        }
        return timeSum/completedProcesses.size();
    }
}
