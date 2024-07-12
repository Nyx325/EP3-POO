import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JFrame {
    private JButton openButton;

    public FileChooser() {
        // Configuración de la ventana
        setTitle("File Chooser Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear botón y agregar ActionListener
        openButton = new JButton("Open File Chooser");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });

        // Agregar botón al JFrame
        add(openButton);
    }

    private void openFileChooser() {
        // Crear JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Configurar JFileChooser para que solo seleccione archivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Mostrar el cuadro de diálogo de archivo abierto
        int result = fileChooser.showOpenDialog(this);

        // Procesar la selección del usuario
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FileChooser example = new FileChooser();
                example.setVisible(true);
            }
        });
    }
}
