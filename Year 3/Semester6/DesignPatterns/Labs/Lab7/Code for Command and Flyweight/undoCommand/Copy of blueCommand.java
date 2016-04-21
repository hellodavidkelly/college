import java.awt.*;
import javax.swing.*;

public class blueCommand extends drawCommand {
   public blueCommand(JPanel p1) {
      super(p1);
      Dimension sz = p1.getSize();
      x = sz.width;
      y = 0;
      dx = -20;
      dy = 0;
      color = Color.blue;
   }
   public void setPanel(JPanel p1) {
     p = p1;
     Dimension sz = p1.getSize();
     x = sz.width;

  }
  }
