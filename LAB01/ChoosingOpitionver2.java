import javax.swing.JOptionPane;

public class ChoosingOpitionver2 {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog(null, 
            "Do you want to change to the first class ticket?", 
            "Custom Options",
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, options, options[0]);

        JOptionPane.showMessageDialog(null, 
            "You've chosen: " + options[choice]);
    }
}