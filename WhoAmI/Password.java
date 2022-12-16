/*
 * Tommy Do 1001982682
 */
package code6_1001982682;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Tommy Do
 */




public class Password extends JFrame 
{
    private final JPasswordField passwordField;
    final String passwrd = "password";

    public Password() 
    {
        super("Enter the password to continue...");
        setLayout(new FlowLayout());
        passwordField = new JPasswordField(10);
        passwordField.setEchoChar('X');
        add(passwordField);
        EventHandler handler = new EventHandler();
        passwordField.addActionListener(handler);
    }
    
    private class EventHandler implements ActionListener
    {
    @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "Invalid Password";
            JPasswordField userInput = (JPasswordField) event.getSource();
            char[] passy = userInput.getPassword();
            String p = new String(passy);
            if (userInput == passwordField)
            {
                
                if(p.equals(passwrd))
                {
                    setVisible(false);
                    GameFrame gameframe = new GameFrame();
                    gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gameframe.setSize(1300,1150);
                    gameframe.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, string);
                }
            }
        }
    }
}
