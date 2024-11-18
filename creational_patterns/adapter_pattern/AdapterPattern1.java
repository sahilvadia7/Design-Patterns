package creational_patterns.adapter_pattern;

// Target Interface (English Speaker expects this interface)
interface EnglishSpeaker {
    void speakEnglish(String words);
}

// Adaptee Class (French Speaker)
class FrenchSpeaker {
    void greet(String mots) {
        System.out.println("Translate in Franch: " + mots);
    }
}
// Adapter Class (Translator)
class TranslatorAdapter implements EnglishSpeaker {
    private FrenchSpeaker frenchSpeaker;

    public TranslatorAdapter(FrenchSpeaker frenchSpeaker) {
        this.frenchSpeaker = frenchSpeaker;
    }

    @Override
    public void speakEnglish(String words) {
        // Translate English to French for the French speaker
        String translatedWords = translateToFrench(words);
        frenchSpeaker.greet(translatedWords);
    }

    private String translateToFrench(String englishWords) {
        // A mock translation for simplicity
        if (englishWords.equalsIgnoreCase("Hello")) return "Bonjour";
        return "Traduction inconnue";
    }
}

// Client Code
public class AdapterPattern1 {
    public static void main(String[] args) {
        // Adaptee (French speaker)
        FrenchSpeaker frenchBuddy = new FrenchSpeaker();

        // Adapter (Translator)
        EnglishSpeaker translator = new TranslatorAdapter(frenchBuddy);

        // Client (English speaker communicates through the adapter)
        translator.speakEnglish("Hello");
    }
}

