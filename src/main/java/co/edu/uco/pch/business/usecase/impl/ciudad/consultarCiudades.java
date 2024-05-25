package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithReturn;
import co.edu.uco.pch.crosscutting.exceptions.customs.BusinessPCHException;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public class consultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {
	
private DAOFactory factory;
	
	public consultarCiudades(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario= "se ha presentado un problema tratando de llevar a cabo la consulta de las ciudades";
			var mensajeTecnico = "el DAOfactoty para consultar las ciudades llego nulo...";
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
		}
		this.factory= factory;
	}

	@Override
	public List<CiudadDomain> execute(CiudadDomain data) {
		var ciudadEntityFilter = 
				CiudadAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getCiudadDAO().consultar(ciudadEntityFilter);
		
		var resultadosDomain = CiudadAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
		// TODO Auto-generated method stub
		return resultadosDomain;
	}

}
