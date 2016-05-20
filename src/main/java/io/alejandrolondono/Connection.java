package io.alejandrolondono;

/**
 * Created by alejandrolondono on 5/18/16.
 */
public interface Connection {

    String close();

    String connect();

    void setIp(String ip);

    void setPort(String port);

    void setProtocol(Protocol protocol);

    String getIp();

    String getPort();

    Protocol getProtocol();

}
