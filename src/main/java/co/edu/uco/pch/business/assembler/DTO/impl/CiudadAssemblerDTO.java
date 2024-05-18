package co.edu.uco.pch.business.assembler.DTO.impl;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;



public class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = new CiudadAssemblerDTO();
	
	
	private CiudadAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}
	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		var ciudadDTOTmp = getObjectHelper().getDefaultValue(data, CiudadDTO.build());
		var departamentoDomain = departamentoAssembler.toDomain(ciudadDTOTmp.getDepartamento());
		return CiudadDomain.build(ciudadDTOTmp.getId(),ciudadDTOTmp.getNombre(),departamentoDomain);
	}

	@Override
	public CiudadDTO toDTO(CiudadDomain domain) {
		var ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		var departamentoDTO = departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento());
		return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDTO);
	}
	
	

}
