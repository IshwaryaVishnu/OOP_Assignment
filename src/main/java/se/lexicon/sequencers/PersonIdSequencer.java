package se.lexicon.sequencers;

public class PersonIdSequencer {
    private static int currentId;


    public static int nextId() {
        return currentId + 1;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonIdSequencer.currentId = currentId;
    }

}
