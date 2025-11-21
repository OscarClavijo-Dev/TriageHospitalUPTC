package co.uptc.edu.negocio;

public enum TipoDocumentoEnum {

	CC("Cedula Ciudadania"),
	TI("Tarjeta Identidad"),
	RC("Registro Civil"),
	PA("Pasaporte"),
	CE("Cedula Extranjeria");
	
private String nombreLargo;
	
	private TipoDocumentoEnum(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	
	public String getNombreLargo () {
		return nombreLargo;
	}
	
	public String getAbreviatura() {
        return this.name();
    }
	
}


