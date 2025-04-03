import javax.swing.*;

public class ConfirmationChoice {

    public static void main(String[] args) {
        // 1. Ask the first question
        int choice1 = JOptionPane.showConfirmDialog(
                null,  // No parent component, center on screen
                "Do you like pizza?",  // Question
                "Question 1",  // Title
                JOptionPane.YES_NO_OPTION  // Option type
        );

        // 2. Ask the second question
        int choice2 = JOptionPane.showConfirmDialog(
                null,
                "Do you like Java programming?",
                "Question 2",
                JOptionPane.YES_NO_OPTION
        );

        // 3. Determine the outcome based on the answers
        String resultMessage = null;

        if (choice1 == JOptionPane.YES_OPTION && choice2 == JOptionPane.YES_OPTION) {
            resultMessage = "Great! You like both pizza and Java! You're awesome!";
        } else if (choice1 == JOptionPane.YES_OPTION && choice2 == JOptionPane.NO_OPTION) {
            resultMessage = "You like pizza, but not Java? That's a bit unusual.";
        } else if (choice1 == JOptionPane.NO_OPTION && choice2 == JOptionPane.YES_OPTION) {
            resultMessage = "You don't like pizza, but you like Java? Interesting...";
        } else {
            resultMessage = "You don't like either pizza or Java? I'm not sure what to say...";
        }

        // 4. Display the result message
        JOptionPane.showMessageDialog(
                null,
                resultMessage,
                "Results",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}