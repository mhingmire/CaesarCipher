import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaesarCipherGUI {

    // Encrypting method
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char shifted = (char) ((character - base + shift) % 26 + base);
                result.append(shifted);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    // Decrypting method (reverse shift)
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("🔐 Caesar Cipher Encoder & Decoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Layout
        frame.setLayout(new BorderLayout());

        // Input area
        JTextArea inputArea = new JTextArea(5, 30);
        JScrollPane inputScroll = new JScrollPane(inputArea);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        // Output area
        JTextArea outputArea = new JTextArea(5, 30);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);

        // Slider for shift key
        JSlider shiftSlider = new JSlider(0, 25, 3); 
        shiftSlider.setMajorTickSpacing(5);
        shiftSlider.setMinorTickSpacing(1);
        shiftSlider.setPaintTicks(true);
        shiftSlider.setPaintLabels(true);

        JLabel shiftLabel = new JLabel("Shift: 3");

        // Buttons
        JButton encryptButton = new JButton("Encrypt & Send");
        JButton decryptButton = new JButton("Decrypt & Send");

        // Panel for controls
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1));
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(shiftLabel);
        sliderPanel.add(shiftSlider);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        controlPanel.add(sliderPanel);
        controlPanel.add(buttonPanel);

        // Adding components to frame
        frame.add(new JLabel("Enter your message:"), BorderLayout.NORTH);
        frame.add(inputScroll, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(outputScroll, BorderLayout.EAST);

        // Updating label when slider moves
        shiftSlider.addChangeListener(e -> {
            int value = shiftSlider.getValue();
            shiftLabel.setText("Shift: " + value);
        });

        // Action Listeners
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift = shiftSlider.getValue();
                String encrypted = encrypt(inputArea.getText(), shift);
                outputArea.setText(encrypted);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int shift = shiftSlider.getValue();
                String decrypted = decrypt(inputArea.getText(), shift);
                outputArea.setText(decrypted);
            }
        });

        // Show window
        frame.setVisible(true);
    }
}

