/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class Database {
  private static String
	host = "jdbc:postgresql://localhost:5573/ctpp",
//	host = "jdbc:postgresql://189.74.31.178:5573/ctpp",
//	host = "jdbc:postgresql://10.1.1.50:5573/ctpp",
	user = "postgres",
	password = "123", 
	classe = "org.postgresql.Driver";


  private static Connection conn = null;

  /**
   * metodo criado para testar conexao...
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Database db = new Database();

    try {
      db.getConnection();
      System.out.println("Conexao Ok....");
    } catch (Exception exception) {
      System.out.println("Conexao Falhou...");
      exception.printStackTrace();
    }
  }

  /**
   * Faz a conexao com o banco de dados.
   */
  private static Connection createConnection() throws Exception {
      Class.forName(classe).newInstance();
      Connection c = DriverManager.getConnection(host, user, password);

//System.out.println("Conexao.....: " + host);
      return c;
  }

  /**
   * Passa para a classe os valores necessarios para uma conexao com o Banco de Dados.
   */
  public static void setDatabase(String sHost, String sUser, String sPassword, String sClasse) {
    host = sHost;
    user = sUser;
    password = sPassword;
    classe = sClasse;
  }

  /*
   * Retorna a conexao com o Banco de Dados.
   */
  public static Connection getConnection() throws Exception {
    if ( conn == null ) {
        conn = createConnection();
    }
    return conn;
  }

  /**
   * Fecha a conexao com o Banco de Dados.
   */
  public static void closeConnection() throws SQLException {
    if ( conn != null && !conn.isClosed() ) {
      conn.close();
      conn = null;
    }
  }

}
