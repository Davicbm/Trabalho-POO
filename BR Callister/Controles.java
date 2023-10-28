import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener{
    public boolean cimaPress, baixoPress, esqPress, dirPress;
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W);{
            cimaPress = true;
        }
        if (code == KeyEvent.VK_S);{
            baixoPress = true;
        }
        if (code == KeyEvent.VK_A);{
            esqPress = true;
        }
        if (code == KeyEvent.VK_D);{
            dirPress = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W);{
            cimaPress = false;
        }
        if (code == KeyEvent.VK_S);{
            baixoPress = false;
        }
        if (code == KeyEvent.VK_A);{
            esqPress = false;
        }
        if (code == KeyEvent.VK_D);{
            dirPress = false;
        }
    }
}