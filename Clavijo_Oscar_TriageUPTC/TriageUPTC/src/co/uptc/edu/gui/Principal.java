package co.uptc.edu.gui;

import java.time.LocalDate;
import co.uptc.edu.negocio.Paciente;
import co.uptc.edu.negocio.TipoDocumentoEnum;
import co.uptc.edu.negocio.UrgenciaEnum;
import co.uptc.edu.negocio.FormularioTriage;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Arreglo para almacenar hasta 5 pacientes
        Paciente[] pacientes = new Paciente[5];
        
        // Crear instancia del formulario
        FormularioTriage formulario = new FormularioTriage();
        
        // Mapa para contar estudiantes por programa
        Map<String, Integer> contadorPorPrograma = new HashMap<>();
        
        // Mensaje de bienvenida
        JOptionPane.showMessageDialog(null, 
            "Sistema de Registro TRIAGE - Bienestar Universitario UPTC\n" +
            "Se registrarán 5 pacientes", 
            "Bienvenida", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Ciclo para registrar 5 pacientes
        
        for (int i = 0; i < 5; i++) {
            JOptionPane.showMessageDialog(null, 
                "Registro del Paciente #" + (i + 1), 
                "Nuevo Paciente", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Registrar paciente usando el formulario
            pacientes[i] = formulario.registrarPaciente();
            
            // Contar estudiantes por programa
            String programa = pacientes[i].getPrograma();
            contadorPorPrograma.put(programa, contadorPorPrograma.getOrDefault(programa, 0) + 1);
            
            JOptionPane.showMessageDialog(null, 
                "Paciente #" + (i + 1) + " registrado exitosamente", 
                "Registro Exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Mostrar información de todos los pacientes en consola
        System.out.println("\n");
        System.out.println("*****************************************************************");
        System.out.println("*     SISTEMA DE REGISTRO TRIAGE - BIENESTAR UNIVERSITARIO      *");
        System.out.println("*              UNIVERSIDAD PEDAGÓGICA Y TECNOLÓGICA             *");
        System.out.println("*                   DE COLOMBIA - UPTC                          *");
        System.out.println("*****************************************************************");
        System.out.println();
        
        // Mostrar cada paciente
        for (int i = 0; i < pacientes.length; i++) {
            System.out.println("PACIENTE #" + (i + 1));
            System.out.println(pacientes[i].mostrarInformacion());
        }
        
        // Mostrar resumen de estudiantes por programa
        System.out.println("\n***************************************************************");
        System.out.println("**             RESUMEN DE ATENCIÓN POR PROGRAMA                 **");
        System.out.println("******************************************************************");
        System.out.println();
        
        for (Map.Entry<String, Integer> entrada : contadorPorPrograma.entrySet()) {
            System.out.println("Se atendieron " + entrada.getValue() + 
                             " estudiante(s) de " + entrada.getKey());
        }
        
        System.out.println("\n***************************************************************");
        System.out.println("           Fin del registro - Sistema TRIAGE UPTC");
        System.out.println("*****************************************************************\n");
        
        // Mensaje final
        JOptionPane.showMessageDialog(null, 
            "Registro completado.\nRevise la consola para ver toda la información.", 
            "Proceso Finalizado", 
            JOptionPane.INFORMATION_MESSAGE);
    }
	
	

}
