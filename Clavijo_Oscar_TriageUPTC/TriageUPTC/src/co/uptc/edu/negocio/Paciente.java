package co.uptc.edu.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Paciente {
	
	//Atributos Paciente
	
	private String nombres;
	private String apellidos;
	private TipoDocumentoEnum tipoDocumento;
	private String numeroDocumento;
	private LocalDate fechaNacimiento;
	private Period edad;
	private String codigoEstudiantil;
	private String programa;
	private String facultad;
	private UrgenciaEnum nivelUrgencia;
	private String observacionesMedicoTratante;
	private LocalDateTime fechaHoraRegistro;
	
	
	//Constructor
	
	public Paciente(String nombres, String apellidos, TipoDocumentoEnum tipoDocumento, String numeroDocumento,
			LocalDate fechaNacimiento, String codigoEstudiantil, String programa, String facultad,
			UrgenciaEnum nivelUrgencia, String observacionesMedicoTratante) {
		
		setNombres(nombres);
		setApellidos(apellidos);
		
		this.nombres = nombres.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoEstudiantil = codigoEstudiantil;
		this.programa = programa.toUpperCase();
		this.facultad = facultad.toUpperCase();
		this.nivelUrgencia = nivelUrgencia;
		this.observacionesMedicoTratante = observacionesMedicoTratante;
		this.fechaHoraRegistro = LocalDateTime.now();
		this.calcularEdad();
	}

	
	//Getter & Setters
	
	
	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres.toUpperCase();
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}


	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}


	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public Period getEdad() {
		return edad;
	}



	public String getCodigoEstudiantil() {
		return codigoEstudiantil;
	}


	public void setCodigoEstudiantil(String codigoEstudiantil) {
		this.codigoEstudiantil = codigoEstudiantil;
	}


	public String getPrograma() {
		return programa;
	}


	public void setPrograma(String programa) {
		this.programa = programa.toUpperCase();
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad.toUpperCase();
	}


	public UrgenciaEnum getNivelUrgencia() {
		return nivelUrgencia;
	}


	public String getObservacionesMedicoTratante() {
		return observacionesMedicoTratante;
	}


	public void setObservacionesMedicoTratante(String observacionesMedicoTratante) {
		this.observacionesMedicoTratante = observacionesMedicoTratante;
	}

	 public LocalDateTime getFechaHoraRegistro() {
	        return fechaHoraRegistro;
	    }
	

	
	//Metodo Calcular Edad
	
	private void calcularEdad() {
		this.edad = Period.between(this.fechaNacimiento, LocalDate.now());
		
	}

	// Metodo para generar codigo al paciente

	public String generarCodigoPaciente () {
		String tdoc = this.tipoDocumento != null ? this.tipoDocumento.name() : "XX";
		String numDoc = (this.numeroDocumento != null) ? this.numeroDocumento.trim() : "0";
		String nombre = (this.nombres != null) ? this.nombres.trim() : "";
		String dosPrimerasLetrasNombre;
		
		if (nombre.length() == 0) {
			dosPrimerasLetrasNombre = "XX";
		} else if (nombre.length() == 1) {
			dosPrimerasLetrasNombre = nombre.substring(0,1).toUpperCase();
		} else {
			//dosPrimerasLetrasNombre = nombre.substring(0, Math.min(2, nombre.length())).toUpperCase();
			String primerNombre = nombre.split("\\s+")[0];
            dosPrimerasLetrasNombre = primerNombre.substring(0, Math.min(2, primerNombre.length()));
		}
		
		String apellido = (this.apellidos != null) ? this.apellidos.trim() : "";
		String primerApellido = apellido.split("\\s+")[0];
		String dosUltimasLetrasApellido;
		
		if (primerApellido.length() == 0) {
			dosUltimasLetrasApellido = "XX";
		} else if (primerApellido.length() == 1) {
			dosUltimasLetrasApellido = primerApellido.substring(primerApellido.length() - 1).toUpperCase();
		} else {
			int len = primerApellido.length();
			dosUltimasLetrasApellido = primerApellido.substring(Math.max(0, len -2)).toUpperCase();
		}
		
		String codigo = String.format("%s_%s_%s_%s", tdoc, numDoc, dosPrimerasLetrasNombre, dosUltimasLetrasApellido);
		return codigo;
		
	}
	
	// Metodo formatear fecha naciemiento
	
	public String getFechaNacimientoFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy – MMM-dd", new Locale("es"));
        return this.fechaNacimiento.format(formatter);
    }
	
	//Metodo para formatear fehca/hora del resgistro
	
	public String getFechaHoraRegistroFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss", new Locale("es"));
        return this.fechaHoraRegistro.format(formatter);
    }

	//Metodo para obetner edad formateada 
	
	public String getEdadFormateada() {
        return String.format("%d años, %d meses, %d días", 
            this.edad.getYears(), 
            this.edad.getMonths(), 
            this.edad.getDays());
	}

	// Método para mostrar toda la información del paciente
    public String mostrarInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("\n**************************************************\n");
        info.append(String.format("Fecha_Hora\t%s\n", getFechaHoraRegistroFormateada()));
        info.append(String.format("Cod_Interno\t%s\n", generarCodigoPaciente()));
        info.append(String.format("Nombres\t\t%s\n", this.nombres));
        info.append(String.format("Apellidos\t%s\n", this.apellidos));
        info.append(String.format("Fecha_Nac\t%s\n", getFechaNacimientoFormateada()));
        info.append(String.format("Edad\t\t%s\n", getEdadFormateada()));
        info.append(String.format("Tipo_Doc\t%s\n", this.tipoDocumento.getAbreviatura()));
        info.append(String.format("Num_Doc\t\t%s\n", this.numeroDocumento));
        info.append(String.format("Cod_Est\t\t%s\n", this.codigoEstudiantil));
        info.append(String.format("Programa\t%s\n", this.programa));
        info.append(String.format("Facultad\t%s\n", this.facultad));
        info.append(String.format("Niv_Urg\t\t%d\n", this.nivelUrgencia.getNivel()));
        info.append(String.format("Tipo_Urg\t%s\n", this.nivelUrgencia.getDescripcionCompleta()));
        info.append(String.format("Tiempo_Esp\t%s\n", this.nivelUrgencia.getTiempoAtencion()));
        info.append(String.format("Observación\t%s\n", this.observacionesMedicoTratante));
        info.append("*****************************************************\n");
        return info.toString();
    }
}
