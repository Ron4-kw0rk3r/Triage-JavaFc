package com.raven.main;

 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//public class PanelAdmin {
    
public class PanelAdmin extends JFrame {
    private JPanel sidebarPanel;
    private JPanel contentPanel;

    public PanelAdmin() {
        setTitle("Panel Administrativo");
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Center the window on the screen
        setLocationRelativeTo(null);
        

        // Create navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.X_AXIS));
        navPanel.setBackground(new Color(0, 255, 255)); // Set background color to cyan green




        // Create button for Medico Admin
        JButton medicoAdminButton = new JButton("Medico Admin");
        medicoAdminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Medico Admin");
            }
        });

        // Add medicoAdminButton to navPanel
        navPanel.add(medicoAdminButton);

        // Crear panel lateral
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(178, 255, 204)); // Set background color to cyan green



        // Set font and font size for buttons


       

        // Crear botones para las opciones
        JButton inicioButton = new JButton("Inicio");
        JButton consultaButton = new JButton("Consulta");
        JButton pacienteButton = new JButton("Paciente");
        JButton generarReporteButton = new JButton("Generar Reporte");
        JButton historialMedicoButton = new JButton("Historial Médico");
        JButton retiroInvButton = new JButton("Retiro Inv");



        
        /* Set button border to rounded
        inicioButton.setBorder(new RoundedBorder(10));
        consultaButton.setBorder(new RoundedBorder(10));
        pacienteButton.setBorder(new RoundedBorder(10));
        generarReporteButton.setBorder(new RoundedBorder(10));
        historialMedicoButton.setBorder(new RoundedBorder(10));
        retiroInvButton.setBorder(new RoundedBorder(10));
        */
        // Set dimension for all buttons
        Dimension buttonDimension = new Dimension(180, 50);
        
        //medicoAdminButton.setPreferredSize(buttonDimension);

        inicioButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        pacienteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generarReporteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        historialMedicoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        retiroInvButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        inicioButton.setBorderPainted(false);
        consultaButton.setBorderPainted(false);
        pacienteButton.setBorderPainted(false);
        generarReporteButton.setBorderPainted(false);
        historialMedicoButton.setBorderPainted(false);
        retiroInvButton.setBorderPainted(false);



        Font buttonFont = new Font("Berlin Sans FB", Font.PLAIN, 14);
        medicoAdminButton.setFont(buttonFont);
        inicioButton.setFont(buttonFont);
        consultaButton.setFont(buttonFont);
        pacienteButton.setFont(buttonFont);
        generarReporteButton.setFont(buttonFont);
        historialMedicoButton.setFont(buttonFont);
        retiroInvButton.setFont(buttonFont);

         // Set general font and font size for content
        Font contentFont = new Font("Arial", Font.PLAIN, 14);
        // Set font for contentPanel
        
        // Agregar ActionListener a cada botón para cambiar el contenido
        inicioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Inicio");
            }
        });

        consultaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Consulta");
            }
        });

        pacienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Paciente");
            }
        });

        generarReporteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Generar Reporte");
            }
        });

        historialMedicoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Historial Médico");
            }
        });

        retiroInvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarContenido("Contenido de Retiro Inv");
            }
        });


        inicioButton.setPreferredSize(buttonDimension);
        consultaButton.setPreferredSize(buttonDimension);
        pacienteButton.setPreferredSize(buttonDimension);
        generarReporteButton.setPreferredSize(buttonDimension);
        historialMedicoButton.setPreferredSize(buttonDimension);
        retiroInvButton.setPreferredSize(buttonDimension);



        //Agregar botones al panel lateral
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        sidebarPanel.add(inicioButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(consultaButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(pacienteButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(generarReporteButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(historialMedicoButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        sidebarPanel.add(retiroInvButton);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Add historialMedicoButton to sidebarPanel
        ///sidebarPanel.add(historialMedicoButton);

        // Crear panel de contenido
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setFont(contentFont);
        // Agregar paneles al marco principal
        add(navPanel, BorderLayout.NORTH);
        add(sidebarPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // Iniciar con el contenido de Inicio
        actualizarContenido("Panel Administrativo");
    }

    private void actualizarContenido(String nuevoContenido) {
        contentPanel.removeAll();
        JLabel label = new JLabel(nuevoContenido);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(label, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PanelAdmin().setVisible(true);
            }
        });
    }
}



        // Add historialMedicoButton to sidebarPanel

