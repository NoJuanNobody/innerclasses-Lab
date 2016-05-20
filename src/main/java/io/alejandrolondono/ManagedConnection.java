package io.alejandrolondono;

/**
 * Created by alejandrolondono on 5/18/16.
 */
//public class ManagedConnection implements Connection  {
//    private String ip;
//    private String port;
//    private Protocol protocolType;
//    private boolean status;
//
//    public boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public String connect() {
//
//        return "connected";
//    }
//
//    public String close(){
//        StringBuilder msgBuilder = new StringBuilder();
//        msgBuilder.append(ip).append(", ").append(port).append(", ").append(protocolType);
//        msgBuilder.append(" Has been closed");
//        ip = null;
//        port = null;
//        protocolType = null;
//        status = false;
//        return msgBuilder.toString();
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public void setPort(String port) {
//        this.port = port;
//    }
//
//    public void setProtocol(Protocol protocolType) {
//        this.protocolType = protocolType;
//    }
//
//    public String getPort() {
//        return port;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public Protocol getProtocol() {
//        return protocolType;
//    }
//
//    public ManagedConnection(String ip, String port, Protocol protocolType){
//        setIp(ip);
//        setPort(port);
//        setProtocol(protocolType);
//        status = true;
//    }
//}
