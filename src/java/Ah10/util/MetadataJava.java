/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ah10.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class MetadataJava {
        Connection conn = null;
	ResultSet rs = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MetadataJava md = new MetadataJava();
		md.GetMetaData("Fpg_Importaponto_Ahgora");

	}
	
	public MetadataJava() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	public void GetMetaData(String tabela) throws Exception{
		try {
			boolean fazer = true;
			DatabaseMetaData metadata = conn.getMetaData();
		    ResultSet resultSet = null;
		    resultSet = metadata.getColumns(null, null, tabela.toLowerCase(), null);
//		    resultSet = metadata.getPrimaryKeys(null, null, "adm_ativo");
		    while (resultSet.next()) {
		    	fazer = false;
		    	String name = resultSet.getString("COLUMN_NAME");
		    	String type = resultSet.getString("TYPE_NAME");
		    	
		    	if(resultSet.isFirst() ){
		    		System.out.println("public class "+tabela+"VO implements Serializable{\n");
		    		if (!tabela.toLowerCase().contains("view")){
			    		System.out.println("@Sequence");
			    		System.out.println("String " + tabela.toLowerCase()+"_"+name+";\n\n");
			    		System.out.println("@PrimaryKey");
		    		}
		    	}
				if (tabela.toLowerCase().contains("view")) {
					System.out.println("@Select");
				} else {
					System.out.println("@Select	@Insert	@Update	@Delete");
				}
				System.out.println(TrocaType(type)+" "+ name+";");
				
				if(resultSet.isLast()){
					System.out.println("}");
				}
		    }
		    resultSet.close();
		   if (fazer){
			   resultSet = metadata.getProcedureColumns(null, null, tabela.toLowerCase(), null);
			   while (resultSet.next()) {
			    	String name = resultSet.getString("COLUMN_NAME");
			    	String type = resultSet.getString("TYPE_NAME");
			    	if(resultSet.isFirst() ){
			    		System.out.println("public class "+tabela+"VO implements Serializable{\n");
			    	}	
			    	
					System.out.println("@Select");
					System.out.println(TrocaType(type)+" "+ name+";");
					
					if(resultSet.isLast()){
						System.out.println("}");
					}
			    }
		   }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String TrocaType(String tipo){
		String retorno = "";
		if (tipo.equals("int4")||tipo.equals("int2")||tipo.equals("serial")||tipo.equals("int8")||tipo.equals("bigserial")){
			retorno = "Integer";
		} else if (tipo.equals("varchar")||tipo.equals("bpchar")||tipo.equals("text")){
			retorno = "String";
		} else if (tipo.equals("timestamp")||tipo.equals("date")){
			retorno = "Timestamp";
		} else if (tipo.equals("float8")){
			retorno = "Double";
		} else if (tipo.equals("bytea")){
			retorno = "byte[]";
		} else {
			retorno = tipo;
		}

		
		
		return retorno;
	}

}
