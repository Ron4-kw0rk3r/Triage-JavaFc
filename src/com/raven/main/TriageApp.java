package com.raven.main;


import java.awt.*;
import java.awt.event.ActionEvent;

// border listen 


import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.border.Border;

public class TriageApp {
    private static JFrame currentFrame;
    private static JTextField userField;
    private static JPasswordField passField;
    private static JLabel notificationLabel;
    private static Connection connection;
    
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        TriageApp main = new TriageApp();
        main.createGUI();
    }

    public void createGUI() {
        // Establecer la conexión a la base de datos
        String dbURL = "jdbc:mysql://127.0.0.1:3306/hospital";
        String user = "root"; // Hashed value for "root"
        String password = "t0or%00%sh#ff"; // Hashed value for "t0or%00%sh#ff"
        //Class.forName("com.mysql.cj.jdbc.Driver");
        // llama a la clase
        //new com.mysql.cj.jdbc.Driver());
        
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        DatabaseConnect dbConnection = new DatabaseConnect(dbURL, user, password);
        connection = dbConnection.getConnection();

        // entresentido 

        JFrame frame = new JFrame("Sistema de Triaje");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230, 123)); // Color celeste claro transparente
        panel.setLayout(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Usar un diseño vertical

        notificationLabel = new JLabel();
        notificationLabel.setForeground(Color.yellow);
        notificationLabel.setBackground(Color.BLACK);

        JLabel label = new JLabel("Sistema Medico de Triage");
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Ron.Arc.Evx\\Documents\\NetBeansProjects\\triagehosp\\src\\triagehosp\\res\\log.png");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar la imagen


        JLabel userLabel = new JLabel("USUARIO");
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto
        userField = new JTextField(25);
        userField.setMaximumSize(userField.getPreferredSize()); // Alinear al centro
        

        JLabel passLabel = new JLabel("CONTRASENA");
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize());

        int borderRadius = 20;
        Border roundedBorder = BorderFactory.createCompoundBorder (
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(borderRadius, borderRadius, borderRadius, borderRadius)
        
        );
        /*
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, label.getWidth(), label.getHeight(), 20, 20);
        LineBorder roundedBorder = new LineBorder(Color.BLACK, 2) {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setClip(roundedRectangle);
                super.paintBorder(c, g2d, x, y, width, height);
                g2d.dispose();
            }
        };
        */

        /* 
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize()); // Alinear al centro
        panel.add(passField);
        userField = new JTextField(25);
        userField.setMaximumSize(userField.getPreferredSize()); // Alinear al centro
        passField = new JPasswordField(25);
        passField.setMaximumSize(passField.getPreferredSize()); // Alinear al centro
        */
        // nueva ventana .... 

        JButton plusButton = new JButton("+");
        plusButton.setFont(new Font("Arial", Font.PLAIN, 45));
        plusButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addUserFrame = new JFrame("Agregar usuario nuevo");
                addUserFrame.setSize(400, 400);
                addUserFrame.setLayout(new GridLayout(10, 10, 10, 10));
                
                //addUserFrame.setLayout(new BoxLayout(addUserFrame.getContentPane(), BoxLayout.Y_AXIS));
                addUserFrame.setLocationRelativeTo(frame); // This will center the addUserFrame relative to the main frame
                frame.setResizable(false);

                
                userField = new JTextField(25);
                userField.setMaximumSize(userField.getPreferredSize());
                


                JLabel newuserLabel = new JLabel("NOMBRE");
                JTextField nameField = new JTextField(25);
                JLabel newespLabel = new JLabel("ESPECIALIDAD");
                JTextField specialtyField = new JTextField(25);
                JLabel newpaswordLabel = new JLabel("CONTRASENA");
                JPasswordField passwordField = new JPasswordField(25);

                

                JPanel cancelButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JButton cancelButton = new JButton("Cancelar");
                cancelButtonPanel.add(cancelButton);
                //JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addUserFrame.dispose();
                    }
                });
                
                JPanel registerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                JButton registerButton = new JButton("Registrar");
                registerButtonPanel.add(registerButton);
                
                
                registerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Aquí se puede agregar la lógica del registro de los datos.
                        // Para este ejemplo, solo se imprimirá la fecha actual.
                        
                        // mic ventana emergenete por un lapso de tiempo 

                        
                        final JDialog successDialog = new JDialog(addUserFrame, "Éxito", true);
                        successDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
                        JLabel successLabel = new JLabel("Usuario registrado");
                        successDialog.add(successLabel);
                        successDialog.setSize(200, 100);

                        Timer timer = new Timer(2000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                successDialog.dispose();
                            }
                        }); 
                        timer.setRepeats(false);
                        timer.start();

                        
                        String name = nameField.getText();
                        String specialty = specialtyField.getText();
                        String password = new String(passwordField.getPassword());
                        
                        // Se formatea la fecha exacta para ingresar a la base de datos ... 
                        Date fcact = new Date();
                        SimpleDateFormat fmat = new SimpleDateFormat("yyyy-MM-dd");
                        
                        String fecha = fmat.format(fcact);
                       

                        if (!name.isEmpty() && !specialty.isEmpty() && !password.isEmpty()) {
                            newuserdb userRegistration = new newuserdb(connection);
                            userRegistration.insertMedico(name, specialty, password, fecha);
                            notificationLabel.setText("Usuario registrado con éxito: " + name);
                            notificationLabel.setBackground(Color.YELLOW);
                            System.out.println("Usuario registrado: " + name + ", Especialidad: " + specialty + ", Fecha: " + fecha );
                        } else {
                            notificationLabel.setText("Error en el registro, por favor complete todos los campos");
                            notificationLabel.setBackground(Color.GREEN);
                        }

                        addUserFrame.dispose();
                    }
                });
                //c.gridx = 0;
                //c.gridy = 0; 
                addUserFrame.add(newuserLabel);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 10)));
                addUserFrame.add(nameField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 10)));
                addUserFrame.add(newespLabel);
                addUserFrame.add(specialtyField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 10)));
                addUserFrame.add(newpaswordLabel);
                addUserFrame.add(passwordField);
                addUserFrame.add(Box.createRigidArea(new Dimension(0, 10)));

                addUserFrame.add(cancelButtonPanel); addUserFrame.add(registerButtonPanel);
                
                addUserFrame.setVisible(true);
            }
        });
        

        //fin de la ventana...

        
        JButton button = new JButton("INGRESAR");
        
        
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Botón centrado
        button.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String nombre = userField.getText();
                String contrasena = new String(passField.getPassword());
                System.out.println(">" + nombre + " "+ " " + contrasena);
                
                // propiedad ... 
                
                userverifydb userAuthentication = new userverifydb();
                int isAuthenticated = userAuthentication.verificarCredenciales( nombre , contrasena );
                

                if ( isAuthenticated == 1  ) {
                    //notificationLabel.setText("Acceso autorizado");
                    //notificationLabel.setBackground(Color.GREEN);
                    
                    Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
                    if (window instanceof JFrame) {
                        ((JFrame) window).dispose();
                    }
                    // dispose();
                    System.out.println("Connectado accediendo");
                    PanelAdmin newwind = new PanelAdmin();
                    newwind.setVisible(true);  
                    
                    
    
                } else {
                    //notificationLabel.setText("Falla de acceso, vuelva a intentar");
                    //notificationLabel.setForeground(Color.RED);
                    System.out.println("!ERROR! !!");
                    userField.setText(""); // Limpiar campos de texto
                    passField.setText("");
                }
            }
        });
        
        //label.setBorder(roundedBorder);
        //panel.add(label,BorderLayout.CENTER);
        
        //panel.add(notificationLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(imageLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passLabel);
        panel.add(passField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JPanel plusButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        plusButtonPanel.add(plusButton);
        
        plusButtonPanel.setBackground(new Color(173, 216, 230, 123));
        panel.add(plusButtonPanel);
        
        
       // panel.add(label,BorderLayout.CENTER);
        //frame.add(panel);
        //frame.setVisible(true);
        //panel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
