package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import Helper.DBServiceImp;

public class Server {

	public static void main(String[] args) {
		String serviceName = "rmi://localhost:6789/test";
		DBServiceImp service;
		try {
			LocateRegistry.createRegistry(6789);
			service = new DBServiceImp();
			Naming.bind(serviceName, service);
			System.out.println("Service is running");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
