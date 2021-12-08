package sample.communicationStorage;

import sample.specificPlace.Dialogue;

public class test2 {
    public static void main(String[] args) {
        Dialogue d = new Dialogue("123");
        String[] dia = d.getSentence();
        for (String s :
                dia) {
            System.out.println(s);
        }
    }
}
