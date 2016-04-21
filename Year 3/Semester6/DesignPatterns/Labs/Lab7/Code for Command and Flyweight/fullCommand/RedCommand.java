import java.awt.*;
import javax.swing.*;

public class RedCommand implements Command {
   private JFrame frame;
   private JPanel pnl;

   public RedCommand(JFrame fr, JPanel p) {
      frame = fr;
      pnl = p;
   }
   public void Execute() {
      pnl.setBackground(Color.red);
   }
}
