import javax.swing.*;
import java.awt.*;

public class ChopstickPanel extends JPanel
{
    private final JLabel stateLabel = new JLabel();
    private ImageIcon freeIcon = new ImageIcon("src/free.png");
    private ImageIcon takenIcon = new ImageIcon("src/taken.png");
    private String freeS = "Free";
    private String takenS ="Taken";

    public ChopstickPanel()
    {
        free();
        stateLabel.setVerticalTextPosition(JLabel.NORTH);
        stateLabel.setHorizontalTextPosition(JLabel.CENTER);
        setSize(50, 50);
        setBackground(Color.WHITE);
        add(stateLabel);
    }

    public void free()
    {
        stateLabel.setIcon(freeIcon);
        stateLabel.setText(freeS);
    }

    public void taken()
    {
        stateLabel.setIcon(takenIcon);
        stateLabel.setText(takenS);
    }
}
