
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farley_reis
 */
public class MACHINELOCATION {

	private int codigo      = 0;
	private String address = null;
	private String city   = null;

	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getaddress() {
		return address;
	}
	public void setaddress(String endereco) {
		this.address = endereco;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String cidade) {
		this.city = cidade;
	}



	
	public static ArrayList<MACHINELOCATION> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<MACHINELOCATION> agencias = new ArrayList<MACHINELOCATION>();
    
        try {
            
        	String sql = "SELECT * FROM Machines ORDER BY codigo DESC";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	MACHINELOCATION agencia = new MACHINELOCATION();
            	agencia.setCodigo(rs.getInt("codigo"));
            	agencia.setaddress(rs.getString("address"));
            	agencia.setaddress(rs.getString("city"));


            	
            	agencias.add(agencia);
            }            

            rs.close();            
            return agencias;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return agencias;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }		
	}
	
}