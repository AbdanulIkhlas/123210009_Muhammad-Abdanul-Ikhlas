package formlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class FrameLogin extends JFrame implements ActionListener {
    // ! inisialisasi
    private final JTextField usernameAkun = new JTextField("klaz");
    private final JPasswordField passwordAkun = new JPasswordField("123");
    private JLabel username, password, judul;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private JButton login, reset;

    public FrameLogin(String judul) {
        // ! set frame login
        setTitle(judul);
        setSize(400, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        komponenLogin();
    }

    public void komponenLogin() {
        // ! instansiasi
        username = new JLabel("Username : ");
        password = new JLabel("Password  : ");
        judul = new JLabel("FORM LOGIN");
        inputUsername = new JTextField();
        inputPassword = new JPasswordField();
        login = new JButton("LOGIN");
        reset = new JButton("RESET");

        // !! menangkap aksi pada button
        login.addActionListener(this);
        reset.addActionListener(this);

        // ! layouting
        judul.setBounds(160, 0, 100, 20);
        username.setBounds(40, 40, 100, 20);
        password.setBounds(40, 70, 100, 20);
        inputUsername.setBounds(110, 42, 230, 20);
        inputPassword.setBounds(110, 72, 230, 20);
        login.setBounds(85, 120, 80, 25);
        reset.setBounds(235, 120, 80, 25);

        setLayout(null);
        add(username);
        add(password);
        add(judul);
        add(inputUsername);
        add(inputPassword);
        add(login);
        add(reset);
    }

    // ! rekasi ketika tombol login & reset d klik
    @Override
    public void actionPerformed(ActionEvent buttonKlik) {
        if (buttonKlik.getSource() == login) {
            // ! membandingkan username dan password inisialisasi dengan user dan pass input
            if (inputUsername.getText().equals(usernameAkun.getText())
                    && Arrays.equals(passwordAkun.getPassword(), inputPassword.getPassword())) {

                // ! menampilkan popup berhasil login
                JOptionPane.showMessageDialog(null, "Berhasil Login :)");

                // ! pindah ke frame baru
                new FrameKedua();

                // ! menutup frame lama
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }

        }

        if (buttonKlik.getSource() == reset) {
            // ! reset field
            inputUsername.setText("");
            inputPassword.setText("");
        }

    }
}
