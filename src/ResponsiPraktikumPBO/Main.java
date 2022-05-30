/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResponsiPraktikumPBO;

/**
 *
 * @author Agil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewKaryawan view = new ViewKaryawan();
        ModKaryawan model = new ModKaryawan();
        Cont controller = new Cont(model, view);
    }
    
}
