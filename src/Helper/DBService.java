package Helper;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import model.User;

public interface DBService extends Remote {
	
	boolean login(User user) throws RemoteException, SQLException;
	void signUp(User user) throws RemoteException, SQLException;
}
