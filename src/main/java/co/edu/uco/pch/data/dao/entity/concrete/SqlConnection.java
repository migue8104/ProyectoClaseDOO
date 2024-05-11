package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.pch.crosscutting.exceptions.customs.DataPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection conexion) {
		setConnection(conexion);
	}
	
	protected SqlConnection() {
		super();
	}

	protected final Connection getConnection() {
		return conexion;
	}

	protected final void setConnection(final Connection connection) {
		
		if(SQLHelper.isOpen(connection)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "no es posible crear el DAO deseado con una conexion cerrada ";
				
			throw new DataPCHException(mensajeTecnico, mensajeUsuario);
					
					
		}
		
		this.conexion = connection;
	}
	
	

}
