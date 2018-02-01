package starfieldsimulator;

import java.awt.Graphics2D;

public class StarTrace {
    
    private double x;
    private double y;
    private double r;
    private double cosVal;
    private double sinVal;
    
    public StarTrace(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = Math.hypot(x, y);
    }
    
    public void update() {
        
    }
    
    public void draw(Graphics2D g) {
        g.fillOval((int)x, (int)y, 5, 5);
    }
}
