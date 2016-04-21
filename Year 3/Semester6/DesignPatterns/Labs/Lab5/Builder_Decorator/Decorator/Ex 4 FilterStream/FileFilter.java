import java.io.*;


public class FileFilter extends FilterInputStream {

    static int MAX=1000;

    public FileFilter(InputStream f) {
        super(f);
    }


    public String readLine() {
        String s;
        int length = 0;

        byte b[] = new byte[MAX];
        try {
            length = super.read(b);
            s = new String(b, 0, length);
        } catch (IOException e) {
            s = "";
        }

        StringBuffer buf = new StringBuffer(s);
        boolean punctFound = true;

        for (int i=0; i < length; i++) {
            char ch = buf.charAt (i);
            if (punctFound && (ch != ' ') ) {
                ch = Character.toUpperCase (ch);
                buf.setCharAt (i, ch);
                punctFound = false;
            }
            if (ch == '.')
                punctFound = true;
        }
        s = buf.toString ();
        return s;
    }
}
