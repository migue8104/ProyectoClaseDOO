package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.exceptions.customs.DataPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

public class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO{
	
	public DepartamentoAzureSqlDAO(final Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public List<DepartamentoEntity> consultar(final DepartamentoEntity data) {
		    final StringBuilder sentenciaSql = new StringBuilder();
		    sentenciaSql.append("SELECT id, nombre, pais FROM Departamento WHERE 1=1");

		    if (!ObjectHelper.getObjectHelper().isNull(data.getId())) {
		        sentenciaSql.append(" AND id = ?");
		    }
		    if (!TextHelper.isNullOrEmpty(data.getNombre())) {
		        sentenciaSql.append(" AND nombre = ?");
		    }
		    if (data.getPais() != null && !ObjectHelper.getObjectHelper().isNull(data.getPais().getId())) {
		        sentenciaSql.append(" AND pais = ?");
		    }

		    final List<DepartamentoEntity> departamentos = new ArrayList<>();

		    try (final PreparedStatement sentenciaSqlPreparada = getConexion()
		            .prepareStatement(sentenciaSql.toString())) {

		        int index = 1;

		        if (!ObjectHelper.getObjectHelper().isNull(data.getId())) {
		            sentenciaSqlPreparada.setObject(index++, data.getId());
		        }
		        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
		            sentenciaSqlPreparada.setString(index++, data.getNombre());
		        }
		        if (data.getPais() != null && !ObjectHelper.getObjectHelper().isNull(data.getPais().getId())) {
		            sentenciaSqlPreparada.setObject(index++, data.getPais().getId());
		        }

		        try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
		            while (resultado.next()) {
		                DepartamentoEntity departamento = new DepartamentoEntity();
		                departamento.setId((UUID) resultado.getObject("id"));
		                departamento.setNombre(resultado.getString("nombre"));
		                // Asignar el país si se está seleccionando en la consulta
		                PaisEntity pais = new PaisEntity();
		                pais.setId((UUID) resultado.getObject("pais"));
		                departamento.setPais(pais);
		                departamentos.add(departamento);
		            }
		        }

		    } catch (final SQLException excepcion) {
		        var mensajeUsuario =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052) ;
		        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);

		        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

		    } catch (final Exception excepcion) {
		        var mensajeUsuario =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);
		        var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);

		        throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
		    }

		    return departamentos;
		}
}