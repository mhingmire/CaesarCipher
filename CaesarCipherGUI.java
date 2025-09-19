// import javax.swing.*;
// import javax.swing.event.ChangeEvent;
// import javax.swing.event.ChangeListener;
// import java.awt.*;

// public class CaesarCipherGUI extends JFrame {

//     private JTextArea inputArea;
//     private JTextArea outputArea;
//     private JSlider shiftSlider;

//     public CaesarCipherGUI() {
//         // Frame setup
//         setTitle("Caesar Cipher Encrypter");
//         setSize(500, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // Input area
//         inputArea = new JTextArea("Enter your text here...");
//         inputArea.setLineWrap(true);
//         inputArea.setWrapStyleWord(true);
//         JScrollPane inputScroll = new JScrollPane(inputArea);

//         // Output area
//         outputArea = new JTextArea();
//         outputArea.setLineWrap(true);
//         outputArea.setWrapStyleWord(true);
//         outputArea.setEditable(false);
//         JScrollPane outputScroll = new JScrollPane(outputArea);

//         // Split pane for input/output
//         JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputScroll, outputScroll);
//         splitPane.setDividerLocation(150);

//         // Slider for shift key
//         shiftSlider = new JSlider(0, 25, 3);
//         shiftSlider.setMajorTickSpacing(5);
//         shiftSlider.setMinorTickSpacing(1);
//         shiftSlider.setPaintTicks(true);
//         shiftSlider.setPaintLabels(true);

//         // Event listeners
//         inputArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
//             public void insertUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
//             public void removeUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
//             public void changedUpdate(javax.swing.event.DocumentEvent e) { updateOutput(); }
//         });

//         shiftSlider.addChangeListener(new ChangeListener() {
//             @Override
//             public void stateChanged(ChangeEvent e) {
//                 updateOutput();
//             }
//         });

//         // Add components to frame
//         add(splitPane, BorderLayout.CENTER);
//         add(shiftSlider, BorderLayout.SOUTH);

//         setVisible(true);
//     }

//     private void updateOutput() {
//         String text = inputArea.getText();
//         int shift = shiftSlider.getValue();
//         outputArea.setText(encrypt(text, shift));
//     }

//     // Caesar cipher logic
//     public static String encrypt(String text, int shift) {
//         StringBuilder result = new StringBuilder();

//         for (char character : text.toCharArray()) {
//             if (Character.isLetter(character)) {
//                 char base = Character.isLowerCase(character) ? 'a' : 'A';
//                 char shifted = (char) ((character - base + shift) % 26 + base);
//                 result.append(shifted);
//             } else {
//                 result.append(character);
//             }
//         }
//         return result.toString();
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> new CaesarCipherGUI());
//     }
// }


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class CaesarCipherGUI {

//     // Encrypt method
//     public static String encrypt(String text, int shift) {
//         StringBuilder result = new StringBuilder();

//         for (char character : text.toCharArray()) {
//             if (Character.isLetter(character)) {
//                 char base = Character.isLowerCase(character) ? 'a' : 'A';
//                 char shifted = (char) ((character - base + shift) % 26 + base);
//                 result.append(shifted);
//             } else {
//                 result.append(character);
//             }
//         }
//         return result.toString();
//     }

//     // Decrypt method (just reverse shift)
//     public static String decrypt(String text, int shift) {
//         return encrypt(text, 26 - shift);
//     }

//     public static void main(String[] args) {
//         // Create frame
//         JFrame frame = new JFrame("🔐 Secret Messaging App");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(500, 400);

//         // Layout
//         frame.setLayout(new BorderLayout());

//         // Input area
//         JTextArea inputArea = new JTextArea(5, 30);
//         JScrollPane inputScroll = new JScrollPane(inputArea);
//         inputArea.setLineWrap(true);
//         inputArea.setWrapStyleWord(true);

//         // Output area
//         JTextArea outputArea = new JTextArea(5, 30);
//         JScrollPane outputScroll = new JScrollPane(outputArea);
//         outputArea.setLineWrap(true);
//         outputArea.setWrapStyleWord(true);
//         outputArea.setEditable(false);

//         // Shift key input
//         JTextField shiftField = new JTextField(5);

//         // Buttons
//         JButton encryptButton = new JButton("Encrypt & Send");
//         JButton decryptButton = new JButton("Decrypt");

//         // Panel for controls
//         JPanel controlPanel = new JPanel();
//         controlPanel.add(new JLabel("Shift (0-25):"));
//         controlPanel.add(shiftField);
//         controlPanel.add(encryptButton);
//         controlPanel.add(decryptButton);

//         // Add components to frame
//         frame.add(new JLabel("Enter your message:"), BorderLayout.NORTH);
//         frame.add(inputScroll, BorderLayout.CENTER);
//         frame.add(controlPanel, BorderLayout.SOUTH);
//         frame.add(outputScroll, BorderLayout.EAST);

//         // Action Listeners
//         encryptButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 try {
//                     int shift = Integer.parseInt(shiftField.getText());
//                     String encrypted = encrypt(inputArea.getText(), shift);
//                     outputArea.setText(encrypted);
//                 } catch (Exception ex) {
//                     JOptionPane.showMessageDialog(frame, "Please enter a valid shift (0-25)");
//                 }
//             }
//         });

//         decryptButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 try {
//                     int shift = Integer.parseInt(shiftField.getText());
//                     String decrypted = decrypt(inputArea.getText(), shift);
//                     outputArea.setText(decrypted);
//                 } catch (Exception ex) {
//                     JOptionPane.showMessageDialog(frame, "Please enter a valid shift (0-25)");
//                 }
//             }
//         });

//         // Show window
//         frame.setVisible(true);
//     }
// }


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaesarCipherGUI {

    // Encrypt method
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

    // Decrypt method (just reverse shift)
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
        JSlider shiftSlider = new JSlider(0, 25, 3); // min=0, max=25, initial=3
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

        // Add components to frame
        frame.add(new JLabel("Enter your message:"), BorderLayout.NORTH);
        frame.add(inputScroll, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(outputScroll, BorderLayout.EAST);

        // Update label when slider moves
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
