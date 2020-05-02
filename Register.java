import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
    private JComboBox comboBox1;
    /*


     */

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
        String kel = (String) comboBox1.getSelectedItem();
        String text1 = textname.getText() ;
        String text2 = texttl.getText() ;
        String text3 = kel ;
        String text4 = texthp.getText() ;
        String text5 = textalamat.getText() ;
        String sql = "INSERT INTO pasien VALUES('" + text1 + "' , '" +text2 + "' , '"+ kel +"','" + text4
                + "' , '" + text5 + "','"+user+"')" ;
        boolean cek = false ;
        try {
            Class.forName(DB_Driver) ;
            Connection conn = DriverManager.getConnection(DB_URL,User,pass) ;
            Statement stmt = conn.createStatement();
            stmt.execute(sql) ;
            JOptionPane.showMessageDialog(null,"Data Berhasil di simpan");
            cek = true ;
            conn.close();
            stmt.close();
            kosongkan();

        }catch (Exception a){

        }


         if(cek){
             JOptionPane.showMessageDialog(null, "Nama :" + text1 + "\n"
             + "Tanggal Lahir :"  + text2 + "\n"+ "Jenis Kelamin :" + text3 +"\n" +
                     "No Hp :" + text4 + "\n" + "Alamat :" + text5 +"\n Id_User :" + user
             );
         }else{
           JOptionPane.showMessageDialog(null , "Maaf terjadi kesalahan ");
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
  dispose();
            }
        });
    }
}
