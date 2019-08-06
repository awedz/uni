import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Map;

import com.mysql.cj.xdevapi.PreparableStatement;

import BL.SocketHandler;
import DAL.Sql;
import Enums.*;
import Message.LoginMessage;

public class Server {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket s = null;
		Sql sql = new Sql();
		try {
			s = new ServerSocket(10000);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		while (true) {
			Socket incoming = null;
			try {
				incoming = s.accept();
			} catch (IOException e) {
				System.out.println(e);
				continue;
			}
			new SocketHandler(incoming, sql).start();
		}

	}
}
