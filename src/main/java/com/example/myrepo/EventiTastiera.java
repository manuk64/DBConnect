package main.java.com.example.myrepo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventiTastiera implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER) System.out.println("Ok");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
