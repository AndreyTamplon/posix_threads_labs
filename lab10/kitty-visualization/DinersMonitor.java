/*monitor of the philosophers threads*/
public class DinersMonitor {
    public static final int THINKING = 0;
    public static final int EATING = 1;
    public static final int HUNGRY = 2;

    private AppFrame appFrame;

    private int numOfDiners;
    private int dinersState[];

    /*constructor of the monitor*/
    public DinersMonitor(int numOfDiners, AppFrame appFrame){
        this.appFrame = appFrame;
        this.numOfDiners = numOfDiners;
        dinersState = new int[numOfDiners];
    }

    /*Synchronizing the philosophers for how can take the Chopsticks*/
    public synchronized void takeChopsticks(int id){
        dinersState[id] = HUNGRY;
        appFrame.updatePhilosopher(id, HUNGRY);
        while (dinersState[id] == HUNGRY){
            if(dinersState[(id+numOfDiners-1)%numOfDiners] == EATING ||
                    dinersState[(id+numOfDiners+1)%numOfDiners] == EATING){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
                break;
        }
        dinersState[id] = EATING;
        appFrame.updatePhilosopher(id, EATING);
    }

    /*pu the Chopsticks that the philosopher take*/
    public synchronized void putChopsticks(int id){
        dinersState[id] = THINKING;
        appFrame.updatePhilosopher(id, THINKING);
        notifyAll();
    }
}
