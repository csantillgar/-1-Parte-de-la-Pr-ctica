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
import java.util.List; // Importa la clase List
import logicadenegocio.Experimento;
import logicadenegocio.GestorExperimentos;
import logicadenegocio.GestorArchivos;

public class InterfazUsuario {
    private JFrame frame;
    private GestorExperimentos gestorExperimentos;
    private GestorArchivos gestorArchivos;

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
        panel.setLayout(new GridLayout(4, 1));

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

        JButton guardarExperimentoButton = new JButton("Guardar experimento");
        guardarExperimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarExperimento();
            }
        });
        panel.add(guardarExperimentoButton);

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

                LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate fechaFin = LocalDate.parse(fechaFinStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                gestorExperimentos.crearExperimento(nombre, fechaInicio, fechaFin);

                dialog.dispose();
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

    private void guardarExperimento() {
        // Obtener el experimento actual y guardarlo usando GestorArchivos
        Experimento experimento = gestorExperimentos.getExperimentoActual();
        if (experimento != null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                gestorArchivos.guardarExperimento(experimento, file);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No hay experimento para guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

