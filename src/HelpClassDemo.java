
public class HelpClassDemo {
    public static void main(String[] args) {

        String topic;
        Help hlpobj = new Help("C:\\Users\\cwikl\\IdeaProjects\\PodrecznikNaukiJava\\src\\helpfile.TXT");


            do {
                Help.showMenu();
                topic = hlpobj.getSelection();

                if(!hlpobj.helpOn(topic)){
                    if(topic.compareTo("stop") != 0)
                        System.out.println("Temat nie został odnaleziony.\n");

                }

            } while (topic.compareTo("stop") != 0);

        }
    }