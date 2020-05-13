import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;

public class Pembayaran extends JFrame{
    private JTextField textField1;
    private JButton confirmButton;
    private JPanel pem;
    private JButton kembaliButton;
    final String DB_Driver = "com.mysql.jdbc.Driver";
    final String DB_URL ="jdbc:mysql://localhost/klinik" ;
    final String User = "root" ;
    final String pass = "" ;

    String id_user ="" ;
    float uang ;
    private void tampil(){
        setVisible(true);
    }
    private void tutup(){
        dispose();
    }

    public Pembayaran(String user , float uang) {
         this.id_user = user ;
         this.uang = uang ;
        setSize(300,300);
        setTitle("Form Pembayaran");
        add(pem);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 float nilai = Float.valueOf(textField1.getText());
                 boolean check = false ;
                 while (!check) {
                     if (nilai > uang) {
                         float hasil = nilai - uang;
                         JOptionPane.showMessageDialog(null, "kembalian : " + hasil +"\n Terimakasih telah mengunjungi Klinik kami");
                         check = true;
                         try {
                             String sql = "Delete from obat where id_user ='" + user + "'";
                             Class.forName(DB_Driver);
                             Connection conn = DriverManager.getConnection(DB_URL, User, pass);
                             Statement stmt = conn.createStatement();
                             stmt.execute(sql);
                             dispose();
                         } catch (Exception a) {
                             JOptionPane.showMessageDialog(null, a.getMessage());
                         }
                     }else{
                         check = true;
                         JOptionPane.showMessageDialog(null,"Maaf nominal terlalu kecil\n silahkan melakukan ulang");
                         textField1.setText(null);
                         tutup();
                         tampil();
                     }
                 }

            }
        });
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
