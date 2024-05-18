package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class ControllerPCHException extends PCHException {

	private static final long serialVersionUID = -1179319726524825522L;

	public ControllerPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CONTROLLER);

	}
	
	public ControllerPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
	}
	
	public ControllerPCHException(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.CONTROLLER,excepcionRaiz);

	}
	

}
