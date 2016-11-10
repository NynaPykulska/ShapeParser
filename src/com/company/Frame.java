package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import static java.lang.Math.atan2;


public class Frame extends JFrame implements ActionListener {

    private JButton submit = new JButton("Submit");
    private Pane pane = new Pane();
    private LinkedList<Segment> segments;

    public Frame() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(pane, BorderLayout.CENTER);
        submit.addActionListener(this);
        submit.setActionCommand("submit");
        this.add(submit, BorderLayout.SOUTH);
        this.setSize(400, 600);

        segments = new LinkedList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("submit".equals(e.getActionCommand())) {
            LinkedList<Point> points = pane.getPoints();
            for (int i = 1; i < points.size(); i++) {
                createSegment(points.get(i-1), points.get(i));
            }
            addPercentageLength();
            printSegments();
        }
    }

    private Segment createSegment(Point a, Point b) {
        Segment segment = new Segment();
        segment.setStartPoint(a);
        segment.setEndPoint(b);
        segment.setLength(countLength(a, b));
        if (segments.size() == 0) {
            segment.setAngle(0);
        } else {
            segment.setAngle(getAngleBetween(segments.getLast(), a, b));
        }
        segments.add(segment);

        return segment;
    }

    private double countPerimeter() {
        double sum = 0;
        for (Segment segment : segments) {
            sum += segment.getLength();
        }
        return sum;
    }

    // returns what part of whole shape is one segment (not in percents but a fraction)
    private void addPercentageLength() {
        double perimeter = countPerimeter();
        for (Segment segment : segments) {
            segment.setPercentLength(segment.getLength()/perimeter);
        }
    }

    private double countLength(Point a, Point b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()),2.0) + Math.pow((b.getY() - a.getY()), 2.0));
    }

    // ref http://stackoverflow.com/questions/3365171/calculating-the-angle-between-two-lines-without-having-to-calculate-the-slope
    public double getAngleBetween(Segment v, Point startPoint, Point endPoint){
        double angle1 = Math.atan2( v.getStartPoint().getY() - v.getEndPoint().getY(),
                                v.getStartPoint().getX() - v.getEndPoint().getX());
        double angle2 = Math.atan2( startPoint.getY() - endPoint.getY(),
                                startPoint.getX() - endPoint.getX());

        return angle1 - angle2;
    }

    private void printSegments() {
        System.out.println("id\tstart\t\tend\t\tlength\tpercentage length\tangle");
        for (int i = 0; i < segments.size(); i++) {
            Segment s = segments.get(i);
            System.out.println(i+"\t"+s.getStartPoint().getX()+" "+s.getStartPoint().getY()+" "+
                "\t"+s.getEndPoint().getX()+" "+s.getEndPoint().getY()+"\t"+s.getLength()+
                "\t"+s.getPercentLength()+"\t"+s.getAngle());
        }
    }
}
