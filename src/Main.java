import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static List<Process> generateProcesses(int amount, int maxArrivalRange, int burstTimeLim)
    {
        List<Process> list = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < amount; i++)
        {
            String id = "P" + (i+1);

            //Procesy beda sie zglaszac na przestrzeni calej symulacji
            int arrivalTime = rand.nextInt(maxArrivalRange);

            //Generujemy mnóstwo krótkich procesów i mniej długich (rozkład rzeczywisty)
            int burstTime = (int)(Math.pow(rand.nextDouble(), 3) * burstTimeLim) + 1;

            list.add(new Process(id, arrivalTime, burstTime));
        }

        return list;
    }

    public static void printProcessList(List<Process> list) {
        System.out.println("--- WYGENEROWANE PROCESY ---");
        for (Process p : list) {
            System.out.println(p);
        }
        System.out.println("----------------------------");
    }


    public static void main(String[] args)
    {
        int[] Sizes = {50,100,500,1000};
        int numTests = 100;
        int quantNum = 10;

        int burstTimeLim = 30;


        for(int n : Sizes)
        {

            double totalFcfs = 0;
            double totalSjf = 0;
            double totalSrtf = 0;
            double totalRr = 0;

            int maxArrivalRange = n;

            for(int i = 0; i < numTests; i++)
            {
                List<Process> testData = generateProcesses(n, maxArrivalRange, burstTimeLim);

                Scheduler fcfs = new FCFS(testData);
                fcfs.runSim();
                totalFcfs += fcfs.getAverageWaitingTime();

                Scheduler sjf = new SJF(testData);
                sjf.runSim();
                totalSjf += sjf.getAverageWaitingTime();

                Scheduler srtf = new SRTF(testData);
                srtf.runSim();
                totalSrtf += srtf.getAverageWaitingTime();

                Scheduler rr = new RR(testData, quantNum);
                rr.runSim();
                totalRr += rr.getAverageWaitingTime();
            }

            System.out.println("=== ŚREDNIE WYNIKI DLA N = " + n + " PROCESÓW (na podstawie " + numTests + " testów) ===");
            System.out.printf("FCFS: %.2f\n", (totalFcfs / numTests));
            System.out.printf("SJF:  %.2f\n", (totalSjf / numTests));
            System.out.printf("SRTF: %.2f\n", (totalSrtf / numTests));
            System.out.printf("RR (dla " + quantNum + " kwantów):   %.2f\n", (totalRr / numTests));
            System.out.println("---------------------------------------------------------");

        }

    }
}
