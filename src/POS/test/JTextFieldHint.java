/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.test;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author Guinness
 */
public final class JTextFieldHint extends JTextField implements FocusListener {

    private final JTextField jtf;
    private ImageIcon icon;
    private final String hint;
    private final Insets dummyInsets;

    public JTextFieldHint(JTextField jtf, String icon, String hint, ImageIcon ic) {

        this.jtf = jtf;
        setIcon(ic);
        this.hint = hint;

        Border border = UIManager.getBorder("TextField.border");

        JTextField dummy = new JTextField();
        dummy.setHorizontalAlignment(SwingConstants.RIGHT);
        this.dummyInsets = border.getBorderInsets(dummy);

        addFocusListener(this);
    }

    public void setIcon(ImageIcon newIcon) {
        this.icon = newIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setHorizontalAlignment(SwingConstants.RIGHT);
        super.setAlignmentX(SwingConstants.RIGHT);
        int textX = 2;

        if (this.icon != null) {
            int width = this.getWidth();
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = dummyInsets.left - 1;
            textX = x + iconWidth + 2;
            int y = (this.getHeight() - iconHeight) / 2;

            icon.paintIcon(this, g, x, y);
        }

        setMargin(new Insets(2, textX, 2, 2));

    }

    @Override
    public void focusGained(FocusEvent arg0) {
        this.repaint();
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        this.repaint();
    }

}
