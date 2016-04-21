package lab7.part3;



import java.awt.*;
import java.net.URL;

import javax.swing.ImageIcon;

public class GremlinFactory {
    Gremlin good, bad;
    URL image = this.getClass().getResource("gremlin.png");
    ImageIcon icon = new ImageIcon(image);
    
    public GremlinFactory() {
        Color brown = new Color(0x5f5f1c);
        good =  new Gremlin(icon);
        bad = new Gremlin(icon);
    }

    public Gremlin getGremlin(boolean isSelected) {
        if (isSelected)
            return good;
        else
            return bad;
    }
}
