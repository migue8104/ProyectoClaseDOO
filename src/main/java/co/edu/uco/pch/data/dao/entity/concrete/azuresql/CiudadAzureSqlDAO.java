package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.exceptions.customs.DataPCHException;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.CiudadEntity;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO{

	public CiudadAzureSqlDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public final void crear(final CiudadEntity data) {
		final StringBuilder sentenciaSQL = new StringBuilder();
		
		sentenciaSQL.append("INSERT INTO Ciudad(id,nombre,departamento)");
		sentenciaSQL.append("SELECT ?,?,?");
	
		
		try (final PreparedStatement sentenciaSQLPreparada = getConnection().prepareStatement(sentenciaSQL.toString())){
			sentenciaSQLPreparada.setObject(1,data.getId() );
			sentenciaSQLPreparada.setString(2, data.getNombre());
			sentenciaSQLPreparada.setObject(3, data.getId());
			
			sentenciaSQLPreparada.executeUpdate();
			
		}catch (final SQLException excepcion) {
			var mensajeUsuario = "se ha presentado un prblema tratando de crear la ciudad \"${1}\" y si el problemas contacte a el administrador ...";
			var mensajeTecnico = "Se ha presentado una excepcion se tipo SQLexception tatando de realizar el insert de la ciudad \"${1}\" en la tabla pais"
					+ "de la base de datos azureSql.para mas detalles revise de forma completa la excepcionRaiz presentada ";
			throw new DataPCHException(mensajeTecnico, mensajeUsuario,excepcion);
			
		}catch (final Exception excepcion) {
			var mensajeUsuario = "se ha presentado un prblema tratando de crear la ciudad \"${1}\" y si el problemas contacte a el administrador ...";
			var mensajeTecnico = "Se ha presentado una excepcion se tipo SQLexception tatando de realizar el insert de la ciudad \"${1}\" en la tabla pais"
					+ "de la base de datos azureSql.para mas detalles revise de forma completa la excepcionRaiz presentada ";
			throw new DataPCHException(mensajeTecnico, mensajeUsuario,excepcion);
		}
		
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}
	

}
