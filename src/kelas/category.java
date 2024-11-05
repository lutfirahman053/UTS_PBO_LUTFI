/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author hp
 */

public class category {
    int category_id;
    String category_name;


    Connection konek;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public category() throws SQLException {
        koneksi koneksi = new koneksi();
        konek = koneksi.konekDB();
    }


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    public void tambahCategory() {
        query = "INSERT INTO category VALUES (?,?)";

        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, category_id);

            ps.setString(2, category_name);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category Berhasil Ditambahkan");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category Gagal Ditambahkan");
        }

    }

    public ResultSet tampilCategory() {
        query = "SELECT * FROM category";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category Gagal Ditampilkan");
        }

        return rs;
    }

    public void hapusCategory() {
        query = "DELETE FROM category WHERE category_id = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setInt(1, category_id);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category Berhasil Di Hapus");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category Gagal Di Hapus");
        }
    }

    public void ubahCategory() {

        query = "UPDATE category SET category_name = ? "
                + " WHERE category_id = ?";
        try {

            ps = konek.prepareStatement(query);

            ps.setString(1, category_name);
            ps.setInt(2, category_id);

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Category Berhasil Di Ubah");

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Category Gagal Di Ubah");
        }

    }

    public ResultSet otoID() {

        query = "SELECT category_id FROM category ORDER BY category_id DESC LIMIT 1";
        try {
            st = konek.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil ID kategori berikutnya: " + ex.getMessage());
        }
        return rs;
    }

    public ResultSet tampilComboBox() {
        try {
            query = "SELECT category_name FROM category";
            st = konek.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }

        return rs;

    }

    public ResultSet Konversi() {
        query = "SELECT category_id FROM category WHERE category_name = ?";
        try {
            ps = konek.prepareStatement(query);
            ps.setString(1, category_name);

            rs = ps.executeQuery();
            System.out.println("data masuk");

        } catch (SQLException SQLException) {
            System.out.println("data tidak masuk");
        }
        return rs;
    }

}
    

