
package interfazgrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



public class MySQL {
    private static Connection Conexion;
    private String dbuser = "admin";
    private String dbpass = "123";
    private String dbname = "rutas";
    
   public Optional<ButtonType> Question(String Title, String Encabezado, String msj ){
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle(Title);
       alert.setHeaderText(Encabezado);
       alert.setContentText(msj);
       return alert.showAndWait();
   }
    
    public void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
                Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, dbuser, dbpass);
                System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    
    public void Alerta (String titulo, String Encabezado, String msje){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle(titulo);
           alert.setHeaderText(Encabezado);
           alert.setContentText(msje);
           alert.showAndWait();
    }
    
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //METODOS PARA LAS CONSULTAS DE LAS BASES DE DATOS
//=============================================================================================================    
  
    /*
        TODO LO RELACIONADO CON LAS UNIDADES
    */

  public ArrayList<unidad> traerUnidades(){
            ArrayList<unidad> unidades = new ArrayList();
             try{
             String q = "select *  from unidad ";
             Statement st = Conexion.createStatement();
             ResultSet rs = st.executeQuery(q);
             unidad ins;
             int i=0;
             while (rs.next()){
                 ins = new unidad();
                 ins.setIdUnidad(rs.getString("idUnidad"));
                 ins.setIdOperador(rs.getInt("idOperador"));
                 ins.setIdRuta(rs.getInt("idRuta"));
    
                 unidades.add(ins);
                 ins = null;   
            }     
         } catch (Exception p){
             
         }
        return unidades;
   }
  
  public ArrayList<registroUnidades> traerRegistros(){
            ArrayList<registroUnidades> registros = new ArrayList();
             try{
             String q = "select *  from registroUnidades ";
             Statement st = Conexion.createStatement();
             ResultSet rs = st.executeQuery(q);
             registroUnidades reg;
             int i=0;
             while (rs.next()){
                 reg = new registroUnidades();
                 reg.setFecha(rs.getString("fecha"));
                 reg.setIdUnidad(rs.getString("idUnidad"));
                 reg.setIdOperador(rs.getInt("idOperador"));
                 reg.setUltima_parada(rs.getString("ultima_parada"));
                 reg.setHora_ultima(rs.getString("hora_ultima"));
                 reg.setPenultima_parada(rs.getString("penultima_parada"));
                 reg.setHora_penultima(rs.getString("hora_penultima"));
                 reg.setTiempo_transcurrido(rs.getString("tiempo_transcurrido"));
                 reg.setPromedio_tiempo_transcurrido(rs.getString("promedio_tiempo_transcurrido"));
                 reg.setDiferencia(rs.getString("diferencia"));
                 registros.add(reg);
                 reg = null;   
            }     
         } catch (Exception p){
             
         }
        return registros;
   }
  
   
    public Boolean nuevoInstituto(int CveIns, String nombre, int CveHotel){
        try {
            this.Conectar();
            String query = "INSERT INTO Instituciones "
                    + "(CveIns, Nombre, CveHotel) "
                    + "values(?, ?, ?)";
            PreparedStatement st = Conexion.prepareStatement(query);
            
            st.setInt   (1, CveIns);
            st.setString(2, nombre);
            st.setInt   (3, CveHotel);
            st.execute();
           this.closeConnection();
            return true;
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       public Boolean eliminarInstituto(int CveIns){
        try{
            this.Conectar();
            String query = "delete from Instituciones  where CveIns = ?";
            PreparedStatement st = Conexion.prepareStatement(query);
            st.setInt(1, CveIns);
            st.execute();
            this.closeConnection();           
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
     public boolean actualizarInstituto(int CveIns, String nombre, int CveHotel){
        try{
            String query = "update instituciones "
                            + "set CveIns = ?, Nombre = ?, CveHotel = ?"
                                + " where CveIns = ?";
            PreparedStatement st = Conexion.prepareStatement(query);

            st.setInt   (1, CveIns);
            st.setString(2, nombre);
            st.setInt   (3, CveHotel);
            st.setInt   (4, CveIns);
            st.execute();
            
            return true;
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}