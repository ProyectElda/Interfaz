
package interfazgrafica;

import UpperEssential.UpperEssentialLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class InterfazGrafica {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        
        try{
            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\bakka\\Documents\\NetBeansProjects\\InterfazGrafica\\Librerias\\colores.theme"));
        }catch(Exception e){
            System.out.println("Error");
        }
        
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
    }

    
    
}
