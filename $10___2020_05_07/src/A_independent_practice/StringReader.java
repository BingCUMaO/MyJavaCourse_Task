package A_independent_practice;


/**
 * A character stream whose source is a string.
 *
 * @author Mark Reinhold
 * @since JDK1.1
 */

public class StringReader {

    private String str;
    private int length;
    private int next = 0;

    /**
     * Creates a new string reader.
     *
     * @param s String providing the character stream.
     */
    public StringReader(String s) {
        this.str = s;
        this.length = s.length();
    }

    /**
     * Reads a single character.
     *
     * @return The character read, or -1 if the end of the stream has been
     * reached
     */
    public int read() {
        if (next >= length)
            return -1;
        return str.charAt(next++);
    }

    /**
     * Reads characters into a portion of an array.
     *
     * @param cbuf Destination buffer
     * @param off  Offset at which to start writing characters
     * @param len  Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the
     * stream has been reached
     */
    public int read(char cbuf[], int off, int len) {

//            if ((off < 0) || (off > cbuf.length) || (len < 0) ||
//                    ((off + len) > cbuf.length) || ((off + len) < 0)) {
//                throw new IndexOutOfBoundsException();
//            } else if (len == 0) {
//                return 0;
//            }
        if (next >= length)
            return -1;
        int n = Math.min(length - next, len);
        str.getChars(next, next + n, cbuf, off);
        next += n;
        return n;
    }
}
