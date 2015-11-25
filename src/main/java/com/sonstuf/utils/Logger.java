package com.sonstuf.utils;

/**
 * Semplice classe che offre metodi helper per stampe di debug
 * LOG_LEVEL = 	0 Nessun messaggio
 * 				1 Messaggi di log
 * 				2 Messaggi di debug
 * @author hypertesto
 */
public class Logger {

	private static int LOG_LEVEL = 0;

	/**
	 * Stampa un messaggio a log level >= 1
	 * @param message
	 */
	public static void log ( String message ){

		if ( LOG_LEVEL >= 1 ) {

			System.out.println("[LOG] +" + message );

		}

	}

	/**
	 * Stampa un messaggio di debug a log level >= 2
	 * @param message
	 */
	public static void debug ( String message ){

		if ( LOG_LEVEL >= 2 ){

			System.out.println("[DEBUG] " + message );

		}

	}

}
