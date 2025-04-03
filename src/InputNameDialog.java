import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputNameDialog extends JFrame {

    public InputNameDialog() {
        setTitle("Input Name Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton showInputDialogButton = new JButton("Enter Your Name");
        showInputDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Show Input Dialog
                String name = JOptionPane.showInputDialog(
                        InputNameDialog.this,  // Parent component
                        "Please enter your name:",  // Message
                        "Name Input",  // Title
                        JOptionPane.QUESTION_MESSAGE  // Message type
                );

                // 2. Check if the user entered a name and clicked "OK"
                if (name != null && !name.trim().isEmpty()) {
                    // 3. Show Information Dialog with the entered name
                    JOptionPane.showMessageDialog(
                            InputNameDialog.this,  // Parent component
                            "Hello, " + name + "!",  // Message with the name
                            "Welcome",  // Title
                            JOptionPane.INFORMATION_MESSAGE  // Message type
                    );
                } else {
                    // Handle the case where the user clicked cancel or didn't enter a name
                    JOptionPane.showMessageDialog(
                            InputNameDialog.this,
                            "No name entered.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        add(showInputDialogButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InputNameDialog::new);
    }
}