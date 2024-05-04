package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DataPCHException extends PCHException {

	private static final long serialVersionUID = -1179319726524825522L;

	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);

	}
	public DataPCHException(final String mensajeTecnico,final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA);

	}
	
	public DataPCHException(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA,excepcionRaiz);

	}

}
