package io.alejandrolondono;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by alejandrolondono on 5/20/16.
 */
public class ConnectionManagerSpec {

    ConnectionManager conManager;

    ArrayList<ConnectionManager.ManagedConnection> connections= new ArrayList<ConnectionManager.ManagedConnection>();
    String ip;
    @Before
    public void sandbox(){
        conManager = new ConnectionManager();
        ConnectionManager.ManagedConnection connection = conManager.makeManagedConnection("50.73.209.90", "600-1023", Protocol.HTTP);
        ip=connection.getIp();
        connections.add(connection);
        conManager.setConnections(connections);
    }

    @Test
    public void getSingleConnectionTest(){
        String actualIp =  conManager.getConnection(ip, Protocol.HTTP).getIp();
        assertEquals("the ip's should be the same", ip, actualIp);
    }

    @Test
    public void addConnectionTest(){
        ConnectionManager.ManagedConnection secondConnection = conManager.makeManagedConnection("the ip", "theport", Protocol.FTP);
        conManager.addConnection(secondConnection);
        int actualSize = conManager.getConnections().size();
        int expectedSize = 2;
        assertEquals("should be the same size", expectedSize, actualSize);
    }

    @Test
    public void limitconnectionsTest(){
        conManager.setMaxConnections(1);
        ConnectionManager.ManagedConnection secondConnection = conManager.makeManagedConnection("the ip", "theport", Protocol.FTP);
        String result = conManager.addConnection(secondConnection);
        assertNull("the result should be null", result);
    }

}
