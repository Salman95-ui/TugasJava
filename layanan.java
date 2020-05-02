import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class layanan extends JFrame {
    private JButton layananObatButton;
    private JButton layananPraktekButton;
    private JPanel Layanan;
    final String DB_Driver = "com.mysql.jdbc.Driver";
    final String DB_URL ="jdbc:mysql://localhost/klinik" ;
    final String User = "root" ;
    final String pass = "" ;
String user ="" ;
String nama ="";

    public layanan(String User , String nama ) {
        this.user = User;
        this.nama = nama;
        setTitle("Layanan Aplikasi");
        setSize(300,300);
        add(Layanan) ;

        layananObatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Obat2 o = new Obat2(user , nama);
              o.setVisible(true);
              dispose();
            }
        });
        layananPraktekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                praktek p = new praktek(user,nama) ;
                p.setVisible(true);
                dispose();
            }
        });
    }
}



