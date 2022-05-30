/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPraktikumPBO;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Agil
 */
public class Cont {
    ModKaryawan modContact;
    ViewKaryawan ViewKaryawan;
    public String data;
    public Cont(ModKaryawan modContact, ViewKaryawan ViewKaryawan){
        this.modContact = modContact;
        this.ViewKaryawan = ViewKaryawan;
        
        if (modContact.getBanyakData()!=0) {
            String dataKaryawan[][] = modContact.readContact();
            ViewKaryawan.tabel.setModel((new JTable(dataKaryawan, ViewKaryawan.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         ViewKaryawan.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = ViewKaryawan.getNama();
                int usia = ViewKaryawan.getUsia();
                double gaji = ViewKaryawan.getGaji();
                int lembur = ViewKaryawan.getLembur();
                double ToGaji = gaji +(lembur*25000);
                modContact.insertData(nama,usia, gaji);
         
                String dataKaryawan[][] = modContact.readContact();
                ViewKaryawan.tabel.setModel((new JTable(dataKaryawan, ViewKaryawan.namaKolom)).getModel());
            }
        });
         
          ViewKaryawan.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                String nama = ViewKaryawan.getNama();
                int usia = ViewKaryawan.getUsia();
                double gaji = ViewKaryawan.getGaji();
                int lembur = ViewKaryawan.getLembur();
                double ToGaji = gaji +(lembur*25000);
                modContact.updateData(nama,usia, gaji);
                
                String dataKaryawan[][] = modContact.readContact();
                ViewKaryawan.tabel.setModel((new JTable(dataKaryawan, ViewKaryawan.namaKolom)).getModel());
            }
        });
         
          ViewKaryawan.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                ViewKaryawan.tfNama.setText("");
                ViewKaryawan.tfUsia.setText("");
                ViewKaryawan.tfGaji.setText("");
                ViewKaryawan.tfLembur.setText("");
            }
        });
        
    
          ViewKaryawan.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = ViewKaryawan.tabel.getSelectedRow();
                data = ViewKaryawan.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[3];
                dataUpdate[0] = ViewKaryawan.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = ViewKaryawan.tabel.getValueAt(baris, 1).toString();
                
                
                System.out.println(data);  
            }
           });
                  
          ViewKaryawan.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String nama = ViewKaryawan.getNama();
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus nama " + nama + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modContact.deleteData(data);
                String dataKaryawan[][] = modContact.readContact();
                ViewKaryawan.tabel.setModel((new JTable(dataKaryawan, ViewKaryawan.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}