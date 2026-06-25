import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        PlayerService ps = new PlayerService();
        Player updated = ps.getPlayerById(player.getId());
        if (updated == null) updated = player;

        setTitle("Statistik - " + updated.getUsername());
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        panel.add(new JLabel("Username:")); panel.add(new JLabel(updated.getUsername()));
        panel.add(new JLabel("Menang:")); panel.add(new JLabel(String.valueOf(updated.getWins())));
        panel.add(new JLabel("Kalah:")); panel.add(new JLabel(String.valueOf(updated.getLosses())));
        panel.add(new JLabel("Seri:")); panel.add(new JLabel(String.valueOf(updated.getDraws())));
        panel.add(new JLabel("Total Poin:")); panel.add(new JLabel(String.valueOf(updated.getScore())));

        JButton btnClose = new JButton("Tutup");
        panel.add(new JLabel());
        panel.add(btnClose);

        JLabel title = new JLabel("Statistik Saya", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 15));

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        btnClose.addActionListener(e -> this.dispose());
    }
}
