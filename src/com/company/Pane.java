package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class Pane extends JPanel implements MouseListener, MouseMotionListener {

    private LinkedList<Point> points = new LinkedList<>();

    public Pane() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(7));
        for (int i = 1; i < points.size(); i++)
        {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);

            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        points.add(e.getPoint());
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        points.add(e.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
