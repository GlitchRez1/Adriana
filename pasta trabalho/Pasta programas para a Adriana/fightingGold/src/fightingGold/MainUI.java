package fightingGold;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private JTextField lutaOponentes, lutaLocal;
    private JCheckBox lutaFinale;
    private JTextField sentimentoPeso, sentimentoIntensidade, sentimentoMotivo;
    private JTextField esperancaBrilho, esperancaFrequencia, esperancaFonte;

    public MainUI() {
        setTitle("Armazenar Valores das Classes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 1));

        // Painel Luta
        JPanel lutaPanel = new JPanel(new GridLayout(3, 2));
        lutaPanel.setBorder(BorderFactory.createTitledBorder("Luta"));
        lutaPanel.add(new JLabel("Finale:"));
        lutaFinale = new JCheckBox();
        lutaPanel.add(lutaFinale);
        lutaPanel.add(new JLabel("Oponentes:"));
        lutaOponentes = new JTextField();
        lutaPanel.add(lutaOponentes);
        lutaPanel.add(new JLabel("Local:"));
        lutaLocal = new JTextField();
        lutaPanel.add(lutaLocal);

        // Painel Sentimento
        JPanel sentimentoPanel = new JPanel(new GridLayout(3, 2));
        sentimentoPanel.setBorder(BorderFactory.createTitledBorder("Sentimento"));
        sentimentoPanel.add(new JLabel("Peso:"));
        sentimentoPeso = new JTextField();
        sentimentoPanel.add(sentimentoPeso);
        sentimentoPanel.add(new JLabel("Intensidade:"));
        sentimentoIntensidade = new JTextField();
        sentimentoPanel.add(sentimentoIntensidade);
        sentimentoPanel.add(new JLabel("Motivo:"));
        sentimentoMotivo = new JTextField();
        sentimentoPanel.add(sentimentoMotivo);

        // Painel Esperança
        JPanel esperancaPanel = new JPanel(new GridLayout(3, 2));
        esperancaPanel.setBorder(BorderFactory.createTitledBorder("Esperança"));
        esperancaPanel.add(new JLabel("Brilho:"));
        esperancaBrilho = new JTextField();
        esperancaPanel.add(esperancaBrilho);
        esperancaPanel.add(new JLabel("Frequência:"));
        esperancaFrequencia = new JTextField();
        esperancaPanel.add(esperancaFrequencia);
        esperancaPanel.add(new JLabel("Fonte:"));
        esperancaFonte = new JTextField();
        esperancaPanel.add(esperancaFonte);

        // Botão Salvar
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Luta luta = new Luta();
                    luta.finale = lutaFinale.isSelected();
                    luta.oponentes = Integer.parseInt(lutaOponentes.getText());
                    luta.local = lutaLocal.getText();

                    Sentimento sentimento = new Sentimento();
                    sentimento.peso = Double.parseDouble(sentimentoPeso.getText());
                    sentimento.intensidade = Integer.parseInt(sentimentoIntensidade.getText());
                    sentimento.motivo = sentimentoMotivo.getText();

                    Esperanca esperanca = new Esperanca();
                    esperanca.brilho = Integer.parseInt(esperancaBrilho.getText());
                    esperanca.frequencia = Integer.parseInt(esperancaFrequencia.getText());
                    esperanca.fonte = esperancaFonte.getText();

                    // Monta o conteúdo para salvar
                    String conteudo = "Luta:\n" +
                            "Finale: " + luta.finale + "\n" +
                            "Oponentes: " + luta.oponentes + "\n" +
                            "Local: " + luta.local + "\n\n" +

                            "Sentimento:\n" +
                            "Peso: " + sentimento.peso + "\n" +
                            "Intensidade: " + sentimento.intensidade + "\n" +
                            "Motivo: " + sentimento.motivo + "\n\n" +

                            "Esperança:\n" +
                            "Brilho: " + esperanca.brilho + "\n" +
                            "Frequência: " + esperanca.frequencia + "\n" +
                            "Fonte: " + esperanca.fonte + "\n" +
                            "---------------------------------\n";

                    // Salva no arquivo
                    try (java.io.FileWriter fw = new java.io.FileWriter("dados.txt", true)) {
                        fw.write(conteudo);
                    }

                    JOptionPane.showMessageDialog(MainUI.this,
                            "Valores salvos no arquivo dados.txt!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Preencha os campos numéricos corretamente!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Erro ao salvar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(lutaPanel);
        add(sentimentoPanel);
        add(esperancaPanel);
        add(salvarBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}
