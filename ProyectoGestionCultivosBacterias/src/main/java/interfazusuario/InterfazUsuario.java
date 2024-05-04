package interfazusuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.List;
import javax.swing.SwingUtilities;


import logicadenegocio.*;

public class InterfazUsuario {
    private JFrame frame;
    private GestorArchivos gestorArchivos;
    private DosisComida dosisComida;
    private GestorPoblaciones gestorPoblaciones;
    private Poblacion poblacion;

    public InterfazUsuario() {
        frame = new JFrame("Gestión de Experimentos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        gestorArchivos = new GestorArchivos();
        gestorPoblaciones = new GestorPoblaciones();
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().add(panel);

        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 10, 10)); // Espacio entre botones
        panel.add(menuPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Menú Principal", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JButton abrirArchivoButton = new JButton("1. Abrir Archivo");
        abrirArchivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int seleccion = fileChooser.showOpenDialog(panel);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    abrirArchivo(file);
                }
            }
        });
        menuPanel.add(abrirArchivoButton);

        JButton crearNuevoExperimentoButton = new JButton("2. Crear Nuevo Experimento");
        crearNuevoExperimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí irá la lógica para crear un nuevo experimento
                String nombrePoblacion = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias:");
                LocalDate fechaInicio = LocalDate.now(); // Aquí puedes solicitar al usuario la fecha de inicio
                LocalDate fechaFin = LocalDate.now().plusDays(30); // Fecha de fin después de 30 días
                int numBacterias = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el número de bacterias iniciales:"));
                int temperatura = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la temperatura a la que se someterán las bacterias:"));
                String luminosidad = (String) JOptionPane.showInputDialog(frame, "Seleccione la condición de luminosidad:",
                        "Condición de Luminosidad", JOptionPane.QUESTION_MESSAGE, null,
                        new String[]{"Alta", "Media", "Baja"}, "Alta");

                // Aquí puedes solicitar los detalles de la dosis de comida
                int cantidadInicial = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad inicial de comida:"));
                int diaIncremento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el día hasta el cual se incrementará la cantidad de comida:"));
                int comidaIncremento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la comida del día hasta el cual se incrementará:"));
                int cantidadFinal = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad final de comida en el día 30:"));

                DosisComida dosisComida = new DosisComida(cantidadInicial, diaIncremento, comidaIncremento, cantidadFinal);

                // Aquí puedes crear la población de bacterias con los datos ingresados por el usuario
                // Experimento experimento = new Experimento(nombrePoblacion, fechaInicio, fechaFin, numBacterias, temperatura, luminosidad, dosisComida);

                // Luego puedes realizar cualquier acción adicional que necesites con el nuevo experimento
            }
        });
        menuPanel.add(crearNuevoExperimentoButton);


        JButton crearPoblacionButton = new JButton("3. Crear Población de Bacterias");
        crearPoblacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí irá la lógica para crear una población de bacterias
                String nombrePoblacion = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población de bacterias:");
                LocalDate fechaInicio = LocalDate.now(); // Aquí puedes solicitar al usuario la fecha de inicio
                LocalDate fechaFin = LocalDate.now().plusDays(30); // Fecha de fin después de 30 días
                int numBacterias = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el número de bacterias iniciales:"));
                int temperatura = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la temperatura a la que se someterán las bacterias:"));
                String luminosidad = (String) JOptionPane.showInputDialog(frame, "Seleccione la condición de luminosidad:",
                        "Condición de Luminosidad", JOptionPane.QUESTION_MESSAGE, null,
                        new String[]{"Alta", "Media", "Baja"}, "Alta");

                // Aquí puedes solicitar los detalles de la dosis de comida
                int cantidadInicial = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad inicial de comida:"));
                int diaIncremento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese el día hasta el cual se incrementará la cantidad de comida:"));
                int comidaIncremento = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la comida del día hasta el cual se incrementará:"));
                int cantidadFinal = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad final de comida en el día 30:"));

                DosisComida dosisComida = new DosisComida(cantidadInicial, diaIncremento, comidaIncremento, cantidadFinal);

                // Crear la población de bacterias con los datos ingresados por el usuario
                PoblacionBacterias poblacion = new PoblacionBacterias(nombrePoblacion, fechaInicio, fechaFin, numBacterias, temperatura, luminosidad, dosisComida);

                // Guardar la población de bacterias utilizando el gestor de archivos
                gestorArchivos.guardarPoblacionBacterias(poblacion, nombrePoblacion + ".dat");

                // Luego puedes realizar cualquier acción adicional que necesites con la nueva población de bacterias
            }
        });

        menuPanel.add(crearPoblacionButton);


        JButton verPoblacionesButton = new JButton("4. Visualizar Poblaciones");
        verPoblacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí irá la lógica para ver las poblaciones
                List<String> archivosPoblaciones = gestorArchivos.listarArchivosPoblacionBacterias();
                if (archivosPoblaciones.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No hay poblaciones de bacterias almacenadas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    StringBuilder mensaje = new StringBuilder("Poblaciones de Bacterias Almacenadas:\n");
                    for (String archivo : archivosPoblaciones) {
                        mensaje.append("- ").append(archivo).append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, mensaje.toString(), "Poblaciones de Bacterias", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        menuPanel.add(verPoblacionesButton);


        JButton borrarPoblacionButton = new JButton("5. Borrar Población");
        gestorPoblaciones = new GestorPoblaciones();

        // Configuración de la interfaz de usuario
        JButton botonBorrarPoblacion = new JButton("Borrar Población");
        botonBorrarPoblacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePoblacion = JOptionPane.showInputDialog("Ingrese el nombre de la población a borrar:");
                if (nombrePoblacion != null && !nombrePoblacion.isEmpty()) {
                    gestorPoblaciones.borrarPoblacion(nombrePoblacion);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de población válido.");
                }
            }
        });
        menuPanel.add(borrarPoblacionButton);

        JButton verDetallesPoblacionButton = new JButton("6. Ver Detalles de Población");
        JButton botonVerDetalles = new JButton("Ver Detalles de Población");
        botonVerDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePoblacion = JOptionPane.showInputDialog("Ingrese el nombre de la población:");
                if (nombrePoblacion != null && !nombrePoblacion.isEmpty()) {
                    Poblacion poblacion = gestorPoblaciones.obtenerPoblacion(nombrePoblacion);
                    if (poblacion != null) {
                        mostrarDetallesPoblacion(poblacion);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la población especificada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de población válido.");
                }
            }
        });



        menuPanel.add(verDetallesPoblacionButton);

        JButton guardarButton = new JButton("7. Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí irá la lógica para guardar el experimento
                 }
        });
        menuPanel.add(guardarButton);

        JButton salirButton = new JButton("8. Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        menuPanel.add(salirButton);

        frame.setVisible(true);
    }

    private void mostrarDetallesPoblacion(Poblacion poblacion) {
        JPanel panel = new JPanel(new BorderLayout());
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);

        JPanel detallesPanel = new JPanel(new GridLayout(0, 1, 10, 10)); // Espacio entre elementos
        panel.add(detallesPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Detalles de Población", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JLabel nombreLabel = new JLabel("Nombre: " + poblacion.getNombre());
        detallesPanel.add(nombreLabel);

        JLabel numIndividuosLabel = new JLabel("Número de Individuos: " + poblacion.getNumeroIndividuos());
        detallesPanel.add(numIndividuosLabel);

        JLabel fechaRegistroLabel = new JLabel("Fecha de Registro: " + poblacion.getFechaRegistro());
        detallesPanel.add(fechaRegistroLabel);

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMenuPrincipal();
            }
        });
        panel.add(volverButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void abrirArchivo(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            PoblacionBacterias poblacion = (PoblacionBacterias) ois.readObject();

            // Aquí puedes hacer lo que necesites con la población cargada desde el archivo
            // Por ejemplo, podrías mostrar los detalles de la población en una nueva ventana o hacer cualquier otra operación

            JOptionPane.showMessageDialog(frame, "Archivo cargado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazUsuario();
        });
    }
}
