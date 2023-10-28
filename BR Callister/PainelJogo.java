import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PainelJogo extends JPanel implements Runnable{
    final int originalSkinSize = 16; //tamanho dos sprites: 16x16
    int scale = 4;

    final int skinSize = originalSkinSize * scale; // 64x64
    final int maxColuna = 16;
    final int maxLinha = 12;
    final int larguraTela = skinSize * maxColuna; // 1024 pixeis
    final int comprimentoTela = skinSize * maxLinha; // 768 pixeis
    
    //FPS
    int fps = 60;

    Controles tecla = new Controles();
    Thread gameThread;

    //localização do jogador:
    int player1X = 100;
    int player1Y = 100;
    int playerVel = 4;

    public PainelJogo(){
        this.setPreferredSize(new Dimension(larguraTela, comprimentoTela));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(tecla);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double intervaloDesenho = 1000000000/fps;
        double delta = 0;
        long tempoAnterior = System.nanoTime();
        long tempoAtual;

        while(gameThread != null){
            tempoAtual = System.nanoTime();
            delta += (tempoAtual - tempoAnterior) / intervaloDesenho;
            tempoAnterior = tempoAtual;
            if(delta >= 1){
                //Atualiza informações:
                update();
                //Desenha na tela as informações atualizadas:
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        if(tecla.cimaPress == true){
            player1Y -= playerVel;
        } else if (tecla.baixoPress == true){
            player1Y += playerVel;
        } else if (tecla.esqPress == true){
            player1X -= playerVel;
        } else if (tecla.dirPress == true){
            player1X += playerVel;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(player1X, player1Y, skinSize, skinSize);
        g2.dispose();
    }
}