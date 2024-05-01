package interfazusuario;

import javax.swing.*;

public class InterfazUsuario {
    private JFrame frame;

    public InterfazUsuario() {
        frame = new JFrame("Gestión de Cultivos de Bacterias");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }

    public void mostrarMenuPrincipal() {
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Menú Principal");
        titleLabel.setBounds(150, 20, 100, 30);
        panel.add(titleLabel);

        JButton nuevoExperimentoButton = new JButton("Crear nuevo experimento");
        nuevoExperimentoButton.setBounds(50, 80, 250, 30);
        panel.add(nuevoExperimentoButton);

        JButton abrirExperimentoButton = new JButton("Abrir experimento");
        abrirExperimentoButton.setBounds(50, 130, 250, 30);
        panel.add(abrirExperimentoButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(50, 180, 250, 30);
        panel.add(salirButton);
    }

    // Otros métodos para interactuar con el usuario
}
