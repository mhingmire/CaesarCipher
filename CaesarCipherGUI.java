// importing necessary libraries
import javax.swing.*; // for frames, text area(JFramess,JButton)
import java.awt.*; // for GUI and other layout stuff
import java.awt.event.*; // for buttons and sliders

public class CaesarCipherGUI {

    // encrypting method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A'; // setting base ascii value
                char shifted = (char) ((character - base + shift) % 26 + base); // shifting chars between 0-25 and converting back to char
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    // decrypting method 
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // literally reversing the encryption
    }

    public static void main(String[] args) {
        // setting frame with size and closing frame
        JFrame frame = new JFrame("🔐 Caesar Cipher Encoder & Decoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); 

        // frame layout
        frame.setLayout(new BorderLayout());

        // input area boundaries and layout stuff
        JTextArea inputArea = new JTextArea(5, 30);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        // output area boundaries and layout stuff, sizing
        JTextArea outputArea = new JTextArea(5, 30);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);

        // slider
        JSlider shiftSlider = new JSlider(0, 25, 3); 
        shiftSlider.setMajorTickSpacing(5);
        shiftSlider.setMinorTickSpacing(1);
        shiftSlider.setPaintTicks(true);
        shiftSlider.setPaintLabels(true);

        JLabel shiftLabel = new JLabel("Shift: 3");

        // buttons
        JButton encryptButton = new JButton("Encrypt & Send");
        JButton decryptButton = new JButton("Decrypt & Send");

        // control panel settings
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1));
        //adding slider panel
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(shiftLabel);
        sliderPanel.add(shiftSlider);
        // adding button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        //add button panela nd slider panel in cotrol panel
        controlPanel.add(sliderPanel);
        controlPanel.add(buttonPanel);

        // main frame sizing
        frame.add(new JLabel("Enter your message:"), BorderLayout.NORTH);
        frame.add(inputScroll, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(outputScroll, BorderLayout.EAST);

        // making the shift label change in real-time as we move shift slider
        //just for the effects
        shiftSlider.addChangeListener(e -> {
            int value = shiftSlider.getValue();
            shiftLabel.setText("Shift: " + value);
        });

        // main encryption 
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift = shiftSlider.getValue(); // current shift value
                String encrypted = encrypt(inputArea.getText(), shift);//encrypting the plain text
                outputArea.setText(encrypted);// encrypted text appears in the output text area
            }
        });
        //main decryption
        // its the same method as encryption just putting the decrpyted text in input and getting plain text as output
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift = shiftSlider.getValue();
                String decrypted = decrypt(inputArea.getText(), shift);
                outputArea.setText(decrypted);
            }
        });

        // window
        frame.setVisible(true);
    }
}


