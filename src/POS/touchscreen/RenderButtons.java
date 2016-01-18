/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Guinness
 */
public class RenderButtons {

    public static void hover_touchscreen(final JButton[] btns1, final JButton[] btns2, final JButton[] btns3) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int a = 0; a < btns1.length; a++) {
                    final int aa = a;
                    btns1[a].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
//                            btns1[aa].setBackground(new java.awt.Color(4, 176, 217));
//                            btns2[aa].setBackground(new java.awt.Color(4, 176, 217));
//                            btns3[aa].setBackground(new java.awt.Color(4, 176, 217));
                            btns1[aa].setSelected(true);
                            btns2[aa].setSelected(true);
                            btns3[aa].setSelected(true);
                            int[] set = {0, 1, 2, 3, 4, 5};
                            for (int s : set) {
                                if (s != aa) {
//                                    btns1[s].setBackground(new java.awt.Color(255, 255, 255));
//                                    btns2[s].setBackground(new java.awt.Color(255, 255, 255));
//                                    btns3[s].setBackground(new java.awt.Color(255, 255, 255));
                                    btns1[s].setSelected(false);
                                    btns2[s].setSelected(false);
                                    btns3[s].setSelected(false);
                                }
                            }
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            btns1[aa].setBackground(new java.awt.Color(230, 232, 233));
                            btns2[aa].setBackground(new java.awt.Color(230, 232, 233));
                            btns3[aa].setBackground(new java.awt.Color(230, 232, 233));

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            btns1[aa].setBackground(new java.awt.Color(255, 255, 255));
                            btns2[aa].setBackground(new java.awt.Color(255, 255, 255));
                            btns3[aa].setBackground(new java.awt.Color(255, 255, 255));

                        }
                    });
                }

            }
        });
        t.start();

    }

    public static void hover_numpad(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(230, 232, 233));

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new java.awt.Color(255, 255, 255));

                }
            });
        }
    }

    static Border paddingBorder = BorderFactory.createEmptyBorder(0, 10, 0, 0);
    static Border paddingBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    static Border paddingBorder3 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    static Border paddingBorder4 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    static Border border = BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(204, 204, 204));
    static Border border2 = BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(204, 204, 204));
    static Border border7 = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204));
    static Border border3 = BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(204, 204, 204));
    static Border border4 = BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204));
    static Border border5 = BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(204, 204, 204));
    static Border border6 = BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(204, 204, 204));
    static Border border8 = BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(204, 204, 204));
    static Border border9 = BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(204, 204, 204));
    static Border border10 = BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204));

    public static void border1(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
        }
    }

    public static void border2(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border2, paddingBorder));
        }
    }

    public static void border2(JTextField[] btns) {
        for (final JTextField btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border7, paddingBorder4));
        }
    }

    public static void border3(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border3, paddingBorder2));
        }
    }

    public static void border4(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border4, paddingBorder2));
        }
    }

    public static void border5(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder2));
        }
    }

    public static void border6(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border8, paddingBorder2));
        }
    }

    public static void border7(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border9, paddingBorder2));
        }
    }

    public static void border8(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border10, paddingBorder2));
        }
    }

    public static void border9(JButton[] btns) {
        for (final JButton btn : btns) {
            btn.setBorder(BorderFactory.createCompoundBorder(border4, paddingBorder4));
        }
    }
}
