package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {
	
	private final Map<String,Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(),
				new Mensaje(CodigoMensaje.M00001,"el codigo del emsaje que se quiere obtener del catalogo de mensajes llego nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(),
				new Mensaje(CodigoMensaje.M00002,"se a presentado un problema trantando de llevar acabo la operacion deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(),
				new Mensaje(CodigoMensaje.M00003,"el codigo de mensaje \"${1}\" que se intento obtener no esta en el catalogo de mensaje"));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(),
				new Mensaje(CodigoMensaje.M00004,"el codigo de mensaje \"${1}\" que se intento obtener no esta configurado para recibir en el catalogo de mensajes base"));
		
		
	}

	@Override
	public final String obtenerContenidoMensaje(CodigoMensaje codigo,final  String... parametros) {
		// TODO Auto-generated method stub
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo,final  String... parametros) {
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004,codigo.getIdentificador());
			throw new  co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003,codigo.getIdentificador());
			throw new  co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
			
		}
		
		// TODO: tarea: asegure que si tiene parametros, el contenido del mensaje se retorne  con los parametros reemplazados 
		return mensajes.get(codigo.getIdentificador());
	}



}
