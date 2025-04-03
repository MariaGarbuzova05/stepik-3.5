import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistrationProcess extends JFrame {

    public RegistrationProcess() {
        setTitle("Registration Process");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Important for proper exit
        setSize(400, 200);
        setLocationRelativeTo(null);

        // 1. Welcome and Registration Prompt
        int register = JOptionPane.showConfirmDialog(
                this,  // Parent component
                "Welcome! Would you like to register?",  // Message
                "Registration",  // Title
                JOptionPane.YES_NO_OPTION
        );

        if (register == JOptionPane.NO_OPTION) {
            System.exit(0); // Terminate if user doesn't want to register
        }

        // 2. Get Login
        String login = getValidLogin();
        if (login == null) {
            System.exit(0); // Terminate if user cancels login entry
        }

        // 3. Get Password
        String password = getValidPassword();
        if (password == null) {
            System.exit(0); // Terminate if user cancels password entry
        }

        // 4. Confirm Password
        String confirmedPassword = confirmPassword(password);
        if (confirmedPassword == null) {
            System.exit(0); // Terminate if user cancels password confirmation
        }

        // 5. Success Message
        JOptionPane.showMessageDialog(
                this,
                "Registration successful! Welcome, " + login + "!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (register == JOptionPane.OK_OPTION) {
            System.exit(0); // Terminate if user doesn't want to register
        }
        if (register == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

        //setVisible(true);
    }

    // Method to get a valid login
    private String getValidLogin() {
        String login = null;
        while (true) {
            login = JOptionPane.showInputDialog(
                    this,
                    "Enter a login (more than 5 characters, no spaces):",
                    "Login",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (login == null) {
                return null; // User cancelled
            }

            login = login.trim(); // Remove leading/trailing spaces

            if (login.length() > 5 && !login.contains(" ")) {
                break; // Valid login
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid login. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return login;
    }

    // Method to get a valid password
    private String getValidPassword() {
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
                "Enter a password (more than 8 characters, no spaces,\n" +
                        "at least one digit and one letter):",
                passwordField
        };

        while (true) {
            int option = JOptionPane.showConfirmDialog(
                    this,
                    message,
                    "Password",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.CANCEL_OPTION) {
                return null; // User cancelled
            }

            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            password = password.trim();

            if (isValidPassword(password)) {
                // Clear the password from memory after use (important for security)
                for (int i = 0; i < passwordChars.length; i++) {
                    passwordChars[i] = 0;
                }
                return password;
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid password. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Helper method to validate the password
    private boolean isValidPassword(String password) {
        if (password.length() <= 8 || password.contains(" ")) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLetter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLetter(c)) {
                hasLetter = true;
            }
        }

        return hasDigit && hasLetter;
    }

    // Method to confirm the password
    private String confirmPassword(String password) {
        JPasswordField confirmPasswordField = new JPasswordField();
        Object[] message = {
                "Confirm password:",
                confirmPasswordField
        };

        while (true) {
            int option = JOptionPane.showConfirmDialog(
                    this,
                    message,
                    "Confirm Password",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (option == JOptionPane.CANCEL_OPTION) {
                return null; // User cancelled
            }

            char[] confirmPasswordChars = confirmPasswordField.getPassword();
            String confirmPassword = new String(confirmPasswordChars);
            // Clear password from memory after use
            for (int i = 0; i < confirmPasswordChars.length; i++) {
                confirmPasswordChars[i] = 0;
            }

            if (password.equals(confirmPassword)) {
                return password;
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match. Please try again.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrationProcess::new);
    }
}