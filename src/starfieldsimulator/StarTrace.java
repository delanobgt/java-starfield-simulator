package starfieldsimulator;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class StarTrace {
    
    private final int width;
    private final int height;
    private final double traceLength = 50;
    private double x, y, r, len;
    private double cosVal;
    private double sinVal;
    
    public StarTrace(int x, int y, JPanel canvas) {
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();
        this.x = x;
        this.y = y;
        this.r = Math.hypot(x, y);
        this.len = 1;
        this.cosVal = x/r;
        this.sinVal = y/r;
    }
    
    public void update() {
        if (!(-width/2 <= x && x <= width/2 && 
                -height/2 <= y && y <= height/2)) {
            r = Math.random()*Math.hypot(height, width)/3;
            x = cosVal * r;
            y = sinVal * r;
            len = 1;
        }
        if (len < traceLength) {
            len++;
        } else {
            r += 2;
            x = cosVal * r;
            y = sinVal * r;
        }
    }
    
    public void draw(Graphics2D g) {
        double eR = r+len;
        double eX = cosVal * eR;
        double eY = sinVal * eR;
        g.setColor(Color.WHITE);
        g.drawLine((int)x, (int)y, (int)eX, (int)eY);
    }
}
