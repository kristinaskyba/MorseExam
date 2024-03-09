import java.util.HashMap;

public class Logic {

    private final HashMap<String, String> info = new HashMap<>();
    private final HashMap<String, String> reverseInfo = new HashMap<>();

    public Logic() {
        info.put("a", ".-");
        info.put("b", "-...");
        info.put("c", "-.-");
        info.put("d", "-..");
        info.put("e", ".");
        info.put("f", "..-.");
        info.put("g", "--.");
        info.put("h", "....");
        info.put("i", "..");
        info.put("j", ".---");
        info.put("k", "-.");
        info.put("l", ".-..");
        info.put("m", "--");
        info.put("n", "-.");
        info.put("o", "---");
        info.put("p", ".--.");
        info.put("q", "--.-");
        info.put("r", ".-.");
        info.put("s", "...");
        info.put("t", "-");
        info.put("u", "..-");
        info.put("v", "...-");
        info.put("w", ".--");
        info.put("x", "-..-");
        info.put("y", "-.--");
        info.put("z", "--..");
        info.put("1", ".----");
        info.put("2", "..---");
        info.put("3", "...--");
        info.put("4", "....-");
        info.put("5", ".....");
        info.put("6", "-....");
        info.put("7", "--...");
        info.put("8", "---..");
        info.put("9", "----.");
        info.put("0", "-----");
        info.put(".", ".-.-.-");
        info.put(",", "--..--");
        info.put("?", "..--..");

        for (String key : info.keySet()) {
            String value = info.get(key);
            reverseInfo.put(value, key);
        }
        //info.forEach((key, value) -> reverseInfo.put(value, key));
       /* for (HashMap.Entry<String, String> entry : info.entrySet()) {
            reverseInfo.put(entry.getValue(), entry.getKey());
        }*/
    }

    public String convertLettersToMorse(String sentence) {
        sentence = sentence.toLowerCase();
        String morseCode = "";
        for (char eachWord : sentence.toCharArray()) {
            String eachLetter = Character.toString(eachWord);
            if (info.containsKey(eachLetter)) {
                morseCode += info.get(eachLetter) + " ";
            } else if (Character.isWhitespace(eachWord)) {
                morseCode += "/ "; // Here I add "/" between words
            } else {
                System.out.println("This symbol is unknown: " + eachWord);
            }
        }
        return morseCode.trim(); //<-- FMI: to avoid issues with @test in case there is a space after morse
    }

    public String convertMorseToLetters(String morseCode) {
        String result = " ";
        String[] morseWords = morseCode.split(" ");
        for (String eachMorseWord : morseWords) {
            if (eachMorseWord.equals("/")) {
                result += " ";
            } else {
                String letter = reverseInfo.get(eachMorseWord);
                if (letter != null && ! letter.isEmpty()) { //<--- in case code is not existing in HashMap
                    result += letter.toLowerCase();
                } else {
                    result += " " + "Unknown code";
                }
            }
        }
        return result.trim();
    }

    public static void printCatAscii() {
        String catAscii =
                " /\\_/\\\n" +
                        "( o.o )\n" +
                        " > ^ <";

        System.out.println(catAscii);
    }
}