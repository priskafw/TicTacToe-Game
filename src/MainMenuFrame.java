import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;

    public MainMenuFrame(Player player) {
        this.currentPlayer = player;

        setTitle("Main Menu - " + player.getUsername());
        setSize(300, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel welcome = new JLabel("Halo, " + player.getUsername() + "!", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnStartGame = new JButton("Main Game");
        JButton btnStatistics = new JButton("Statistik Saya");
        JButton btnTopScorers = new JButton("Top 5 Pemain");
        JButton btnExit = new JButton("Keluar");

        panel.add(welcome);
        panel.add(btnStartGame);
        panel.add(btnStatistics);
        panel.add(btnTopScorers);
        panel.add(btnExit);

        add(panel);

        btnStartGame.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame(currentPlayer);
            gameFrame.setVisible(true);
            this.dispose();
        });

        btnStatistics.addActionListener(e -> {
            StatisticsFrame statsFrame = new StatisticsFrame(currentPlayer);
            statsFrame.setVisible(true);
        });

        btnTopScorers.addActionListener(e -> {
            TopScorersFrame topFrame = new TopScorersFrame();
            topFrame.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin mau keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        });
    }
}
