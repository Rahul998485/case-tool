/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgcase.tool;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

/**
 *
 * @author Aseem
 */
public abstract class Symbol implements Serializable {
    protected String name;
    protected String description;
    
    protected String id;
    /*Symbol(Symbol s) {
        this.name = s.name;
        this.description = s.description;
        this.id = s.id;
    }*/
    void draw (Graphics2D g) {};
    void move (int x, int y) {};
    void resize (int x, int y) {};
    int getHeight () {
        return (int) this.getBounds2D().getHeight();
    }
    int getWidth () {
        return (int) this.getBounds2D().getWidth();
    }
    int getX () {
        return (int) this.getBounds2D().getX();
    }
    int getY () {
        return (int) this.getBounds2D().getY();
    }
    boolean contains(Point p) {
        return false;
    };
    Rectangle2D getBounds2D () {
        return null;
    };
    boolean isdrawn () {
        if(this.getHeight()>0 && this.getWidth()>0) {
            return true; 
        }
        else return false;
    }
    String gettype () {
        return "";
    }
}
