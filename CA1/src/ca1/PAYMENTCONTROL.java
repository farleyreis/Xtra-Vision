/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farley_reis
 */


//we thought hard about a way to make a payment system and we didn't find the solution for the payment method,
//so we just created the connection with the rent classes, 
//loginpayment and that would be to insert the card and make the payment

public class PAYMENTCONTROL {

	private RENTAL rental = null;

	
	

	

	public void setObjectLocacao(RENTAL locacao) {
		this.rental = rental;
	}	
	

	
	public static boolean inserirMoney(LOGINPAYMENT p) {
		p.inserirCheque();
		return true;
	}
	public static boolean inserirCard(LOGINPAYMENT p) {
		p.inserirCredito();
		return true;
	}

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
