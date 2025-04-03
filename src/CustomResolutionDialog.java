import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomResolutionDialog extends JFrame {

    private int selectedWidth = 800;  // Default width
    private int selectedHeight = 600; // Default height

    public CustomResolutionDialog() {
        setTitle("Custom Resolution Dialog Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the custom resolution dialog
        JDialog resolutionDialog = createResolutionDialog(this);
        resolutionDialog.setVisible(true); // Show dialog

        setSize(selectedWidth, selectedHeight); // Set initial size
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JDialog createResolutionDialog(JFrame parent) {
        JDialog dialog = new JDialog(parent, "Select Resolution", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(parent); // Center relative to parent

        // Radio buttons for resolutions
        JRadioButton res800x600 = new JRadioButton("800x600");
        JRadioButton res1024x768 = new JRadioButton("1024x768");
        JRadioButton res1280x720 = new JRadioButton("1280x720");

        // ButtonGroup to ensure only one radio button is selected
        ButtonGroup resolutionGroup = new ButtonGroup();
        resolutionGroup.add(res800x600);
        resolutionGroup.add(res1024x768);
        resolutionGroup.add(res1280x720);

        // Select 800x600 by default
        res800x600.setSelected(true);

        // OK and Cancel buttons
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        // Add components to the dialog
        dialog.add(new JLabel("Select a resolution:"));
        dialog.add(res800x600);
        dialog.add(res1024x768);
        dialog.add(res1280x720);
        dialog.add(okButton);
        dialog.add(cancelButton);

        // Action listener for OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (res800x600.isSelected()) {
                    selectedWidth = 800;
                    selectedHeight = 600;
                } else if (res1024x768.isSelected()) {
                    selectedWidth = 1024;
                    selectedHeight = 768;
                } else if (res1280x720.isSelected()) {
                    selectedWidth = 1280;
                    selectedHeight = 720;
                }

                setSize(selectedWidth, selectedHeight); // Set resolution for the main frame
                setLocationRelativeTo(parent);
                dialog.dispose();  // Close the dialog
            }
        });

        // Action listener for Cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                System.exit(0); // Terminate application on cancel
            }
        });

        return dialog;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomResolutionDialog::new);
    }
}
