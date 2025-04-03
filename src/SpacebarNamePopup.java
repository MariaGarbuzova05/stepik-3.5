import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SpacebarNamePopup extends JFrame {

    public SpacebarNamePopup() {
        setTitle("Spacebar Popup Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. Create an InputMap and ActionMap
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // 2. Bind the Spacebar KeyStroke to an Action Name
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "spaceAction");

        // 3. Create an AbstractAction
        actionMap.put("spaceAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display an information dialog box with your name
                JOptionPane.showMessageDialog(SpacebarNamePopup.this, "My name is Maria", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpacebarNamePopup::new);
    }
}