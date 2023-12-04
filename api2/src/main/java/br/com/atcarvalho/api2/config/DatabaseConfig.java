package br.com.atcarvalho.api2.config;

import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;


public class DatabaseConfig {

//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public RSocketProperties.Server inMemoryH2DatabaseaServer() throws SQLException {
//        return Server.createTcpServer(
//                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
//    }
}
