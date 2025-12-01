package Biblioteca;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppBibliotecaGson {
    private static final String ARCHIVO_JSON = "biblioteca.json";
    private static Biblioteca biblioteca;
    private static Gson gson;
    
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.create();
        
        cargarDatosGson();
        
        SwingUtilities.invokeLater(() -> crearInterfaz());
    }
    
    private static void crearInterfaz() {
        JFrame frame = new JFrame("Sistema de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Libros", crearPanelLibros());
        tabbedPane.addTab("Préstamos", crearPanelPrestamos());
        tabbedPane.addTab("Estudiantes", crearPanelEstudiantes());
        tabbedPane.addTab("Configuración", crearPanelConfiguracion());
        tabbedPane.addTab("Ver JSON", crearPanelJSON());
        
        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JPanel crearPanelLibros() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Agregar Nuevo Libro"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JTextField txtTitulo = new JTextField(20);
        JTextField txtAutor = new JTextField(20);
        JTextField txtIsbn = new JTextField(20);
        JTextField txtPaginas = new JTextField(5);
        JTextField txtNacionalidad = new JTextField(15);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtTitulo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtAutor, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Nacionalidad Autor:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtNacionalidad, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtIsbn, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Número de páginas:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtPaginas, gbc);
        
        JButton btnAgregar = new JButton("Agregar Libro");
        btnAgregar.addActionListener(e -> {
            try {
                String titulo = txtTitulo.getText().trim();
                String autorNombre = txtAutor.getText().trim();
                String nacionalidad = txtNacionalidad.getText().trim();
                String isbn = txtIsbn.getText().trim();
                String paginasStr = txtPaginas.getText().trim();
                
                if (titulo.isEmpty() || autorNombre.isEmpty() || isbn.isEmpty() || paginasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int numPaginas = Integer.parseInt(paginasStr);
                if (numPaginas <= 0) {
                    throw new NumberFormatException("El número de páginas debe ser positivo");
                }
                
                Autor autor = new Autor(autorNombre, nacionalidad.isEmpty() ? "Desconocido" : nacionalidad);
                
                List<Pagina> paginas = new ArrayList<>();
                for (int i = 1; i <= numPaginas; i++) {
                    paginas.add(new Pagina(i, "Contenido de la página " + i + " del libro '" + titulo + "'"));
                }
                
                Libro libro = new Libro(titulo, isbn, autor, paginas);
                biblioteca.agregarLibro(libro);
                
                JOptionPane.showMessageDialog(null, "Libro agregado exitosamente");
                guardarDatosGson();
                
                txtTitulo.setText("");
                txtAutor.setText("");
                txtNacionalidad.setText("");
                txtIsbn.setText("");
                txtPaginas.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Número de páginas inválido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAgregar);
        
        JTextArea areaLibros = new JTextArea(15, 60);
        areaLibros.setEditable(false);
        areaLibros.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaLibros);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Libros"));
        
        JButton btnListar = new JButton("Listar Libros");
        btnListar.addActionListener(e -> {
            areaLibros.setText(biblioteca.listarLibros());
        });
        
        JButton btnLimpiar = new JButton("Limpiar Lista");
        btnLimpiar.addActionListener(e -> {
            areaLibros.setText("");
        });
        
        JPanel listButtonPanel = new JPanel();
        listButtonPanel.add(btnListar);
        listButtonPanel.add(btnLimpiar);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(listButtonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.EAST);
        
        return panel;
    }
    
    private static JPanel crearPanelPrestamos() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Registrar Nuevo Préstamo"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JTextField txtCodigoEstudiante = new JTextField(15);
        JTextField txtNombreEstudiante = new JTextField(20);
        JTextField txtIsbnLibro = new JTextField(20);
        JTextField txtDiasPrestamo = new JTextField(5);
        txtDiasPrestamo.setText("14");
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Código Estudiante:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCodigoEstudiante, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Nombre Estudiante:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtNombreEstudiante, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("ISBN del Libro:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtIsbnLibro, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Días de préstamo:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtDiasPrestamo, gbc);
        
        JPanel buttonPanel = new JPanel();
        
        JButton btnRegistrarPrestamo = new JButton("Registrar Préstamo");
        btnRegistrarPrestamo.addActionListener(e -> {
            try {
                String codigo = txtCodigoEstudiante.getText().trim();
                String nombre = txtNombreEstudiante.getText().trim();
                String isbn = txtIsbnLibro.getText().trim();
                String diasStr = txtDiasPrestamo.getText().trim();
                
                if (codigo.isEmpty() || nombre.isEmpty() || isbn.isEmpty() || diasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int dias = Integer.parseInt(diasStr);
                
                Estudiante estudiante = buscarEstudiante(codigo);
                if (estudiante == null) {
                    estudiante = new Estudiante(codigo, nombre);
                    biblioteca.agregarEstudiante(estudiante);
                }
                
                Libro libro = buscarLibroPorISBN(isbn);
                if (libro == null) {
                    throw new Exception("Libro con ISBN " + isbn + " no encontrado");
                }
                
                Prestamo prestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(dias), estudiante, libro);
                biblioteca.registrarPrestamo(prestamo);
                
                JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente");
                guardarDatosGson();
                
                txtCodigoEstudiante.setText("");
                txtNombreEstudiante.setText("");
                txtIsbnLibro.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Días de préstamo inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JTextArea areaPrestamos = new JTextArea(15, 60);
        areaPrestamos.setEditable(false);
        areaPrestamos.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaPrestamos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Préstamos"));
        
        JButton btnListarPrestamos = new JButton("Listar Préstamos");
        btnListarPrestamos.addActionListener(e -> {
            areaPrestamos.setText(biblioteca.listarPrestamos());
        });
        
        JButton btnLimpiar = new JButton("Limpiar Lista");
        btnLimpiar.addActionListener(e -> {
            areaPrestamos.setText("");
        });
        
        JPanel listButtonPanel = new JPanel();
        listButtonPanel.add(btnListarPrestamos);
        listButtonPanel.add(btnLimpiar);
        
        buttonPanel.add(btnRegistrarPrestamo);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(listButtonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.EAST);
        
        return panel;
    }
    
    private static JPanel crearPanelEstudiantes() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Agregar Nuevo Estudiante"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JTextField txtCodigo = new JTextField(15);
        JTextField txtNombre = new JTextField(20);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCodigo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtNombre, gbc);
        
        JPanel buttonPanel = new JPanel();
        
        JButton btnAgregarEstudiante = new JButton("Agregar Estudiante");
        btnAgregarEstudiante.addActionListener(e -> {
            try {
                String codigo = txtCodigo.getText().trim();
                String nombre = txtNombre.getText().trim();
                
                if (codigo.isEmpty() || nombre.isEmpty()) {
                    throw new Exception("Todos los campos son obligatorios");
                }
                
                Estudiante estudiante = new Estudiante(codigo, nombre);
                biblioteca.agregarEstudiante(estudiante);
                
                JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente");
                guardarDatosGson();
                
                txtCodigo.setText("");
                txtNombre.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JTextArea areaEstudiantes = new JTextArea(15, 60);
        areaEstudiantes.setEditable(false);
        areaEstudiantes.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaEstudiantes);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Estudiantes"));
        
        JButton btnListarEstudiantes = new JButton("Listar Estudiantes");
        btnListarEstudiantes.addActionListener(e -> {
            areaEstudiantes.setText(biblioteca.listarEstudiantes());
        });
        
        JButton btnLimpiar = new JButton("Limpiar Lista");
        btnLimpiar.addActionListener(e -> {
            areaEstudiantes.setText("");
        });
        
        JPanel listButtonPanel = new JPanel();
        listButtonPanel.add(btnListarEstudiantes);
        listButtonPanel.add(btnLimpiar);
        
        buttonPanel.add(btnAgregarEstudiante);
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(listButtonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.EAST);
        
        return panel;
    }
    
    private static JPanel crearPanelConfiguracion() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea areaInfo = new JTextArea(20, 70);
        areaInfo.setEditable(false);
        areaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(areaInfo);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Información del Sistema"));
        
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        
        JButton btnMostrarInfo = new JButton("Mostrar Información General");
        btnMostrarInfo.addActionListener(e -> {
            StringBuilder info = new StringBuilder();
            info.append("=== INFORMACIÓN DE LA BIBLIOTECA ===\n\n");
            info.append("Nombre: ").append(biblioteca.getNombre()).append("\n");
            info.append("Horario: ").append(biblioteca.getHorario().toString()).append("\n\n");
            info.append("=== ESTADÍSTICAS ===\n");
            info.append("Total Libros: ").append(biblioteca.getLibros().size()).append("\n");
            info.append("Total Autores: ").append(biblioteca.getAutores().size()).append("\n");
            info.append("Total Estudiantes: ").append(biblioteca.getEstudiantes().size()).append("\n");
            info.append("Total Préstamos Activos: ").append(biblioteca.getPrestamos().size()).append("\n");
            
            areaInfo.setText(info.toString());
        });
        
        JButton btnGuardar = new JButton("Guardar Datos a JSON");
        btnGuardar.addActionListener(e -> {
            guardarDatosGson();
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en " + ARCHIVO_JSON);
        });
        
        JButton btnCargar = new JButton("Cargar Datos desde JSON");
        btnCargar.addActionListener(e -> {
            cargarDatosGson();
            JOptionPane.showMessageDialog(null, "Datos cargados exitosamente desde " + ARCHIVO_JSON);
        });
        
        JButton btnExportar = new JButton("Exportar a Archivo JSON...");
        btnExportar.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Exportar JSON");
            fileChooser.setSelectedFile(new File("biblioteca_export.json"));
            
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileWriter writer = new FileWriter(file)) {
                    String json = gson.toJson(biblioteca);
                    writer.write(json);
                    JOptionPane.showMessageDialog(null, "Datos exportados exitosamente a " + file.getName());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al exportar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton btnImportar = new JButton("Importar desde Archivo JSON...");
        btnImportar.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Importar JSON");
            
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileReader reader = new FileReader(file)) {
                    biblioteca = gson.fromJson(reader, Biblioteca.class);
                    JOptionPane.showMessageDialog(null, "Datos importados exitosamente desde " + file.getName());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al importar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            guardarDatosGson();
            System.exit(0);
        });
        
        buttonPanel.add(btnMostrarInfo);
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnCargar);
        buttonPanel.add(btnExportar);
        buttonPanel.add(btnImportar);
        buttonPanel.add(btnSalir);
        
        panel.add(buttonPanel, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private static JPanel crearPanelJSON() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea areaJSON = new JTextArea(25, 80);
        areaJSON.setEditable(false);
        areaJSON.setFont(new Font("Monospaced", Font.PLAIN, 11));
        JScrollPane scrollPane = new JScrollPane(areaJSON);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Contenido del Archivo JSON"));
        
        JPanel buttonPanel = new JPanel();
        
        JButton btnMostrarJSON = new JButton("Mostrar JSON");
        btnMostrarJSON.addActionListener(e -> {
            try {
                String json = gson.toJson(biblioteca);
                areaJSON.setText(json);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al generar JSON: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> {
            areaJSON.setText("");
        });
        
        JButton btnGuardarJSON = new JButton("Guardar Cambios desde JSON");
        btnGuardarJSON.addActionListener(e -> {
            try {
                String json = areaJSON.getText();
                biblioteca = gson.fromJson(json, Biblioteca.class);
                JOptionPane.showMessageDialog(null, "Datos actualizados desde JSON");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "JSON inválido: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(btnMostrarJSON);
        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnGuardarJSON);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private static void cargarDatosGson() {
        File archivo = new File(ARCHIVO_JSON);
        if (archivo.exists()) {
            try (FileReader reader = new FileReader(archivo)) {
                biblioteca = gson.fromJson(reader, Biblioteca.class);
                System.out.println("Datos cargados exitosamente desde " + ARCHIVO_JSON);
            } catch (Exception e) {
                System.out.println("Error al cargar datos: " + e.getMessage());
                crearBibliotecaPorDefecto();
            }
        } else {
            crearBibliotecaPorDefecto();
        }
    }
    
    private static void guardarDatosGson() {
        try (FileWriter writer = new FileWriter(ARCHIVO_JSON)) {
            gson.toJson(biblioteca, writer);
            System.out.println("Datos guardados exitosamente en " + ARCHIVO_JSON);
        } catch (Exception e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    private static void crearBibliotecaPorDefecto() {
        Horario horario = new Horario("Lunes a Viernes", "08:00", "20:00");
        
        biblioteca = new Biblioteca("Biblioteca Central", horario);
        
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        List<Pagina> paginas1 = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            paginas1.add(new Pagina(i, "Contenido de Cien años de soledad - página " + i));
        }
        Libro libro1 = new Libro("Cien años de soledad", "978-8437604947", autor1, paginas1);
        
        Autor autor2 = new Autor("J.K. Rowling", "Británica");
        List<Pagina> paginas2 = new ArrayList<>();
        for (int i = 1; i <= 300; i++) {
            paginas2.add(new Pagina(i, "Contenido de Harry Potter - página " + i));
        }
        Libro libro2 = new Libro("Harry Potter y la piedra filosofal", "978-8478884452", autor2, paginas2);
        
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        
        guardarDatosGson();
    }
    
    private static Estudiante buscarEstudiante(String codigo) {
        for (Estudiante e : biblioteca.getEstudiantes()) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
    
    private static Libro buscarLibroPorISBN(String isbn) {
        for (Libro l : biblioteca.getLibros()) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }
}
