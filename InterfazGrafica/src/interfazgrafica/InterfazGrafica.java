
package interfazgrafica;

//import UpperEssential.UpperEssentialLookAndFeel;
import interfazgrafica.InicioSesion;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class InterfazGrafica {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        MySQL db = new MySQL();
        db.Conectar();
        /*
        try{
            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\bakka\\Documents\\NetBeansProjects\\InterfazGrafica\\Librerias\\coloress.theme"));
        }catch(Exception e){
            System.out.println("Error");
        }
*/
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
    }

    
    
}
