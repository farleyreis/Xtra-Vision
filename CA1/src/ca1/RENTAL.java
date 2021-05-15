/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farley_reis
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.Statement;

public class RENTAL {

	private int idRental         = 0;
	private String dateRented  = null;
	private String dateReturn = null;
	private long idCliente              = 0;
	private int machine_id        = 0;
	private int payment_id      = 0;
	private String status         = null;
	

	
	public int getidRental() {
		return idRental;
	}
	public void setidRental(int idRental) {
		this.idRental = idRental;
	}
	public String getdateRented() {
		return dateRented;
	}
	public void setdateRented(String dateRented) {
		this.dateRented = dateRented;
	}
	public String getdateReturn() {
		return dateReturn;
	}
	public void setdateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}
	public long getCpf() {
		return idCliente;
	}
	public void setidCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public int getmachine_id() {
		return machine_id;
	}
	public void setmachine_id(int machine_id) {
		this.machine_id = machine_id;
	}
	public int getpayment_id() {
		return payment_id;
	}
	public void setpayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	
	

	public static ArrayList<RENTAL> getArrObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
		ArrayList<RENTAL> locacoes = new ArrayList<RENTAL>();
		
		try {
            
        	String sql = "SELECT * FROM RentedMovies ORDER BY id DESC";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	RENTAL renteed = new RENTAL();
            	renteed.setidRental(rs.getInt("idRental"));
            	renteed.setdateRented(rs.getString("dateRented"));
            	renteed.setdateReturn(rs.getString("dateReturn"));
            	renteed.setidCliente(rs.getLong("idCliente"));
            	renteed.setmachine_id(rs.getInt("machine_id"));
            	renteed.setpayment_id(rs.getInt("payment_id"));
     
               	
                

        
            	locacoes.add(renteed);
            }            

            rs.close();            
            return locacoes;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return locacoes;
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
	
	public boolean inserirItem(int idRentalitem) {

		PreparedStatement stm = null;
        Connection conn = null;
        
        try {

     

        	String sqlInsert = "INSERT INTO RentedMovies "
        			+ "(idRental, dateRented, dateReturn, idCliente, machine_id, payment_id ) "
        			+ "VALUES (?, ?, ?, ?, ?, ?)";

            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    	
    		stm.setInt(1, getidRental());
    		stm.setInt(2, idRentalitem);
    		stm.execute();
    		
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return false;
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
	
	
	public boolean inserir() {

        PreparedStatement stm = null;
        Connection conn = null;
        
        try {

        	String sqlInsert = "INSERT INTO RentedMovies "
        			+ "(idRental, dateRented, dateReturn, idCliente, machine_id, payment_id ) "
        			+ "VALUES (?, ?, ?, ?, ?, ?)";


            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
    		
    		stm.setString(1, getdateRented());
    		stm.setString(2, getdateReturn());
    		stm.setLong(  3, getCpf());
    		stm.setInt(   4, getmachine_id());
    		stm.setInt(   5, getpayment_id());
    		stm.execute();
            
                
          
    		ResultSet rs = stm.getGeneratedKeys();
    		if (rs.next()) {
    			setidRental(rs.getInt(1));
    		}
    		return true;
            
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return false;
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
	
	
		

	public static boolean checar(long cpf) {
	
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
    
        try {

            
        	String sql = "SELECT * FROM RentedMoveis WHERE idRental = ? && status = ?";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            stm.setLong(1, cpf);
            stm.setString(2, "rented");
            
            rs = stm.executeQuery();
            
            
            if (rs.next()) {
            	rs.close();
            	return true;
            }            

            rs.close();            
            return false;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return false;
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
	
	public boolean editarIdPagamento() {
		
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE RentedMovies SET "
	    			+ "paymento_id = ? "
	    			+ "WHERE idRental = ?";
			
			DBASE bd = new DBASE();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

			stm.setInt(1, getpayment_id());
			stm.setInt(2, getidRental());
			stm.execute();

			return true;

		} catch (Exception e) {
			
			System.out.print(e.getMessage());
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	
	public boolean editarStatus() {
		
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
		
			String sqlUpdate = "UPDATE RentedMovies SET "
	    			+ "paymento_id = ? "
	    			+ "WHERE idRental = ?";
			
			DBASE bd = new DBASE();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);

    		stm.setString(1, getstatus());
    		stm.setLong(  2, getCpf());   
    		stm.setString(3, "rented");
    		stm.execute();
    		
			return true;

		} catch (Exception e) {
			
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}

	
}
