import java.io.*;

public class Help {

    String helpfile;

    Help(String fname) {
        helpfile = fname;
    }

    boolean helpOn(String what) {
        int ch;
        String topic, info;

        try(BufferedReader helpRdr = new BufferedReader(new FileReader(helpfile)))
        {
            do {
                ch = helpRdr.read();

                if(ch == '#') {
                    topic = helpRdr.readLine();
                    if(what.compareTo(topic) == 0) {
                        do {
                            info = helpRdr.readLine();
                            if(info != null) System.out.println(info);
                        } while((info != null) && (info.compareTo("") != 0));
                        return true;
                    }
                }
            } while(ch != -1);
        }
        catch(IOException exc) {
            System.out.println("Błąd podczas dostępu do pliku pomocy.");
            return false;
        }
        return false;
    }

    static void showMenu() {
        System.out.println("Informacje na temat składni instrukcji:");
        System.out.println("  1. if");
        System.out.println("  2. switch");
        System.out.println("  3. for");
        System.out.println("  4. while");
        System.out.println("  5. do-while");
        System.out.println("  6. break");
        System.out.println("  7. continue\n");
        System.out.println("Wpisz nazwę instrukcji (lub \"stop\", aby zakończyć):");
    }

    String getSelection() {
        String topic = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            topic = br.readLine();
        }
        catch(IOException exc) {
            System.out.println("Błąd podczas odczytu z konsoli.");
        }
        return topic;
    }
}