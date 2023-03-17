package formlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormLogin extends JFrame {
    // ! inisialisasi
    private JLabel username, password, judul;
    private JTextField inputUsername;
    private JPasswordField inputPassword;
    private JButton login, reset, logout;
    // *-----End-------

    public FormLogin(String judul) {
        // ! set frame
        setTitle(judul);
        setSize(400, 230);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        // *-----End-------

        component();
    }

    public void component() {
        // ! instansiasi
        username = new JLabel("Username : ");
        password = new JLabel("Password  : ");
        judul = new JLabel("FORM LOGIN");
        inputUsername = new JTextField();
        inputPassword = new JPasswordField();
        login = new JButton("LOGIN");
        reset = new JButton("RESET");
        logout = new JButton("LOG OUT");
        // *-----End-------

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
        // *-----End-------

    }

    public static void main(String[] args) {
        // ! memanggil frame
        FormLogin login = new FormLogin("Login");
    }

}
