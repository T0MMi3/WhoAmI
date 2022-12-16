/*
 * Tommy Do 1001982682
 */
package code6_1001982682;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Tommy Do
 */
public class GameFrame extends JFrame
{
    private final JLabel labell = null;
    private final JButton OKButton;
    private final JButton CancelButton;
    private final JTextField textField1;
    String CCName = null;
    
    public GameFrame()
    {
        super("Code6_1001982682");
        setLayout(new FlowLayout());
        Random rn = new Random();
        int rand = rn.nextInt(4)+1;
        switch(rand) {
            case 1: CCName = "Finn";
                    break;
            case 2: CCName = "Jake";
                    break;
            case 3: CCName = "Gunter";
                    break;
            case 4: CCName = "BMO";
                    break;
        }
        
        Icon CC = new ImageIcon(getClass().getResource(CCName + ".png"));
        JLabel label1 = new JLabel(CC);
        Font newTextFieldFont = new Font(label1.getFont().getName(),label1.getFont().getStyle(),20);
        label1.setFont(newTextFieldFont);
        label1.setText("What is the cartoon character's name?");
        label1.setIcon(CC);
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.BOTTOM);
        label1.setToolTipText("What is the cartoon character's name?");
        add(label1);
        textField1 = new JTextField(20);
        textField1.setText("Type your answer here");
        textField1.selectAll();
        add(textField1);
        OKButton = new JButton("OK");
        add(OKButton);
        CancelButton = new JButton("Cancel");
        add(CancelButton);
        EventHandler handler = new EventHandler();
        textField1.addActionListener(handler);
        OKButton.addActionListener(handler);
        CancelButton.addActionListener(handler);
        
    }
        
        private class EventHandler implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String string = null;
                boolean correctGuess = false;
                String userInput = textField1.getText();
                if (userInput.equalsIgnoreCase(CCName))
                {
                    string = "Correct!";
                    correctGuess = true;
                }
                else
                {
                    string = "Wrong!";
                }
                if(event.getSource() == OKButton || event.getSource() == textField1)
                {
                    JOptionPane.showMessageDialog(null, string);
                    if(correctGuess == true)
                    {
                        System.exit(0);
                    }
                }
                else if(event.getSource() == CancelButton)
                {
                    System.exit(0);
                }
            }
        }
}
