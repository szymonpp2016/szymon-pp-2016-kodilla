import java.util.Collection;

public class dwa {

    public static class LogParser {
        public static void getIdsByMessage(String xml, String message) throws Exception {

            int line;
            line = xml.toLowerCase().indexOf(message.toLowerCase());
            String text= xml.substring(line-27, line-27);
            System.out.println(text);
            int number=Integer.parseInt(text);

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


        }
    }
}
