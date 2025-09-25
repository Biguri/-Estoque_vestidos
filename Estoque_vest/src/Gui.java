import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Gui {
    private VestidoDAO dao = new VestidoDAO();

    public void mostrarJanela() {
        JFrame frame = new JFrame("Controle de Vestidos - MySQL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton btnListar = new JButton("Listar Vestidos");
        JTextArea textArea = new JTextArea(10, 40);
        JLabel lblFoto = new JLabel();

        btnListar.addActionListener(e -> {
            textArea.setText("");
            List<Vestido> vestidos = dao.listar();
            for (Vestido v : vestidos) {
                textArea.append(v.getId() + " - " + v.getNome() + " (" + v.getTamanho() + ") - R$" + v.getPreco() + "\n");

                if (v.getFoto() != null && !v.getFoto().isEmpty()) {
                    ImageIcon icon = new ImageIcon(v.getFoto());
                    lblFoto.setIcon(new ImageIcon(icon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
                }
            }
        });

        frame.add(btnListar, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(lblFoto, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
