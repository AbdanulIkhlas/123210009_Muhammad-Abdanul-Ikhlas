package formlogin;

import javax.swing.*;
//? import java.awt.*; (kemungkinan gak kepake)
import java.awt.event.*;

public class FrameKedua extends JFrame {
    // ! inisialisasi
    private JLabel popUp;
    private JButton logout;

    public FrameKedua() {
        // ! set frame baru setelah login
        JFrame frameBaru = new JFrame("Main Frame");

        frameBaru.setSize(400, 230);
        frameBaru.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameBaru.setVisible(true);
        frameBaru.setLocationRelativeTo(null);

        // ! menambahkan komponen ke frameBaru(frame setelah login)
        komponenMain(frameBaru);
    }

    public void komponenMain(JFrame frame) {
        // ! instansiasi
        logout = new JButton("LOG OUT");
        popUp = new JLabel("Anda Telah Login");

        // ! reaksi jika tombol logout di klik
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ! tampilkan notifikasi berhasil logout
                JOptionPane.showMessageDialog(frame, "Berhasil Logout");

                // ! membuka frame login
                new FrameLogin("Form Login");

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
}
