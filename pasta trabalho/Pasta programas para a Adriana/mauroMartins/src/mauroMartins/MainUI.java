package mauroMartins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private JTextField capitalSetor, capitalNome, capitalSede;
    private JTextField stateSetor, stateNome, stateSede;
    private JTextField tmobileSetor, tmobileNome, tmobileSede;

    public MainUI() {
        setTitle("Armazenar Valores - Mauro Martins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 1));

        // Painel CapitalOne
        JPanel capitalPanel = new JPanel(new GridLayout(3, 2));
        capitalPanel.setBorder(BorderFactory.createTitledBorder("Capital One"));
        capitalPanel.add(new JLabel("Setor:"));
        capitalSetor = new JTextField();
        capitalPanel.add(capitalSetor);
        capitalPanel.add(new JLabel("Nome:"));
        capitalNome = new JTextField();
        capitalPanel.add(capitalNome);
        capitalPanel.add(new JLabel("Sede:"));
        capitalSede = new JTextField();
        capitalPanel.add(capitalSede);

        // Painel StateFarm
        JPanel statePanel = new JPanel(new GridLayout(3, 2));
        statePanel.setBorder(BorderFactory.createTitledBorder("State Farm"));
        statePanel.add(new JLabel("Setor:"));
        stateSetor = new JTextField();
        statePanel.add(stateSetor);
        statePanel.add(new JLabel("Nome:"));
        stateNome = new JTextField();
        statePanel.add(stateNome);
        statePanel.add(new JLabel("Sede:"));
        stateSede = new JTextField();
        statePanel.add(stateSede);

        // Painel T-Mobile
        JPanel tmobilePanel = new JPanel(new GridLayout(3, 2));
        tmobilePanel.setBorder(BorderFactory.createTitledBorder("T-Mobile"));
        tmobilePanel.add(new JLabel("Setor:"));
        tmobileSetor = new JTextField();
        tmobilePanel.add(tmobileSetor);
        tmobilePanel.add(new JLabel("Nome:"));
        tmobileNome = new JTextField();
        tmobilePanel.add(tmobileNome);
        tmobilePanel.add(new JLabel("Sede:"));
        tmobileSede = new JTextField();
        tmobilePanel.add(tmobileSede);

        // Botão Salvar
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CapitalOne capital = new CapitalOne();
                    capital.setor = capitalSetor.getText();
                    capital.nome = capitalNome.getText();
                    capital.sede = capitalSede.getText();

                    StateFarm state = new StateFarm();
                    state.setor = stateSetor.getText();
                    state.nome = stateNome.getText();
                    state.sede = stateSede.getText();

                    TMobile tmobile = new TMobile();
                    tmobile.setor = tmobileSetor.getText();
                    tmobile.nome = tmobileNome.getText();
                    tmobile.sede = tmobileSede.getText();

                    // Montar string para salvar
                    String conteudo = "Capital One:\n" +
                            "Setor: " + capital.setor + "\n" +
                            "Nome: " + capital.nome + "\n" +
                            "Sede: " + capital.sede + "\n\n" +

                            "State Farm:\n" +
                            "Setor: " + state.setor + "\n" +
                            "Nome: " + state.nome + "\n" +
                            "Sede: " + state.sede + "\n\n" +

                            "T-Mobile:\n" +
                            "Setor: " + tmobile.setor + "\n" +
                            "Nome: " + tmobile.nome + "\n" +
                            "Sede: " + tmobile.sede + "\n" +
                            "---------------------------------\n";

                    // Salvar no arquivo
                    try (java.io.FileWriter fw = new java.io.FileWriter("mauromartins_dados.txt", true)) {
                        fw.write(conteudo);
                    }

                    JOptionPane.showMessageDialog(MainUI.this,
                            "Valores salvos no arquivo mauromartins_dados.txt!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Erro ao salvar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(capitalPanel);
        add(statePanel);
        add(tmobilePanel);
        add(salvarBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}
