import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.* ;
import java.util.ArrayList;

public class klinik extends JFrame{
    private JButton Register1;
    private JButton Layanan;
    private JButton Laporan;
    private JButton Pembayaran;
    private JButton Jadwal_Dokter;
    private JTable tableklinik;
    private JPanel klinik;
    private JButton keluar;

    final String DB_Driver = "com.mysql.jdbc.Driver";
    final String DB_URL ="jdbc:mysql://localhost/klinik" ;
    final String User = "root" ;
    final String pass = "" ;
    ResultSet rs ;


    public klinik() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Obat");
        model.addColumn("Harga");
        model.addColumn("User_Id");
        setSize(400,500);
        add(klinik) ;
        setTitle("Klinik Tong-Fang");
        Register1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Register rg = new Register() ;
            rg.setVisible(true);
            }
        });
        Laporan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String x = JOptionPane.showInputDialog("Masukan User_ID Anda ");
                String sql = "SELECT * FROM obat WHERE id_user = '" + x + "'";
                try{
                    Class.forName(DB_Driver) ;
                    Connection conn = DriverManager.getConnection(DB_URL , User , pass) ;
                    Statement stmt = conn.createStatement() ;

                    rs = stmt.executeQuery(sql) ;
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null , "Data ditemukan Silahkan lihat tabel di bawah");
                    }else{
                        JOptionPane.showMessageDialog(null , "Data tidak ada ");
                    }

                     String hasil ="" ;
                    String hasil2 ="" ;
                    boolean cek = false ;
                    ArrayList<String> ar = new ArrayList<>() ;
                     while (!cek){

                         hasil2 +=  rs.getString("obat");

                         if(!rs.next()){
                             cek = true ;
                         }
                     }
                    JOptionPane.showMessageDialog(null , "Obat " + hasil2);



                }catch (Exception a){

                }

            }
        });
        keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


