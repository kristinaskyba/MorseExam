import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    public void convertSmallAtoMorse() {
        Logic convertor = new Logic();
        String testData = "a";
        String expected = ".-";
        String actual = convertor.convertLettersToMorse(testData);
        assertEquals(expected, actual);
    }
    @Test
    public void convertMorseToLetter() {
        Logic convertor = new Logic();
        String testData = ".-";
        String expected = "a";
        String actual = convertor.convertMorseToLetters(testData);
        assertEquals(expected, actual);
    }
    @Test
    public void convertBigAToMorse() {
        Logic converter = new Logic();
        String testData = "A";
        String expected = ".-";
        String actual = converter.convertLettersToMorse(testData);
        assertEquals(expected, actual);
    }

    @Test
    public void UnknownSymbolToEmptyString() {
        Logic convertor = new Logic();
        String testdata = "&";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = "";
        assertEquals(expected, actual);
    }
    @Test
    public void DoubleLettersToMorse() {
        Logic convertor = new Logic();
        String testdata = "aA";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = ".- .-";
        assertEquals(expected, actual);
    }
    @Test
    public void SentenceToMorse() {
        Logic convertor = new Logic();
        String testdata = "Cat cat";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = "-.- .- - / -.- .- -";
        assertEquals(expected, actual);
    }
    @Test
    public void SentenceToMorseWithSymbol() {
        Logic convertor = new Logic();
        String testdata = "cat &";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = "-.- .- - /";
        assertEquals(expected, actual);
    }
    @Test
    public void EmptyStringToMorse() {
        Logic convertor = new Logic();
        String testdata = " ";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = "/";
        assertEquals(expected, actual);
    }
    @Test
    public void BigSentenceToMorse() {
        Logic convertor = new Logic();
        String testdata = "I love my cat";
        String actual = convertor.convertLettersToMorse(testdata);
        String expected = ".. / .-.. --- ...- . / -- -.-- / -.- .- -";
        assertEquals(expected, actual);
    }
    @Test
    public void BigMorseToSentence() {
        Logic convertor = new Logic();
        String testdata = ".. / .-.. --- ...- . / -- -.-- / -.- .- -";
        String actual = convertor.convertMorseToLetters(testdata);
        String expected = "i love my cat";
        assertEquals(expected, actual);
    }
}