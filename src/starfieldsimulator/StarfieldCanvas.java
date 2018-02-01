package starfieldsimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarfieldCanvas extends JPanel {
    private int width;
    private int height;
    private Timer timer;
    private final int DELAY = 5;
    private final int STAR_TRACE_COUNT = 50;
    private List<StarTrace> starTraceList = new ArrayList<>();
    
    public StarfieldCanvas(int width, int height) {
        setBounds(0, 0, width, height);
        setBackground(Color.BLACK);
        this.width = width;
        this.height = height;
        for (int i = 0; i < STAR_TRACE_COUNT; i++) {
            this.starTraceList.add(new StarTrace(
                    (int)(Math.random()*width)+(-width/2),
                    (int)(Math.random()*height)+(-height/2),
                    this
            ));
        }
        this.timer = new Timer(DELAY, e -> {
            update();
            repaint();
        });
        this.timer.start();
    }

    private void update() {
        for (StarTrace starTrace : starTraceList) {
            starTrace.update();
        }
    }
    
    @Override
    protected void paintComponent(Graphics oldG) {
//        super.paintComponent(oldG);
        Graphics2D g = (Graphics2D) oldG;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(0, 0, 0, 20));
        g.fillRect(0, 0, width, height);
        g.translate(width/2, height/2);
        
        for (StarTrace starTrace : starTraceList) {
            starTrace.draw(g);
        }
    }   
}
