package formlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class loginFrame extends JFrame implements ActionListener {
    // ! inisialisasi
    private final JTextField usernameAkun = new JTextField("klaz");
    private final JPasswordField passwordAkun = new JPasswordField("123");
    private JLabel username, password, judul, popUp;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private JButton login, reset, logout;

    public loginFrame(String judul) {
        // ! set frame login
        setTitle(judul);
        setSize(400, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        komponenLogin();
    }

    public void mainFrame() {
        // ! set frame baru setelah login
        JFrame frameBaru = new JFrame("Main Frame");

        frameBaru.setSize(400, 230);
        frameBaru.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameBaru.setVisible(true);
        frameBaru.setLocationRelativeTo(null);

        // ! menambahkan komponen ke frameBaru(frame setelah login)
        komponenMain(frameBaru);
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
        logout = new JButton("LOG OUT");

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

    public void komponenMain(JFrame frame) {
        // ! instansiasi
        logout = new JButton("LOG OUT");
        popUp = new JLabel("Anda Telah Login");

        // ! reaksi jika tombol logout di klik
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ! tampilkan notifikasi berhasil logout
                JOptionPane.showMessageDialog(frame, "Berhasil Logout");

                // ! membuka frame login
                new loginFrame("Form Login");

                // ! tutup frame baru
                frame.dispose();
            }
        });

        // ! Layouting
        popUp.setBounds(130, 60, 150, 20);
        logout.setBounds(125, 90, 110, 25);

        frame.setLayout(null);
        frame.add(popUp);
        frame.add(logout);
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
                mainFrame();

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

public class FormLogin {
    public static void main(String[] args) {
        // ! memanggil frame
        new loginFrame("Form Login");
    }

}
