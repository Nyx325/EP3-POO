package Modelo.Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Connector {
    Connection conection = null; // Objeto que maneja la conexión
    Statement stmt = null; // Objeto donde colocaremos nuestras querys
    PreparedStatement pStmt = null;
    ResultSet resSet = null; // Objeto que almacena las respuestas de las querys en caso de haber

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String servidor = "jdbc:mysql://localhost:3306/practica1?characterEncoding=UTF-8";
        String usr = "rubenor";
        String pwd = "archsudoloco";
        this.conection = DriverManager.getConnection(servidor, usr, pwd);

        return this.conection;
    }
}
