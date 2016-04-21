import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.ResourceBundle;


public class ProgramResource extends ResourceBundle {

  private String[] keys = {"computeButton"};

  public Enumeration getKeys() {
    return Collections.enumeration(Arrays.asList(keys));
  }
  public Object handleGetObject(String key) {    return keys; }
}

