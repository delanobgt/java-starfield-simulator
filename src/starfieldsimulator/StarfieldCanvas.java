package starfieldsimulator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarfieldCanvas extends JPanel {
    private int width;
    private int height;
    private Timer timer;
    private final int DELAY = 10;
    private StarTrace starTrace;
    
    public StarfieldCanvas(int width, int height) {
        setBounds(0, 0, width, height);
        this.width = width;
        this.height = height;
        this.starTrace = new StarTrace(
                (int)(Math.random()*width)+(-width/2),
                (int)(Math.random()*height)+(-height/2)
        );
        
        this.timer = new Timer(DELAY, e -> {
            update();
            repaint();
        });
        this.timer.start();
    }

    private void update() {
        starTrace.update();
    }
    
    @Override
    protected void paintComponent(Graphics oldG) {
        super.paintComponent(oldG);
        Graphics2D g = (Graphics2D) oldG;
        g.translate(width/2, height/2);
        
        starTrace.draw(g);
    }   
}
