package Program;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class RealTimeCounter extends JFrame {
    private Timer timer;
    private JLabel label;

    public RealTimeCounter() {
        setTitle("Real Time Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("A");

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        add(label);
        add(buttonPanel, "South");

        timer = new Timer(100, new ActionListener() {
            char currentChar = 'A';

            public void actionPerformed(ActionEvent e) {
                System.out.println(currentChar);
                label.setText(String.valueOf(currentChar));
                currentChar++;
            }
        });
    }

    private void startTimer() {
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RealTimeCounter().setVisible(true);
            }
        });
    }
}
