package Helper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import model.User;

public class DBServiceImp extends UnicastRemoteObject implements DBService {
	
	private UserDAO userDAO;

	public DBServiceImp() throws RemoteException {
		super();
		userDAO = new UserDAO();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean login(User user) throws RemoteException, SQLException {
		return userDAO.login(user);
	}

	@Override
	public void signUp(User user) throws RemoteException, SQLException {
		userDAO.signUp(user);
	}

}
