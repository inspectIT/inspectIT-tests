package test.info.novatec.inspectit.sql.tools;

import java.sql.Connection;
import java.util.Random;

/**
 * Factory to easily create a mocked database connection to different "servers".
 * 
 * @author Alfred Kraus
 */
public class ConnectionFactory {
	public enum ConnectionType {
		H2_local_123, H2_remote_234;
	}
	
	public static Connection getConnection (ConnectionType type) {
		if (type.equals(ConnectionType.H2_local_123)) {
			return new ConnectionMock (DatabaseMetaDataMock.h2DvdStorePathVersion123);
		} else if (type.equals(ConnectionType.H2_remote_234)) {
			return new ConnectionMock (DatabaseMetaDataMock.h2DvdStoreRemoteVersion234);
		} else {
			throw new RuntimeException ("not implemented");
		}
	}
	
	public static Connection getRandom() {
		int index = new Random().nextInt(ConnectionType.values().length);
		return getConnection (ConnectionType.values()[index]);
	}
	
	public static Connection[] getAllAvailableConnections() {
		Connection[] connections = new Connection[ConnectionType.values().length];
		int i = 0;
		for (ConnectionType type : ConnectionType.values()) {
			connections[i++] = getConnection(type);
		}
		return connections;
	}
}
