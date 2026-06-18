package okkit.editor.data.dto;

import java.io.Serializable;

/**
 * Repräsentiert EINE (beliebige) Tabelle in der Datenbank.<br>
 * Jede Tabelle in der DB besitzt das Attribut id.<br>
 * Eine id bedeutet den Primary Key.<br>
 * Da JEDE Tabell eine id hat, hat auch jede Klasse zu der Tabelle<br>
 * ein Feld private int id; <br>
 * 
 * Diese Klasse ist die Superklasse für alle Klassen (Tabellen).
 * Da diese Klasse KEINER KONKRETEN Tabelle entspeicht, ist sie abstract.>br>
 * 
 * Ein Klasse beschreibt ein Objekt. <br>
 * Eine abstarkte Klasse beschreibt eine Klasse. <br>
 * Von einer abstrakten Klasse kan man NICHT eine Instanz erzeugen, d.h.<br>
 * new DataTransportObject() GEHT NICHT!!! 
 */
public abstract class DataAccessObject implements Serializable{

	public static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
