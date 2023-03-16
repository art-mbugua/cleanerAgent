import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        VaccumCleaner obj = new VaccumCleaner();
    }
}

class VaccumCleaner extends JFrame {

    VaccumCleaner() {
        int WIDTH = 1920, HEIGHT = 1080;
        setVisible(true);
        setTitle("Vaccum Cleaner AI Agent");
        setSize(WIDTH, HEIGHT);
        DrawStuff draw = new DrawStuff();
        JButton runButton = new JButton(new AbstractAction("Run the Vaccum AI Agent") {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.flag = !draw.flag;
            }
        });


        runButton.setBounds(WIDTH / 2-90, 800, 200, 40);
        add(runButton);
        JButton leftButton = new JButton(new AbstractAction("Spawn Dirt") {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.dirtposX1 = WIDTH / 2 - 800;
            }
        });
        

        leftButton.setBounds(WIDTH / 2 - 600, 700, 100, 40);
        add(leftButton);
        JButton rightButton = new JButton(new AbstractAction("Spawn Dirt") {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.dirtposX2 = WIDTH / 2 + 200;
            }
        });

        rightButton.setBounds(WIDTH / 2 + 600, 700, 100, 40);
        add(rightButton);
        add(draw, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}