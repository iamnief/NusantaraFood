// -*- mode:java; encoding:utf-8 -*-
// vim:set fileencoding=utf-8:
// https://ateraimemo.com/Swing/RoundButton.html

package forms;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;

public class RoundedCornerButtonUI extends BasicButtonUI {
  private static final double ARC_WIDTH = 16d;
  private static final double ARC_HEIGHT = 16d;
  private static final int FOCUS_STROKE = 2;
  private final Color rc = new Color(6,14,99);
  private final Color fc = new Color(55,150,142);
  private final Color ac = new Color(235,150,133);
  private Shape shape;
  private Shape border;
  private Shape base;

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
        if (isShapeContains(e.getPoint())) {
          super.mousePressed(e);
        }
      }

      @Override public void mouseEntered(MouseEvent e) {
        if (isShapeContains(e.getPoint())) {
          super.mouseEntered(e);
        }
      }

      @Override public void mouseMoved(MouseEvent e) {
        if (isShapeContains(e.getPoint())) {
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
        //ketika button ditekan
        g2.setPaint(ac);
        g2.fill(shape);
      } else if (b.isRolloverEnabled() && model.isRollover()) {
        //jika mouse berada di wilayah button (tanpa klik)
        paintFocusAndRollover(g2, c, rc);
      } else if (b.hasFocus()) {
        //jika tidak berada di wilayah button dan button baru saja di klik
        paintFocusAndRollover(g2, c, fc);
      } else {
          //keadaan normal
        g2.setPaint(fc);
        g2.fill(shape);
      }
    }

    // Border
    g2.setPaint(fc);
    g2.draw(shape);
    g2.dispose();
    super.paint(g, c);
  }

  protected final boolean isShapeContains(Point pt) {
    return shape != null && shape.contains(pt.x, pt.y);
  }

  protected final void initShape(Component c) {
    if (!c.getBounds().equals(base)) {
      base = c.getBounds();
      shape = new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, ARC_WIDTH, ARC_HEIGHT);
      border = new RoundRectangle2D.Double(
          FOCUS_STROKE, FOCUS_STROKE,
          c.getWidth() - 1 - FOCUS_STROKE * 2,
          c.getHeight() - 1 - FOCUS_STROKE * 2,
          ARC_WIDTH, ARC_HEIGHT);
      
    }
  }

  protected final void paintFocusAndRollover(Graphics2D g2, Component c, Color color) {
    g2.setPaint(new GradientPaint(0, 0, color, c.getWidth() - 1, c.getHeight() - 1, color.brighter(), true));
    g2.fill(shape);
    //biar yg bersinar cuma border
//    g2.setPaint(fc);
//    g2.fill(border);
  }
}
