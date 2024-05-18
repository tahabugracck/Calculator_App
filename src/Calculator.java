import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator {
    public static void main(String[] args) {
        // JFrame oluşturulması
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//çarpıya basıldğında otomatik olarak uygulama kapanmayacak. uygulamadan çıkıp çıkmak istemediğimizi soracak.
        frame.setSize(400, 300);//uygulama boyutu
        frame.setLayout(new GridLayout(3, 1)); // 3 satır, 1 sütun layout
        frame.setLocationRelativeTo(null); // Pencereyi ekranın ortasında aç

        // uygulama ikonu ayarla
        frame.setIconImage(new ImageIcon("icon.png").getImage());

        // Pencereyi kapatma işlemi için WindowListener ekle. çarpıya basıldığında bu kod çalışacak.
        frame.addWindowListener(new WindowAdapter() {//çarpıya basıldığında açılır pencere ekliyor.-
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(frame,
                        "Uygulamadan çıkıyorsunuz. Emin misiniz?",
                        "Çıkış Onayı",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });

        // Sayı girişleri için panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JTextField number1Field = new JTextField();
        JTextField number2Field = new JTextField();
        inputPanel.add(new JLabel("Sayı 1:"));
        inputPanel.add(number1Field);
        inputPanel.add(new JLabel("Sayı 2:"));
        inputPanel.add(number2Field);

        // Sonuç için panel
        JPanel resultPanel = new JPanel(new GridLayout(1, 2));
        resultPanel.setBackground(Color.LIGHT_GRAY);
        JLabel resultLabel = new JLabel("Sonuç: ");
        resultLabel.setForeground(Color.BLACK);
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        resultPanel.setBackground(Color.LIGHT_GRAY); // Sonuç paneli arka plan rengi
        resultPanel.add(resultLabel);
        resultPanel.add(resultField);

        // İşlem butonları için panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton addButton = new JButton(new ImageIcon("plus.png"));
        JButton subtractButton = new JButton(new ImageIcon("minus.png"));
        JButton multiplyButton = new JButton(new ImageIcon("multiply.png"));
        JButton divideButton = new JButton(new ImageIcon("divide.png"));

        // Buton arka plan renkleri
        addButton.setBackground(Color.LIGHT_GRAY);
        subtractButton.setBackground(Color.LIGHT_GRAY);
        multiplyButton.setBackground(Color.LIGHT_GRAY);
        divideButton.setBackground(Color.LIGHT_GRAY);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        // Butonların action listener'ları
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(number1Field.getText());
                    double num2 = Double.parseDouble(number2Field.getText());
                    double result = num1 + num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lütfen geçerli sayılar girin.");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(number1Field.getText());
                    double num2 = Double.parseDouble(number2Field.getText());
                    double result = num1 - num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lütfen geçerli sayılar girin.");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(number1Field.getText());
                    double num2 = Double.parseDouble(number2Field.getText());
                    double result = num1 * num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lütfen geçerli sayılar girin.");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(number1Field.getText());
                    double num2 = Double.parseDouble(number2Field.getText());
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Bölme işlemi için ikinci sayı sıfır olamaz.");
                    } else {
                        double result = num1 / num2;
                        resultField.setText(String.valueOf(result));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lütfen geçerli sayılar girin.");
                }
            }
        });

        // Panelleri frame'e ekle
        frame.add(inputPanel);
        frame.add(resultPanel);
        frame.add(buttonPanel);

        // Frame'i görünür yap
        frame.setVisible(true);
    }
}
