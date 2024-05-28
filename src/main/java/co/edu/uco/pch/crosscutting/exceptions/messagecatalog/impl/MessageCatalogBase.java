package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MessageCatalog {
	
	private final Map<String,Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
 
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00023.getIdentificador(),new Mensaje(CodigoMensaje.M00023,
				"se ha presentado un prblema tratando de crear la ciudad \"${1}\" y si el problemas contacte a el administrador ..." ));
		mensajes.put(CodigoMensaje.M00024.getIdentificador(),new Mensaje(CodigoMensaje.M00024,
				"Se ha presentado una excepcion se tipo SQLexception tatando de realizar el insert de la ciudad \"${1}\" en la tabla pais"
						+ "de la base de datos azureSql.para mas detalles revise de forma completa la excepcionRaiz presentada "));		
		mensajes.put(CodigoMensaje.M00025.getIdentificador(),new Mensaje(CodigoMensaje.M00025,
				"se ha presentado un error tratando de consultar la informacion de una ciudad"));
		mensajes.put(CodigoMensaje.M00026.getIdentificador(),new Mensaje(CodigoMensaje.M00026,
				"problema inesperado tratando de consultar la ciudad "));
		mensajes.put(CodigoMensaje.M00027.getIdentificador(),new Mensaje(CodigoMensaje.M00027,
				"Se ha presentado un problema registrando la informacion de la ciudad"));
		mensajes.put(CodigoMensaje.M00028.getIdentificador(),new Mensaje(CodigoMensaje.M00028,
				"Se ha presentado un problema INESPERADO tratando de registrar la ciudad"));
		mensajes.put(CodigoMensaje.M00029.getIdentificador(),new Mensaje(CodigoMensaje.M00029,
				"el DAOfactoty para consultar las ciudades llego nulo..."));
		mensajes.put(CodigoMensaje.M00030.getIdentificador(),new Mensaje(CodigoMensaje.M00030,
				"el DAOfactoty para creear la ciudad llego nulo..."));
		mensajes.put(CodigoMensaje.M00031.getIdentificador(),new Mensaje(CodigoMensaje.M00031,
				"ciudades consultadas exitosamente"));
		mensajes.put(CodigoMensaje.M00032.getIdentificador(),new Mensaje(CodigoMensaje.M00032,
				"ya existe una ciudad con el nombre \"${1}\"asociado al departamento"));
		mensajes.put(CodigoMensaje.M00033.getIdentificador(),new Mensaje(CodigoMensaje.M00033,
				"El nombre de la ciudad es obligatorio"));
		mensajes.put(CodigoMensaje.M00034.getIdentificador(),new Mensaje(CodigoMensaje.M00034,
				 "el ingreso de datos en el nombre de la ciudad esta nullo..."));
		mensajes.put(CodigoMensaje.M00035.getIdentificador(),new Mensaje(CodigoMensaje.M00035,
				"El departamento es obligatorio."));
		mensajes.put(CodigoMensaje.M00036.getIdentificador(),new Mensaje(CodigoMensaje.M00036,
				"El departamento llego nulo..."));
		mensajes.put(CodigoMensaje.M00037.getIdentificador(),new Mensaje(CodigoMensaje.M00037,
				"El nombre de la ciudad excede la longitud máxima permitida."));
		mensajes.put(CodigoMensaje.M00038.getIdentificador(),new Mensaje(CodigoMensaje.M00038,
				 "la longitud permitida en el nombre esta siendo excedida"));
		mensajes.put(CodigoMensaje.M00039.getIdentificador(),new Mensaje(CodigoMensaje.M00039,
				"El formato del nombre de la ciudad es incorrecto."));
		mensajes.put(CodigoMensaje.M00040.getIdentificador(),new Mensaje(CodigoMensaje.M00040,
				"formato del nombre de la ciudad no es valido"));
		mensajes.put(CodigoMensaje.M00041.getIdentificador(),new Mensaje(CodigoMensaje.M00041,
				"ciudades creada exitosamente"));
		mensajes.put(CodigoMensaje.M00042.getIdentificador(),new Mensaje(CodigoMensaje.M00042,
				"ciudades eliminadas exitosamente"));
		mensajes.put(CodigoMensaje.M00043.getIdentificador(),new Mensaje(CodigoMensaje.M00043,
				"se ha presentado un problema tratando de eliminar la nueva ciudad"));
		mensajes.put(CodigoMensaje.M00044.getIdentificador(),new Mensaje(CodigoMensaje.M00044,
				"ciudades modificadas exitosamente"));
		mensajes.put(CodigoMensaje.M00045.getIdentificador(),new Mensaje(CodigoMensaje.M00045,
				"se ha presentado un problema tratando de modificar la nueva ciudad"));
		mensajes.put(CodigoMensaje.M00046.getIdentificador(),new Mensaje(CodigoMensaje.M00046,
				"No es posible crear el DAO deseado con una conexion cerrada"));
		mensajes.put(CodigoMensaje.M00047.getIdentificador(),new Mensaje(CodigoMensaje.M00047,
				"Se ha presentado una excepcion se tipo SQLexception tatando de realizar el update de la ciudad \"${1}\" en la tabla pais"
						+ "de la base de datos azureSql.para mas detalles revise de forma completa la excepcionRaiz presentada "));
		mensajes.put(CodigoMensaje.M00048.getIdentificador(),new Mensaje(CodigoMensaje.M00048,
				"Se ha presentado una excepcion se tipo SQLexception tatando de realizar el delete de la ciudad \\\"${1}\\\" en la tabla pais\"\r\n"
						+ "					+ \"de la base de datos azureSql.para mas detalles revise de forma completa la excepcionRaiz presentada"));
		mensajes.put(CodigoMensaje.M00049.getIdentificador(),new Mensaje(CodigoMensaje.M00049,
				"Se ha presentado una SQLException tratando de realizar la consulta de las ciudades en la tabla \"Ciudad\" de la base de datos Azure SQL."));
		mensajes.put(CodigoMensaje.M00050.getIdentificador(),new Mensaje(CodigoMensaje.M00050,
				"Se ha presentado un problema tratando de consultar los países. Por favor, contacte al administrador del sistema."));
		mensajes.put(CodigoMensaje.M00051.getIdentificador(),new Mensaje(CodigoMensaje.M00051,
				"Se ha presentado una SQLException tratando de realizar la consulta de los países en la tabla \"Pais\" de la base de datos Azure SQL."));
		mensajes.put(CodigoMensaje.M00052.getIdentificador(),new Mensaje(CodigoMensaje.M00052,
				"Se ha presentado un problema tratando de consultar los departamentos. Por favor, contacte al administrador del sistema."));
		mensajes.put(CodigoMensaje.M00053.getIdentificador(),new Mensaje(CodigoMensaje.M00053,
				"Se ha presentado una SQLException tratando de realizar la consulta de los departamentos en la tabla \"Departamento\" de la base de datos Azure SQL."));
				
		
		
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
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004,codigo.getIdentificador());
			throw new  CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003,codigo.getIdentificador());
			throw new  CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
			
		}
		
		// TODO: tarea: asegure que si tiene parametros, el contenido del mensaje se retorne  con los parametros reemplazados 
		return mensajes.get(codigo.getIdentificador());
	}

	

}
