package starfieldsimulator;

import javax.swing.SwingUtilities;

public class StarfieldSimulator {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StarfieldCanvas canvas = new StarfieldCanvas(WIDTH, HEIGHT);
            CreativeFrame frame = new CreativeFrame(canvas);
            frame.setVisible(true);
        });
    }
    
}
