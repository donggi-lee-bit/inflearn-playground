package tobyspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;

public class ServerProperties {

    @Value("${contextPath:}")
    private String contextPath;

    @Value("${port:9091}")
    private int port;


    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
