import javax.swing.*;
import java.awt.*;

/*panel object of philosopher*/
public class PhilosopherPanel extends JPanel{
    private final JLabel stateLabel = new JLabel();
    private ImageIcon eatingIcon = new ImageIcon("src/eating.png");
    private ImageIcon thinkingIcon = new ImageIcon("src/thinking.png");
    private ImageIcon hungryIcon = new ImageIcon("src/hungry.png");

    private String eatingS = "Eating";
    private String hungryS ="Hungry";
    private String thinkingS ="Thinking";

    /*Philosopher Panel constructor*/
    public PhilosopherPanel(){
        thinking();
        stateLabel.setVerticalTextPosition(JLabel.NORTH);
        stateLabel.setHorizontalTextPosition(JLabel.CENTER);
        setBackground(Color.WHITE);
        add(stateLabel);
    }

    /*changing the panel to eating state*/
    public void eating(){
        stateLabel.setIcon(eatingIcon);
        stateLabel.setText(eatingS);
    }

    /*changing the panel to thinking state*/
    public void thinking(){
        stateLabel.setIcon(thinkingIcon);
        stateLabel.setText(thinkingS);
    }

    /*changing the hungry to eating state*/
    public void hungry(){
        stateLabel.setIcon(hungryIcon);
        stateLabel.setText(hungryS);
    }
}
