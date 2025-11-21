package co.uptc.edu.negocio;

import javax.swing.JOptionPane;
import java.time.LocalDate;

import java.time.LocalDate;
import java.time.Period;

public class FormularioTriage {
	
	
	
	public Paciente registrarPaciente() {
		
		String nombres = JOptionPane.showInputDialog("Ingrese los Nombre del Paciente");
		String apellidos = JOptionPane.showInputDialog("Ingrese  los Apellidos del Paciente");
		
		
		TipoDocumentoEnum tipoDocumento = null;
        boolean tipoValido = false;
        
        while (!tipoValido) {
            String tipoDocTexto = JOptionPane.showInputDialog("Tipo de Documento (RC, TI, CC, CE, PA):");
            try {
                tipoDocumento = TipoDocumentoEnum.valueOf(tipoDocTexto.toUpperCase());
                tipoValido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Tipo inválido. Use: RC, TI, CC, CE, PA", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
		
        //numeor de DOc
        
        String numDocTexto = "";
        boolean docValido = false;
        
        while (!docValido) {
            numDocTexto = JOptionPane.showInputDialog("Ingrese el Número de Documento (5-10 dígitos):");
            
            if (numDocTexto != null && numDocTexto.matches("\\d+") && 
                numDocTexto.length() >= 5 && numDocTexto.length() <= 10) {
                docValido = true;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "El documento debe ser numérico y tener entre 5 y 10 dígitos", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
			
        // fecha nacimiento
        
		LocalDate fechaNacimiento = null;	
		boolean fechaValida = false;
		
		
		
		while (!fechaValida) {
			String fechaTexto = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del Paciente usando el formato AAAA-MM-DD");
			
			try {
				fechaNacimiento = LocalDate.parse(fechaTexto);
				fechaValida = true;
				
				if (fechaNacimiento.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, 
                        "La fecha de nacimiento no puede ser futura", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    fechaValida = true;
                }
				
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Fecha inválida, use el formato AAAA-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			String codigoEstudiantil = JOptionPane.showInputDialog("Ingrese el Código Estudiantil:");
			String programa = JOptionPane.showInputDialog("Ingrese el Programa:");
			String facultad = JOptionPane.showInputDialog("Ingrese la Facultad:");
			
			
			/*
			LocalDate hoy = LocalDate.now();
			Period edad = Period.between(fechaNacimiento, hoy);
			int anos = edad.getYears();
			int meses = edad.getMonths();
			int dias = edad.getDays();
			String edadTexto = anos + " años, " + meses + " meses, " + dias + " días";
			*/
		
		
		// calcular edad
		
		UrgenciaEnum urgencia = null;
		boolean urgenciaValida =  false;
		
		while (!urgenciaValida) {
            String urgTexto = JOptionPane.showInputDialog(
                "Nivel de urgencia (ingrese un número del 1 al 5):\n" +
                "1 - Resucitación\n" +
                "2 - Emergencia\n" +
                "3 - Urgencia\n" +
                "4 - Urgencia Menor\n" +
                "5 - Sin Urgencia");
            
            try {
                int nivelNum = Integer.parseInt(urgTexto);
                urgencia = UrgenciaEnum.obtenerPorNivel(nivelNum);
                
                if (urgencia != null) {
                    urgenciaValida = true;
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Debe ingresar un número entre 1 y 5", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                    "Debe ingresar un número válido (1-5)", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
		
		String observaciones = JOptionPane.showInputDialog("Observaciones del Médico Tratante:");
		
		// Crear paciente con todos los datos 
		
		
		 Paciente paciente = new Paciente(
		            nombres,
		            apellidos,
		            tipoDocumento,
		            numDocTexto,
		            fechaNacimiento,
		            codigoEstudiantil,
		            programa,
		            facultad,
		            urgencia,
		            observaciones
		        );
		 
		 return paciente;

	
		}
		return null;
	}
}
	


