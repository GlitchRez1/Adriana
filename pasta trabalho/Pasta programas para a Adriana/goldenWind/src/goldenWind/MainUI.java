package goldenWind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {
    private JTextField standNome, standPoder, standUsuario;
    private JTextField fightingTitulo, fightingArtista, fightingTema;
    private JTextField equipeMembros, equipeNome, equipeLocal;

    public MainUI() {
        setTitle("Armazenar Valores - Golden Wind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(4, 1));

        // Painel HabilidadesStand
        JPanel standPanel = new JPanel(new GridLayout(3, 2));
        standPanel.setBorder(BorderFactory.createTitledBorder("Habilidades do Stand"));
        standPanel.add(new JLabel("Nome:"));
        standNome = new JTextField();
        standPanel.add(standNome);
        standPanel.add(new JLabel("Poder:"));
        standPoder = new JTextField();
        standPanel.add(standPoder);
        standPanel.add(new JLabel("Usuário:"));
        standUsuario = new JTextField();
        standPanel.add(standUsuario);

        // Painel FightingGold
        JPanel fightingPanel = new JPanel(new GridLayout(3, 2));
        fightingPanel.setBorder(BorderFactory.createTitledBorder("Fighting Gold (Música)"));
        fightingPanel.add(new JLabel("Título:"));
        fightingTitulo = new JTextField();
        fightingPanel.add(fightingTitulo);
        fightingPanel.add(new JLabel("Artista:"));
        fightingArtista = new JTextField();
        fightingPanel.add(fightingArtista);
        fightingPanel.add(new JLabel("Tema Principal:"));
        fightingTema = new JTextField();
        fightingPanel.add(fightingTema);

        // Painel EquipeBucciarati
        JPanel equipePanel = new JPanel(new GridLayout(3, 2));
        equipePanel.setBorder(BorderFactory.createTitledBorder("Equipe Bucciarati"));
        equipePanel.add(new JLabel("Membros:"));
        equipeMembros = new JTextField();
        equipePanel.add(equipeMembros);
        equipePanel.add(new JLabel("Nome da Equipe:"));
        equipeNome = new JTextField();
        equipePanel.add(equipeNome);
        equipePanel.add(new JLabel("Local de Encontro:"));
        equipeLocal = new JTextField();
        equipePanel.add(equipeLocal);

        // Botão Salvar
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    HabilidadesStand stand = new HabilidadesStand();
                    stand.nome = standNome.getText();
                    stand.poder = standPoder.getText();
                    stand.usuário = standUsuario.getText();

                    FightingGold music = new FightingGold();
                    music.titulo = fightingTitulo.getText();
                    music.artista = fightingArtista.getText();
                    music.temaPrincipal = fightingTema.getText();

                    EquipeBucciarati equipe = new EquipeBucciarati();
                    equipe.membros = Integer.parseInt(equipeMembros.getText());
                    equipe.nomeEquipe = equipeNome.getText();
                    equipe.localEncontro = equipeLocal.getText();

                    // Montar string para salvar
                    String conteudo = "Habilidades do Stand:\n" +
                            "Nome: " + stand.nome + "\n" +
                            "Poder: " + stand.poder + "\n" +
                            "Usuário: " + stand.usuário + "\n\n" +

                            "Fighting Gold (Música):\n" +
                            "Título: " + music.titulo + "\n" +
                            "Artista: " + music.artista + "\n" +
                            "Tema Principal: " + music.temaPrincipal + "\n\n" +

                            "Equipe Bucciarati:\n" +
                            "Membros: " + equipe.membros + "\n" +
                            "Nome da Equipe: " + equipe.nomeEquipe + "\n" +
                            "Local de Encontro: " + equipe.localEncontro + "\n" +
                            "---------------------------------\n";

                    // Salvar no arquivo
                    try (java.io.FileWriter fw = new java.io.FileWriter("goldenwind_dados.txt", true)) {
                        fw.write(conteudo);
                    }

                    JOptionPane.showMessageDialog(MainUI.this,
                            "Valores salvos no arquivo goldenwind_dados.txt!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Preencha o número de membros corretamente!",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainUI.this,
                            "Erro ao salvar: " + ex.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(standPanel);
        add(fightingPanel);
        add(equipePanel);
        add(salvarBtn);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}

