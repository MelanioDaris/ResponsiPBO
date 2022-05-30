/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPraktikumPBO;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Agil
 */
public class ModKaryawan {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/karyawan";
    static final String USER = "root";
    static final String PASS = "";
    
    
    
    Connection koneksi;
    Statement statement;
    
    public ModKaryawan() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readContact(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][4]; 
            
            String query = "SELECT * FROM karyawan"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("usia"));                
                data[jmlData][2] = String.valueOf(resultSet.getDouble("gaji"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String nama, double usia , double gaji){
        int jmlData=0;
        
        
        try {
           String query = "SELECT * FROM karyawan WHERE nama='" + nama+"'"; 
           System.out.println(nama + " " + usia + " "  + gaji );
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO karyawan(nama,usia ,gaji) VALUES('"+nama+"','"+ usia +"','"+gaji+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String nama, int usia , double Gaji){
        int jmlData=0;
         try {
           String query = "SELECT * FROM karyawan WHERE nama='" + nama +"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE karyawan SET nama='" + nama + "', usia ='" + usia + "', gaji='"+ Gaji +"' WHERE nama='" + nama +"'" ;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM karyawan";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData (String nama) {
        try{
            String query = "DELETE FROM karyawan";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}