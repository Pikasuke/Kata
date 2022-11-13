public class Main {

    public static void main(String[] args) {
        findMissingLetter(new char[] { 'O','Q','R','S' });
        findMissingLetter(new char[] { 'a','b','c','d','f' });
    }

    public static char findMissingLetter(char[] array)
    {
        char [] alphabet = new char[] { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
        int alphPlace = 0;
        int stringPlace = 0;

        while (alphabet[alphPlace] != Character.toLowerCase(array[0])) {
            alphPlace++;
        }
        while (Character.toLowerCase(array[stringPlace]) == alphabet[alphPlace]) {
            alphPlace++;
            stringPlace++;
        }
        if (Character.isUpperCase(array[0])) {
            System.out.println("findMissingLetter " + Character.toUpperCase(alphabet[alphPlace]));
        } else {
            System.out.println("findMissingLetter " + alphabet[alphPlace]);
        }

        return Character.isUpperCase(array[0])? Character.toUpperCase(alphabet[alphPlace]) : alphabet[alphPlace];
    }
};