package com.company;


import java.awt.*;

public class Segment {

    private Point startPoint;
    private Point endPoint;
    private double length;
    private double percentLength;
    private double angle;

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPercentLength() {
        return percentLength;
    }

    public void setPercentLength(double percentLength) {
        this.percentLength = percentLength;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
