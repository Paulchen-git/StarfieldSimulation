import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel {
 
    private StarfieldSimulation simulation;

    public Panel(StarfieldSimulation simulation) {
        this.simulation = simulation;
        setPanelSize();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        simulation.update();
        simulation.render(g);
    }

    public void setPanelSize() {
        setPreferredSize(new Dimension(StarfieldSimulation.WIDTH, StarfieldSimulation.HEIGHT));
    }
}
