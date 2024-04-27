package co.edu.uco.pch.crosscutting.exceptions;

import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public class InitializerPCHException extends RuntimeException{


	private static final long serialVersionUID = -1204292929766811976L;
	
	protected String mensajeUsuario;
	protected Lugar lugar;
	
	public InitializerPCHException(String mensajeTecnico,String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico,excepcionRaiz);
		setMensajeUsuario  (mensajeUsuario);
		setLugar (lugar);
	}
	
	public InitializerPCHException(final String mensajeUsuario,final Lugar lugar) {
		super(mensajeUsuario,new Exception());
		setMensajeUsuario  (mensajeUsuario);
		setLugar (lugar);
	}



	public static final long getSerialversionuid() {
		return serialVersionUID;
	}



	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}



	public final Lugar getLugar() {
		return lugar;
	}



	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}


	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);
	}
	
	

}
