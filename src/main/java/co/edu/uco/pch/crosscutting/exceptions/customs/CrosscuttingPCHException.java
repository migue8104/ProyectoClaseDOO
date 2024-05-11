package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;

	public CrosscuttingPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CROSSCUTTING);
	}
	
	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING);
	}


	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING, exeptionRaiz);
	}

}
