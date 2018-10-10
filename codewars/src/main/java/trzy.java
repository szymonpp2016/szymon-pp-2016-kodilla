import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class trzy {

    public static class LogParser {
        public static ArrayList<Integer> getIdsByMessage(String xml, String message) throws Exception {

            int line;
            line = xml.toLowerCase().indexOf(message.toLowerCase());
            String text = xml.substring(line - 21, line - 20);
            System.out.println(text);
            int number = Integer.parseInt(text);
            ArrayList<Integer> collectionMain = new ArrayList<Integer>();

            collectionMain.add(number);

            return collectionMain;
        }

        public static void main(String[] args) throws Exception {
            String xml =
                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<log>\n" +
                            "    <entry id=\"1\">\n" +
                            "        <message>Application started</message>\n" +
                            "    </entry>\n" +
                            "    <entry id=\"2\">\n" +
                            "        <message>Application ended</message>\n" +
                            "    </entry>\n" +
                            "</log>";

            Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
            for (int id : ids)
                System.out.println(id);
        }
    }
}


