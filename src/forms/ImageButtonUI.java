// -*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
// https://ateraimemo.com/Swing/RoundButton.html

package forms;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import net.coobird.thumbnailator.Thumbnails;

public class ImageButtonUI extends BasicButtonUI {
    protected final Color fc;
    private Shape base;
    private BufferedImage img = null;
    private final int imgX;
    private final int imgY;
    protected final int tolerance = 1;

    public ImageButtonUI(String resource, int width, int height){
        imgX = width;
        imgY = height;
        img = requesting(resource, imgX, imgY);
        fc = new Color(img.getRGB(imgX-1, imgY-1));
    }

    @Override protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setOpaque(false);
        b.setBackground(new Color(245, 250, 255));
        b.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));
        initShape(b);
    }

    @Override protected void installListeners(AbstractButton button) {
        BasicButtonListener listener = new BasicButtonListener(button) {
            @Override public void mousePressed(MouseEvent e) {
                AbstractButton b = (AbstractButton) e.getComponent();
                initShape(b);
                if (!isShapeContains(e.getPoint())) {
                    super.mousePressed(e);
                }
            }

            @Override public void mouseEntered(MouseEvent e) {
                if (!isShapeContains(e.getPoint())) {
                    super.mouseEntered(e);
                }
            }

            @Override public void mouseMoved(MouseEvent e) {
                if (!isShapeContains(e.getPoint())) {
                    super.mouseEntered(e);
                } else {
                    super.mouseExited(e);
                }
            }
        };
    // if (listener != null)
        button.addMouseListener(listener);
        button.addMouseMotionListener(listener);
        button.addFocusListener(listener);
        button.addPropertyChangeListener(listener);
        button.addChangeListener(listener);
  }

    @Override public void paint(Graphics g, JComponent c) {
        initShape(c);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // ContentArea
        if (c instanceof AbstractButton) {
            AbstractButton b = (AbstractButton) c;
            ButtonModel model = b.getModel();
            if (model.isArmed()) {
                g2.drawImage(img, 0, 0, b);
            } else if (b.isRolloverEnabled() && model.isRollover()) {
                paintFocusAndRollover(g2, c);
            } else if (b.hasFocus()) {
                paintFocusAndRollover(g2, c);
            } else {
                g2.drawImage(img, 0, 0, b);
            }
        }

//        g2.dispose();
        super.paint(g, c);
    }

    protected final boolean isShapeContains(Point pt) {
        Color target = new Color(img.getRGB(pt.x, pt.y));
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int rP = fc.getRed();
        int gP = fc.getGreen();
        int bP = fc.getBlue();
        return(
            (rP-tolerance<=rT) && (rT<=rP+tolerance) &&
            (gP-tolerance<=gT) && (gT<=gP+tolerance) &&
            (bP-tolerance<=bT) && (bT<=bP+tolerance) );
    }

    protected final void initShape(Component c) {
        if (!c.getBounds().equals(base)) {
            c.setSize(imgX, imgY);
            base = c.getBounds();
        }
    }

    protected final void paintFocusAndRollover(Graphics2D g2, Component c) {
        g2.drawImage(img, 0, 0, c);
    }
    public static BufferedImage requesting(String resource, int x, int y){
        BufferedImage thumbnail = null;
        try {
            File f = new File(resource);
            thumbnail = Thumbnails.of(f).size(x, y).asBufferedImage();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return thumbnail;
    }
}
