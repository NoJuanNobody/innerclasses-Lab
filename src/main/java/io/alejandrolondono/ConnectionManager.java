package io.alejandrolondono;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/18/16.
 */
public class ConnectionManager{

    ArrayList<ManagedConnection> connections;

    public ManagedConnection makeManagedConnection(String ip, String port, Protocol protocol){

        return new ManagedConnection(ip, port, protocol);

    }

    public class ManagedConnection implements Connection  {
        private String ip;
        private String port;
        private Protocol protocolType;
        private boolean status;

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String connect() {

            return "connected";
        }

        public String close(){
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append(ip).append(", ").append(port).append(", ").append(protocolType);
            msgBuilder.append(" Has been closed");
            ip = null;
            port = null;
            protocolType = null;
            status = false;
            return msgBuilder.toString();
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public void setProtocol(Protocol protocolType) {
            this.protocolType = protocolType;
        }

        public String getPort() {
            return port;
        }

        public String getIp() {
            return ip;
        }

        public Protocol getProtocol() {
            return protocolType;
        }

        public ManagedConnection(String ip, String port, Protocol protocolType){
            setIp(ip);
            setPort(port);
            setProtocol(protocolType);
            status = true;
        }
    }

    private int maxConnections = 10;

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public ArrayList<ManagedConnection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<ManagedConnection> connections) {
        this.connections = connections;
    }

    public String addConnection(ManagedConnection connection){
       return limitConnections(connection);
    }

    public ManagedConnection getConnection(String ip, Protocol protocol){
        ManagedConnection rescon = null;
        for(ManagedConnection connection : getConnections()){
            if(connection.getIp() == ip && connection.getProtocol() == protocol) rescon = connection;
        }
        return rescon;
    }

    public ManagedConnection getConnection(String ip, String port){
        ManagedConnection rescon = null;
        for(ManagedConnection connection : getConnections()){
            if(connection.getIp() == ip && connection.getPort() == port) rescon = connection;
        }
        return rescon;
    }

    private String limitConnections(ManagedConnection connection){
        String msg = null;
        if(getConnections().size() < maxConnections) {
            getConnections().add(connection);
            msg =  connection.connect();
        }
        return msg;
    }
}
