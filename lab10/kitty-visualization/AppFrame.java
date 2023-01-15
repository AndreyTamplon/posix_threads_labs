import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame
{
    private int numOfPhilo;
    private PhilosopherPanel philosophersPanels[];
    private ChopstickPanel chopsticksPanels[];

    public AppFrame(int numOfPhilo)
    {
        this.numOfPhilo = numOfPhilo;
        philosophersPanels = new PhilosopherPanel[numOfPhilo];
        chopsticksPanels = new ChopstickPanel[numOfPhilo];
        setLayout(new GridLayout(1, numOfPhilo));
        for (int i = 0; i < numOfPhilo; i++)
        {

            philosophersPanels[i] = new PhilosopherPanel();
            chopsticksPanels[i] = new ChopstickPanel();
            add(chopsticksPanels[i]);
            add(philosophersPanels[i]);
        }
        setTitle("Philosophers Problem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400 * numOfPhilo, 400);
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        Philosophers philosophers = new Philosophers(this, "input.txt");
        philosophers.start();

    }

    public void updatePhilosopher(int id, int state)
    {
        if (state == Philosophers.EATING)
        {
            philosophersPanels[id].eating();
        }
        else if (state == Philosophers.THINKING)
        {
            philosophersPanels[id].thinking();

        }
        else
            philosophersPanels[id].hungry();
    }

    public void updateChopstick(int id, int state)
    {
        if (state == Philosophers.TAKEN)
        {
            chopsticksPanels[id].taken();
        }
        else if (state == Philosophers.FREE)
        {
            chopsticksPanels[id].free();
        }
    }
}
