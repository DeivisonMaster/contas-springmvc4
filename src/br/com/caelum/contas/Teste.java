package br.com.caelum.contas;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = new ConnectionFactory().getConnection();
		
		boolean verifica = conexao.isClosed() ? true : false;
		System.out.println(verifica);
	}
}
