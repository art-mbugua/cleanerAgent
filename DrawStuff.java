import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

public class DrawStuff extends JComponent implements ActionListener {

        int WIDTH = 1920, HEIGHT = 1080;
        Timer t = new Timer(5, this);
        int x = WIDTH / 2 + 200, velocityX = 2;
        int dirtposX1 = 2000;
        int dirtposX2 = 2000;
        int count = 0;

        boolean f1 = true, f2 = true;
        boolean flag = false;
        
        Image vac = Toolkit.getDefaultToolkit().getImage("C:\\Users\\govin\\eclipse-workspace\\Vacuum\\assets\\vaccum.jpg");
        Image back = Toolkit.getDefaultToolkit().getImage("C:\\Users\\govin\\eclipse-workspace\\Vacuum\\assets\\back.png");
        Image dirt = Toolkit.getDefaultToolkit().getImage("C:\\Users\\govin\\eclipse-workspace\\Vacuum\\assets\\dirt.png");

        public void paint(Graphics g) {
            Graphics2D graph2 = (Graphics2D) g;
            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graph2.drawImage(back, 0, 0, this);
            graph2.drawImage(vac, x, 150, this);
            graph2.drawImage(dirt, dirtposX1, 450, this);
            graph2.drawImage(dirt, dirtposX2, 450, this);
            t.start();
        }
        
        boolean dirtIsInside(int X, int Y) {
            if ((X < (Y + 25) && (X > (Y - 25))))
                return true;
            return false;
        }

        public void actionPerformed(ActionEvent e) {
            if (flag) {
            	//After reaching one end vacuum cleaner should change its direction
                if (x < 100 || x > 1400)
                	velocityX = -velocityX;
                x += velocityX;
                // Move the dust out of frame (alternative to making dirt invisible)
                if (dirtIsInside(x, dirtposX1)) {
                    dirtposX1 = 2000;
                }
                
                if (dirtIsInside(x, dirtposX2)) {
                    dirtposX2 = 2000;
                }
                
                if (dirtIsInside(x, WIDTH / 2 - 800) && f1) {
                    count++;
                    f1 = false;
                    System.out.println("Sucked Left " + count);
                }
                
                if (dirtIsInside(x, WIDTH / 2 + 400) && f2) {
                    count++;
                    f2 = false;
                    System.out.println("Sucked Right " + count);
                }
                
                if (count > 1) {
                    flag = false;
                    f1 = true;
                    f2 = true;
                    count = 0;
                }
            }
            repaint();
        }
    }