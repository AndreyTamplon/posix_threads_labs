import java.io.FileNotFoundException;
import java.util.List;

import static java.lang.Thread.sleep;

public class Philosophers
{
    public static final int THINKING = 0;
    public static final int EATING = 1;
    public static final int HUNGRY = 2;
    public static final int TAKEN = 3;
    public static final int FREE = 4;
    private AppFrame appFrame;
    private List<String> listOfOperations;

    public Philosophers(AppFrame appFrame, String filename)
    {
        this.appFrame = appFrame;
        try {
            listOfOperations = new FileProcessor().readFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start()
    {
        for (String operation : listOfOperations)
        {
            String[] operationParts = operation.split(" ");
            int philosopherId = Integer.parseInt(operationParts[0]);
            String operationType = operationParts[1];
            if (operationType.equals("EATING"))
            {
                appFrame.updatePhilosopher(philosopherId, EATING);
            }
            else if (operationType.equals("THINKING"))
            {
                appFrame.updatePhilosopher(philosopherId, THINKING);
            }
            else if (operationType.equals("HUNGRY"))
            {
                appFrame.updatePhilosopher(philosopherId, HUNGRY);
            }
            else if (operationType.equals("TAKE"))
            {
                int leftChopstickId = Integer.parseInt(operationParts[2]);
                int rightChopstickId = Integer.parseInt(operationParts[3]);
                appFrame.updateChopstick(leftChopstickId, TAKEN);
                appFrame.updateChopstick(rightChopstickId, TAKEN);
            }
            else if (operationType.equals("TAKE_ONE"))
            {
                int chopstickId = Integer.parseInt(operationParts[2]);
                appFrame.updateChopstick(chopstickId, TAKEN);
            }
            else if (operationType.equals("PUT"))
            {
                int leftChopstickId = Integer.parseInt(operationParts[2]);
                int rightChopstickId = Integer.parseInt(operationParts[3]);
                appFrame.updateChopstick(leftChopstickId, FREE);
                appFrame.updateChopstick(rightChopstickId, FREE);
            }
            else if (operationType.equals("PUT_ONE"))
            {
                int chopstickId = Integer.parseInt(operationParts[2]);
                appFrame.updateChopstick(chopstickId, FREE);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
