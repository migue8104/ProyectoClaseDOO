package co.edu.uco.pch.business.assembler.DTO.impl;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.PaisDTO;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO>{

	private final static AssemblerDTO<PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance(){
		return instance;
	}
	
	@Override
	public final  PaisDomain toDomain(PaisDTO data) {
		var paisDTOTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());
		return PaisDomain.build(data.getId(),paisDTOTmp.getNombre());
		// TODO Auto-generated method stub
	}

	@Override
	public PaisDTO toDTO(PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		// TODO Auto-generated method stub
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}
