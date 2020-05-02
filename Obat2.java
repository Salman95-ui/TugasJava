import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Obat2 extends JFrame{
    private JComboBox comboBox1;
    private JButton beliButton;
    private JButton kembaliButton;
    private JPanel obat2;
    final String DB_Driver = "com.mysql.jdbc.Driver";
    final String DB_URL ="jdbc:mysql://localhost/klinik" ;
    final String User = "root" ;
    final String pass = "" ;
    ResultSet rs ;
String user ="";
String nama ="" , obat="" , Harga="";

    private void simpan(){
        String data =(String) comboBox1.getSelectedItem();
        String sql = "SELECT * FROM layananobat WHERE namaObat = " +"'"+data+"'" ;
        try{
            Class.forName(DB_Driver);
            Connection conn = DriverManager.getConnection(DB_URL , User ,pass);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql) ;
            if(rs.next()) {
                obat = rs.getString("namaObat");
                Harga = rs.getString("harga");
                rs.close();
stmt.close();
conn.close();

                JOptionPane.showMessageDialog(null, rs.getString("Data berhasil di tambah"));
            }
        }catch(Exception a){

        }
        Simpan(nama , obat,Harga,user);
    }

    private void Simpan(String nama , String obat , String harga , String id_user ){
        String sql = "INSERT INTO obat VALUES('" + nama +"','"+obat+"','"+harga+"','"+id_user+"')";
        try{
            Class.forName(DB_Driver);
            Connection conn = DriverManager.getConnection(DB_URL , User ,pass);
            Statement stmt = conn.createStatement();
            stmt.execute(sql) ;
            JOptionPane.showMessageDialog(null,"berhasil");
        }catch(Exception a){
            JOptionPane.showMessageDialog(null,a.getMessage());
        }
    }

    public Obat2(String User1 , String nama) {
        this.user = User1 ;
        this.nama = nama ;
        setSize(300,300);
        setTitle("Layanan Obat");
        add(obat2);
        beliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpan();
            }
        });
    }
}
