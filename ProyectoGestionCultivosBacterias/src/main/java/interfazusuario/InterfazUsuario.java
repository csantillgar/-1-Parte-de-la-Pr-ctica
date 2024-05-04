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
import java.time.format.DateTimeFormatter;
import java.util.List;
import logicadenegocio.Experimento;
import logicadenegocio.GestorExperimentos;
import logicadenegocio.GestorArchivos;

public class InterfazUsuario {
    private JFrame frame;
    private GestorExperimentos gestorExperimentos;
    private GestorArchivos gestorArchivos;
    private JLabel infoLabel;

    public InterfazUsuario() {
        frame = new JFrame("Gestión de Experimentos");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestorExperimentos = new GestorExperimentos();
        gestorArchivos = new GestorArchivos();
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(7, 1)); // Aumentamos el tamaño del GridLayout

        JLabel titleLabel = new JLabel("Menú Principal", SwingConstants.CENTER);
        panel.add(titleLabel);

        JButton nuevoExperimentoButton = new JButton("Crear Nuevo Experimento");
        nuevoExperimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearNuevoExperimento();
            }
        });
        panel.add(nuevoExperimentoButton);

        JButton abrirExperimentoButton = new JButton("Abrir experimento");
        abrirExperimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirExperimento();
            }
        });
        panel.add(abrirExperimentoButton);

        JButton verPoblacionesButton = new JButton("Ver Poblaciones del Experimento Actual");
        verPoblacionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPoblaciones();
            }
        });
        panel.add(verPoblacionesButton);

        JButton borrarPoblacionButton = new JButton("Borrar Población del Experimento Actual");
        borrarPoblacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarPoblacion();
            }
        });
        panel.add(borrarPoblacionButton);

        JButton verDetallesPoblacionButton = new JButton("Ver Detalles de una Población");
        verDetallesPoblacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verDetallesPoblacion();
            }
        });
        panel.add(verDetallesPoblacionButton);

        JButton eliminarPoblacionPorNombreButton = new JButton("Eliminar Población por Nombre");
        eliminarPoblacionPorNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPoblacionPorNombre();
            }
        });
        panel.add(eliminarPoblacionPorNombreButton); // Agregamos el botón para eliminar poblaciones por nombre

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(salirButton);

        frame.setVisible(true);
    }

    private void crearNuevoExperimento() {
        JFrame dialog = new JFrame("Crear Nuevo Experimento");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(6, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreField = new JTextField();
        dialog.add(nombreLabel);
        dialog.add(nombreField);

        JLabel fechaInicioLabel = new JLabel("Fecha de inicio (DD/MM/AAAA):");
        JTextField fechaInicioField = new JTextField();
        dialog.add(fechaInicioLabel);
        dialog.add(fechaInicioField);

        JLabel fechaFinLabel = new JLabel("Fecha de fin (DD/MM/AAAA):");
        JTextField fechaFinField = new JTextField();
        dialog.add(fechaFinLabel);
        dialog.add(fechaFinField);

        JButton crearButton = new JButton("Crear");
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String fechaInicioStr = fechaInicioField.getText();
                String fechaFinStr = fechaFinField.getText();

                try {
                    LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate fechaFin = LocalDate.parse(fechaFinStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    gestorExperimentos.crearExperimento(nombre, fechaInicio, fechaFin);

                    dialog.dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error al crear el experimento. Asegúrese de ingresar fechas en el formato correcto (DD/MM/AAAA).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dialog.add(crearButton);

        dialog.setVisible(true);
    }

    private void abrirExperimento() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Experimento experimento = (Experimento) ois.readObject();
                // Aquí puedes hacer algo con el experimento abierto, por ejemplo:
                JOptionPane.showMessageDialog(frame, "Experimento abierto: " + experimento.getNombre());
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error al abrir el experimento", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void verPoblaciones() {
        List<String> poblaciones = gestorExperimentos.getPoblacionesExperimentoActual();
        if (poblaciones.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay poblaciones en el experimento actual", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder poblacionesStr = new StringBuilder("Poblaciones del Experimento Actual:\n");
            for (String poblacion : poblaciones) {
                poblacionesStr.append(poblacion).append("\n");
            }
            JOptionPane.showMessageDialog(frame, poblacionesStr.toString(), "Poblaciones", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void borrarPoblacion() {
        String poblacionABorrar = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población a borrar:");
        if (poblacionABorrar != null) {
            boolean borrado = gestorExperimentos.borrarPoblacion(poblacionABorrar);
            if (borrado) {
                JOptionPane.showMessageDialog(frame, "Población eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró la población especificada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void verDetallesPoblacion() {
        String nombrePoblacion = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población:");
        if (nombrePoblacion != null) {
            String detalles = gestorExperimentos.getDetallesPoblacion(nombrePoblacion);
            if (detalles != null) {
                JOptionPane.showMessageDialog(frame, detalles, "Detalles de la Población", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró la población especificada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para eliminar poblaciones por nombre
    private void eliminarPoblacionPorNombre() {
        String nombrePoblacion = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la población a eliminar:");
        if (nombrePoblacion != null) {
            gestorExperimentos.eliminarPoblacionPorNombre(nombrePoblacion);
            JOptionPane.showMessageDialog(frame, "Población eliminada por nombre", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InterfazUsuario();
        });
    }
}
