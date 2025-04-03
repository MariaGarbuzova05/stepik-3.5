import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResolutionSelector extends JFrame {

    private static final String[] RESOLUTIONS = {
            "800x600",
            "1024x768",
            "1200x600",
            "1280x1024",
            "1680x1050",
            "1920x1080"
    };

    public ResolutionSelector() {
        setTitle("Resolution Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Important: Close the whole application

        // Create the dialog
        JDialog resolutionDialog = new JDialog(this, "Choose Resolution", true); // Modal
        resolutionDialog.setLayout(new FlowLayout());
        resolutionDialog.setSize(300, 200);
        resolutionDialog.setLocationRelativeTo(null); // Center on screen

        JLabel label = new JLabel("Select Resolution:");
        JComboBox<String> resolutionComboBox = new JComboBox<>(RESOLUTIONS);
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        resolutionDialog.add(label);
        resolutionDialog.add(resolutionComboBox);
        resolutionDialog.add(okButton);
        resolutionDialog.add(cancelButton);

        // OK button action
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedResolution = (String) resolutionComboBox.getSelectedItem();
                if (selectedResolution != null) {
                    String[] parts = selectedResolution.split("x");
                    int width = Integer.parseInt(parts[0]);
                    int height = Integer.parseInt(parts[1]);

                    setSize(width, height); // Set the main frame size
                    setLocationRelativeTo(null); // Center the frame
                    setVisible(true);
                    resolutionDialog.dispose(); // Close the dialog
                }
            }
        });

        // Cancel button action
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolutionDialog.dispose();  // Close dialog
                System.exit(0); // Exit the whole application on cancel
            }
        });

        // Show the resolution selection dialog first
        resolutionDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ResolutionSelector::new);
    }
}