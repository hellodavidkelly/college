
//German language resource bundle
public class ProgramResource_de extends ProgramResource {

  public Object handleGetObject(String key) {

    String returnString="";

    if(key.equals("computeButton")) {
      returnString = "Rechnen";
    }
    else if(key.equals("greeting")) {
      returnString = "Wilkommen";
    }
    return returnString;
  }
}

