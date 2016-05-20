package io.alejandrolondono;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alejandrolondono on 5/20/16.
 */
public class ManagedConnectionSpec {
    ConnectionManager conManager;
    ConnectionManager.ManagedConnection connection;

    @Before
    public void Sandbox(){
        conManager = new ConnectionManager();
        connection = conManager.makeManagedConnection("50.73.209.90", "600-1023", Protocol.HTTP);
    }

    @Test
    public void CloseTest(){
        connection.close();
        assertNull("connection variable should be closed afterwards", connection.getIp());
        assertNull("connection variable should be closed afterwards", connection.getPort());
        assertNull("connection variable should be closed afterwards", connection.getProtocol());
        assertFalse("status should be closed or false", connection.getStatus());

    }

    @Test
    public void ConnectionTest(){
        assertEquals("they should be equal", "connected", connection.connect());
    }

}
