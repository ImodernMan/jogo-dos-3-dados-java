import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class JogoDados {

    static Random random = new Random();

    public static int rolarDado() {
        return random.nextInt(6) + 1;
    }

    public static void main(String[] args) {

        JFrame janela = new JFrame("🎲 Jogo dos 3 Dados");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());

        JLabel resultado = new JLabel("Clique no botão para rolar os dados");
        resultado.setFont(new Font("Arial", Font.BOLD, 16));

        JButton botao = new JButton("Rolar Dados");

        botao.addActionListener(e -> {

            int j1 = rolarDado();
            int j2 = rolarDado();
            int j3 = rolarDado();

            int pc1 = rolarDado();
            int pc2 = rolarDado();
            int pc3 = rolarDado();

            int somaJogador = j1 + j2 + j3;
            int somaPc = pc1 + pc2 + pc3;

            String texto = "Você: " + somaJogador + " | PC: " + somaPc;

            if (somaJogador > somaPc) {
                texto += " → Você venceu!";
            } else if (somaPc > somaJogador) {
                texto += " → PC venceu!";
            } else {
                texto += " → Empate!";
            }

            resultado.setText(texto);
        });

        janela.add(resultado);
        janela.add(botao);

        janela.setVisible(true);
    }
}