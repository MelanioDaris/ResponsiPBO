/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPraktikumPBO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agil
 */
public class ViewKaryawan extends JFrame{
    double total;
    JLabel lnama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia");
    JLabel lGaji = new JLabel("Gaji");
    JLabel lLembur = new JLabel("Lembur");
    
    
    
    public JTextField tfNama = new JTextField();
    public JTextField tfUsia = new JTextField();
    public JTextField tfGaji = new JTextField();
    public JTextField tfLembur = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Nama", "Usia", "Gaji","Total Gaji"};

    public ViewKaryawan() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Karyawan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lnama);
        lnama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);
        
        add(lUsia);
        lUsia.setBounds(510, 60, 90, 20);
        add(tfUsia);
        tfUsia.setBounds(510, 80, 120, 20);
        
        add(lGaji);
        lGaji.setBounds(510, 100, 90, 20);
        add(tfGaji);
        tfGaji.setBounds(510, 120, 120, 20);
        
        add(lLembur).setBounds(510,140,90,20);
        add(tfLembur).setBounds(510,160,120,20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 250, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 280, 90, 20);
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public int getUsia(){
        return Integer.parseInt(tfUsia.getText());
    }
    
    public double getGaji(){
        return Double.parseDouble(tfGaji.getText());
    }
    
    public int getLembur(){
        return Integer.parseInt(tfLembur.getText());
    }
    
}