package co.edu.uco.pch.business.assembler.entity.impl;


import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;

public class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {

	private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler =  PaisAssemblerEntity.getInstance();
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance =
			new DepartamentoAssemblerEntity();
	private DepartamentoAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}
	@Override
	public DepartamentoDomain toDomain(DepartamentoEntity data) {
		var departamemtoEntityTmp = getObjectHelper().getDefaultValue(data, DepartamentoEntity.build());
		var paisDomain = paisAssembler.toDomain(departamemtoEntityTmp.getPais());
		return DepartamentoDomain.build(departamemtoEntityTmp.getId(),departamemtoEntityTmp.getNombre(),paisDomain);
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDomain domain) {
		var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
		return DepartamentoEntity.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre()).setPais(paisEntity);
	}
	
	

}
