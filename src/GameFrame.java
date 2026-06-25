import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;
    private boolean gameOver;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.gameOver = false;

        setTitle("Game - " + player.getUsername() + " vs Komputer");
        setSize(400, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        lblStatus = new JLabel("Giliran kamu! (X)", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i].setPreferredSize(new Dimension(100, 100));
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            boardPanel.add(buttons[i]);
        }

        JButton btnBack = new JButton("Kembali ke Menu");
        btnBack.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });

        add(lblStatus, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);
    }

    private void handlePlayerMove(int index) {
        if (gameOver) return;

        boolean moved = gameLogic.makeMove(index, 'X');
        if (!moved) {
            JOptionPane.showMessageDialog(this, "Sel sudah terisi! Pilih yang lain.");
            return;
        }

        buttons[index].setText("X");
        buttons[index].setForeground(Color.BLUE);

        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Komputer berpikir...");
        int compIndex = gameLogic.computerMove();
        gameLogic.makeMove(compIndex, 'O');
        buttons[compIndex].setText("O");
        buttons[compIndex].setForeground(Color.RED);

        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        lblStatus.setText("Giliran kamu! (X)");
    }

    private void finishGame(String result) {
        gameOver = true;
        String message = "";
        if (result.equals("WIN")) {
            message = "Kamu MENANG! (+10 poin)";
            lblStatus.setText("Kamu MENANG!");
        } else if (result.equals("LOSE")) {
            message = "Kamu KALAH! (+0 poin)";
            lblStatus.setText("Kamu KALAH!");
        } else {
            message = "SERI! (+3 poin)";
            lblStatus.setText("SERI!");
        }

        playerService.updateStatistics(currentPlayer, result);

        int choice = JOptionPane.showConfirmDialog(this,
                message + "\n\nMau main lagi?", "Game Selesai", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            gameLogic.resetBoard();
            gameOver = false;
            for (JButton btn : buttons) {
                btn.setText("");
                btn.setForeground(Color.BLACK);
            }
            lblStatus.setText("Giliran kamu! (X)");
        } else {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        }
    }
}
