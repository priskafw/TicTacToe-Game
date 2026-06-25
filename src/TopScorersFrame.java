import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {
    public TopScorersFrame() {
        setTitle("Top 5 Pemain Terbaik");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        String[] columns = {"Rank", "Username", "Menang", "Kalah", "Seri", "Poin"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        PlayerService ps = new PlayerService();
        ArrayList<Player> topList = ps.getTopFiveScorers();

        for (int i = 0; i < topList.size(); i++) {
            Player p = topList.get(i);
            model.addRow(new Object[]{
                    (i + 1), p.getUsername(), p.getWins(),
                    p.getLosses(), p.getDraws(), p.getScore()
            });
        }

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        JLabel title = new JLabel("Top 5 Pemain Terbaik", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 15));

        JButton btnClose = new JButton("Tutup");
        btnClose.addActionListener(e -> this.dispose());

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnClose, BorderLayout.SOUTH);
    }
}
