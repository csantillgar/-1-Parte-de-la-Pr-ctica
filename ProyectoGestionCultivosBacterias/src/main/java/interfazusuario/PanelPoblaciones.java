package interfazusuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import logicadenegocio.Experimento;
import logicadenegocio.PoblacionBacterias;

public class PanelPoblaciones extends JPanel {
    private Experimento experimento;
    private JTable table;
    private JButton verDetallesButton;
    private DefaultTableModel tableModel;

    public PanelPoblaciones(Experimento experimento) {
        this.experimento = experimento;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Poblaciones de Bacterias", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Fecha Inicio");
        tableModel.addColumn("Fecha Fin");
        tableModel.addColumn("Número de Bacterias");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        verDetallesButton = new JButton("Ver Detalles");
        verDetallesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verDetallesPoblacion();
            }
        });
        add(verDetallesButton, BorderLayout.SOUTH);

        cargarPoblaciones();
    }

    private void cargarPoblaciones() {
        List<PoblacionBacterias> poblaciones = experimento.getPoblaciones();
        for (PoblacionBacterias poblacion : poblaciones) {
            Object[] rowData = {poblacion.getNombre(), poblacion.getFechaInicio(), poblacion.getFechaFin(), poblacion.getNumBacteriasIniciales()};
            tableModel.addRow(rowData);
        }
    }

    private void verDetallesPoblacion() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String nombrePoblacion = (String) table.getValueAt(selectedRow, 0);
            PoblacionBacterias poblacion = experimento.buscarPoblacionPorNombre(nombrePoblacion);
            if (poblacion != null) {
                JOptionPane.showMessageDialog(this, "Detalles de la población de bacterias:\n\n" + poblacion.toString(), "Detalles", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se encontró la población seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: Debes seleccionar una población de bacterias", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarTablaPoblaciones() {
        tableModel.setRowCount(0);
        cargarPoblaciones();
    }

    public int getSelectedRow() {

        return table.getSelectedRow();}

    public Object getValueAt(int selectedRow, int i) {

        return table.getValueAt(selectedRow, i);}
}
