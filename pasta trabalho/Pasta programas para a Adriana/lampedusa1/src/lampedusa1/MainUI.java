package lampedusa1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private JTextField barcoTitulo, barcoArtista, barcoString;
    private JTextField mensagemTitulo, mensagemArtista, mensagemString;
    private JTextField refugiadoTitulo, refugiadoArtista, refugiadoString;

    public MainUI() {
        setTitle("Armazenar Valores - Lampedusa1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 1));

        // Painel Barco
        JPanel barcoPanel = new JPanel(new GridLayout(3, 2));
        barcoPanel.setBorder(BorderFactory.createTitledBorder("Barco"));
        barcoPanel.add(new JLabel("Título:"));
        barcoTitulo = new JTextField();
        barcoPanel.add(barcoTitulo);
        barcoPanel.add(new JLabel("Artista:"));
        barcoArtista = new JTextField();
        barcoPanel.add(barcoArtista);
        barcoPanel.add(new JLabel("Descrição:"));
        barcoString = new JTextField();
        barcoPanel.add(barcoString);

        // Painel Mensagem
        JPanel mensagemPanel = new JPanel(new GridLayout(3, 2));
        mensagemPanel.setBorder(BorderFactory.createTitledBorder("Mensagem"));
        mensagemPanel.add(new JLabel("Título:"));
        mensagemTitulo = new JTextField();
        mensagemPanel.add(mensagemTitulo);
        mensagemPanel.add(new JLabel("Artista:"));
        mensagemArtista = new JTextField();
        mensagemPanel.add(mensagemArtista);
        mensagemPanel.add(new JLabel("Descrição:"));
        mensagemString = new JTextField();
        mensagemPanel.add(mensagemString);

        // Painel Refugiado
        JPanel refugiadoPanel = new JPanel(new GridLayout(3, 2));
        refugiadoPanel.setBorder(BorderFactory.createTitledBorder("Refugiado"));
        refugiadoPanel.add(new JLabel("Título:"));
        refugiadoTitulo = new JTextField();
        refugiadoPanel.add(refugiadoTitulo);
        refugiadoPanel.add(new JLabel("Artista:"));
        refugiadoArtista = new JTextField();
        refugiadoPanel.add(refugiadoArtista);
        refugiadoPanel.add(new JLabel("Descrição:"));
        refugiadoString = new JTextField();
        refugiadoPanel.add(refugiadoString);

        // Botão Salvar
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Barco barco = new Barco();
                    barco.titulo = barcoTitulo.getText();
                    barco.artista = barcoArtista.getText();
                    barco.String = barcoString.getText();

                    Mensagem mensagem = new Mensagem();
                    mensagem.titulo = mensagemTitulo.getText();
                    mensagem.artista = mensagemArtista.getText();
                    mensagem.String = mensagemString.getText();

                    Refugiado refugiado = new Refugiado();
                    refugiado.titulo = refugiadoTitulo.getText();
                    refugiado.artista = refugiadoArtista.getText();
                    refugiado.String = refugiadoString.getText();

                    // Montar string para salvar
                    String conteudo = "Barco:\n" +
                            "Título: " + barco.titulo + "\n" +
                            "Artista: " + barco.artista + "\n" +
                            "Descrição: " + barco.String + "\n\n" +

                            "Mensagem:\n" +
                            "Título: " + mensagem.titulo + "\n" +
                            "Artista: " + mensagem.artista + "\n" +
                            "Descrição: " + mensagem.String + "\n\n" +

                            "Refugiado:\n" +
                            "Título: " + refugiado.titulo + "\n" +
                            "Artista: " + refugiado.artista + "\n" +
                            "Descrição: " + refugiado.String + "\n" +
                            "---------------------------------\n";

                    // Salvar no arquivo
                    try (java.io.FileWriter fw = new java.io.FileWriter("lampedusa1_dados.txt", true)) {
                        fw.write(conteudo);
                    }

                    JOptionPane.showMessageDialog(MainUI.this,
                            "Valores salvos no arquivo lampedusa1_dados.txt!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Erro ao salvar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(barcoPanel);
        add(mensagemPanel);
        add(refugiadoPanel);
        add(salvarBtn);
    }


public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
}
}