package co.uptc.edu.negocio;

public enum UrgenciaEnum {
	
	 NIVEL1 (1 , "Resucitación", "Rojo", "Atención de forma inmediata"),
	 NIVEL2 (2, "Emergencia", "Naranja", "10 -15 Min"),
	 NIVEL3 (3, "Urgencia", "Amarillo", "60 Minutos"),
	 NIVEL4 (4, "Urgencia Menor", "Verde", "2 Horas"),
	 NIVEL5 (5, "Sin Urgencia", "Azul", "4 Horas");
	
	

	//Atributos
	
	private int nivel;
	private String descripcion;
	private String color;
	private String tiempoAtencion;
	
	
	// Constructor
	private UrgenciaEnum(int nivel, String descripcion, String color, String tiempoAtencion) {
		
		this.nivel = nivel;
		this.descripcion = descripcion;
		this.color = color;
		this.tiempoAtencion = tiempoAtencion;
	}

	
	// Getters 

	public int getNivel() {
		return nivel;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getColor() {
		return color;
	}


	public String getTiempoAtencion() {
		return tiempoAtencion;
	}

	
	// Metodo para obtener descripcion completa ( emergencia)
	public String getDescripcionCompleta() {
		return this.descripcion + " - " + this.color;
	}

	//Metodo estatico para obtener ENUM
	
	public static UrgenciaEnum obtenerPorNivel(int nivel) {
        for (UrgenciaEnum urgencia : UrgenciaEnum.values()) {
            if (urgencia.getNivel() == nivel) {
                return urgencia;
            }
        }
        return null;
    }
	
}
