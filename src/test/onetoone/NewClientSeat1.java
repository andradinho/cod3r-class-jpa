package test.onetoone;

import infra.DAO;
import model.onetoone.Client;
import model.onetoone.Seat;

public class NewClientSeat1 {

	public static void main(String[] args) {
		
		Seat seat = new Seat("2A");
		Client client = new Client("João", seat);
		
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction()
			.include(seat)
			.include(client)
			.closeTransaction()
			.close();
	}
}
