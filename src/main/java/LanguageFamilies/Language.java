package LanguageFamilies;

public class Language {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

    Language(String name, int speaks, String region, String order) {
        this.name = name;
        numSpeakers = speaks;
        regionsSpoken = region;
        wordOrder = order;
    }

    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken);
        System.out.println("The language follows the word order: " + this.wordOrder);
    }

    public static void main(String[] args) {
        var ukrainian = new Language("Ukrainian", 150000000, "Eastern Europe",
                "doesn`t matter");
        ukrainian.getInfo();
        System.out.println();
        Language chuj = new Mayan("Chuj", 3200);
        chuj.getInfo();
        System.out.println();
        Language mandarin = new SinoTibetan("Mandarin Chinese", 4900000);
        mandarin.getInfo();
        System.out.println();
        Language burmese = new SinoTibetan("Burmese", 100000);
        burmese.getInfo();

    }

}

/*Build an array or ArrayList of several language objects and loop through them to call getInfo().
Add new methods that allow users to set a specific region, change the number of speakers, or modify the word order.
Create several more language family classes that pertain to languages you’re interested in.
Map out the sign language families.
Add in further linguistic features (e.g., which genders are used, whether the language is tonal, etc.).*/