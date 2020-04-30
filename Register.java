import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random ;
public class Register extends JFrame {
    private JButton button1;
    private JPanel reg;
    private JTextField textname;
    private JTextField texttl;
    private JTextField texthp;
    private JTextField textalamat;

    final String DB_Driver = "com.mysql.jdbc.Driver";
    final String DB_URL ="jdbc:mysql://localhost/klinik" ;
    final String User = "root" ;
    final String pass = "" ;
private void kosongkan(){
    textname.setText(null);
    textalamat.setText(null);
    texthp.setText(null);
    texttl.setText(null);
}

    private void simpan(){
        Random rand = new Random() ;
        int angka = rand.nextInt(100);
        String user = "user"+angka;
        String sql = "INSERT INTO pasien VALUES('" + textname.getText() + "' , '" +texttl.getText() + "' , '" + texthp.getText()
                + "' , '" + user + "' , '" + textalamat.getText() + "')" ;
        try {
            Class.forName(DB_Driver) ;
            Connection conn = DriverManager.getConnection(DB_URL,User,pass) ;
            Statement stmt = conn.createStatement();
            stmt.execute(sql) ;
            JOptionPane.showMessageDialog(null,"Data Berhasil di simpan");
            conn.close();
            stmt.close();
            kosongkan();

        }catch (Exception a){

        }
    }

    public Register() {
        setSize(400,400);
        setTitle("reg");
        add(reg) ;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
  simpan();
  System.exit(0);
            }
        });
    }
}
