import acm.graphics.*;
import java.awt.*;

public class GLens extends GPolygon {

    public GLens(double width, double height) {
    	double r = ((height * height) + (width * width)) / (4 * width);
    	double c = r - (width / 2);
    	double h = height / 2;
    	addVertex(0, h / 2);
    	addArc(width, height, -45, 90);
    	addArc(width, height, 135, 90);
    	setColor(Color.BLACK);
    	setFilled(true);
    	setFillColor(Color.LIGHT_GRAY);
    }
}
