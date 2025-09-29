package lampedusa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private JTextField obraTitulo, obraArtista, obraMaterial;
    private JTextField materialTipo, materialOrigem, materialPeso;
    private JTextField mensagemTema, mensagemReferencia, mensagemImpacto;

    public MainUI() {
        setTitle("Armazenar Valores - Lampedusa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 1));

        // Painel Obra
        JPanel obraPanel = new JPanel(new GridLayout(3, 2));
        obraPanel.setBorder(BorderFactory.createTitledBorder("Obra"));
        obraPanel.add(new JLabel("Título:"));
        obraTitulo = new JTextField();
        obraPanel.add(obraTitulo);
        obraPanel.add(new JLabel("Artista:"));
        obraArtista = new JTextField();
        obraPanel.add(obraArtista);
        obraPanel.add(new JLabel("Material:"));
        obraMaterial = new JTextField();
        obraPanel.add(obraMaterial);

        // Painel Material
        JPanel materialPanel = new JPanel(new GridLayout(3, 2));
        materialPanel.setBorder(BorderFactory.createTitledBorder("Material"));
        materialPanel.add(new JLabel("Tipo:"));
        materialTipo = new JTextField();
        materialPanel.add(materialTipo);
        materialPanel.add(new JLabel("Origem:"));
        materialOrigem = new JTextField();
        materialPanel.add(materialOrigem);
        materialPanel.add(new JLabel("Peso:"));
        materialPeso = new JTextField();
        materialPanel.add(materialPeso);

        // Painel Mensagem
        JPanel mensagemPanel = new JPanel(new GridLayout(3, 2));
        mensagemPanel.setBorder(BorderFactory.createTitledBorder("Mensagem"));
        mensagemPanel.add(new JLabel("Tema:"));
        mensagemTema = new JTextField();
        mensagemPanel.add(mensagemTema);
        mensagemPanel.add(new JLabel("Referência:"));
        mensagemReferencia = new JTextField();
        mensagemPanel.add(mensagemReferencia);
        mensagemPanel.add(new JLabel("Impacto:"));
        mensagemImpacto = new JTextField();
        mensagemPanel.add(mensagemImpacto);

        // Botão Salvar
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Obra obra = new Obra();
                    obra.titulo = obraTitulo.getText();
                    obra.artista = obraArtista.getText();
                    obra.material = obraMaterial.getText();

                    Material material = new Material();
                    material.tipo = materialTipo.getText();
                    material.origem = materialOrigem.getText();
                    material.peso = materialPeso.getText();

                    Mensagem mensagem = new Mensagem();
                    mensagem.tema = mensagemTema.getText();
                    mensagem.referência = mensagemReferencia.getText();
                    mensagem.impacto = mensagemImpacto.getText();

                    // Montar string para salvar
                    String conteudo = "Obra:\n" +
                            "Título: " + obra.titulo + "\n" +
                            "Artista: " + obra.artista + "\n" +
                            "Material: " + obra.material + "\n\n" +

                            "Material:\n" +
                            "Tipo: " + material.tipo + "\n" +
                            "Origem: " + material.origem + "\n" +
                            "Peso: " + material.peso + "\n\n" +

                            "Mensagem:\n" +
                            "Tema: " + mensagem.tema + "\n" +
                            "Referência: " + mensagem.referência + "\n" +
                            "Impacto: " + mensagem.impacto + "\n" +
                            "---------------------------------\n";

                    // Salvar no arquivo
                    try (java.io.FileWriter fw = new java.io.FileWriter("lampedusa_dados.txt", true)) {
                        fw.write(conteudo);
                    }

                    JOptionPane.showMessageDialog(MainUI.this,
                            "Valores salvos no arquivo lampedusa_dados.txt!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Erro ao salvar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(obraPanel);
        add(materialPanel);
        add(mensagemPanel);
        add(salvarBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}
