package A_independent_practice;


/**
 * 独立实践7.9.2

 *          使用StringReader/StringWriter类，将StringReader对象读出的
 * 值写入StringWriter对象中，编写程序，测试类中的方法。
 */
public class Exercise {
    public static void main(String[] args) {
        String data = "AABBCCDDEEFFGG";

        StringReader reader = new StringReader(data);
        StringWriter writer = new StringWriter();


        char[] buffer = new char[8];
        int length = 0;
        while  (      -1!=( length = reader.read(buffer, 0, buffer.length))    ) {
            writer.write(buffer, 0, length);
        }

        System.out.println("[Debug]==Output==>"+writer);
    }













    //以下为源码



    /**
     * A character stream whose source is a string.
     *
     * @author Mark Reinhold
     * @since JDK1.1
     */
    private static class StringReader {

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















    /**
     * A character stream that collects its output in a string buffer, which can
     * then be used to construct a string.
     * <p>
     * Closing a <tt>StringWriter</tt> has no effect. The methods in this class
     * can be called after the stream has been closed without generating an
     * <tt>IOException</tt>.
     *
     * @author Mark Reinhold
     * @since JDK1.1
     */
    private static class StringWriter {

        private StringBuffer buf;

        /**
         * Create a new string writer using the default initial string-buffer
         * size.
         */
        public StringWriter() {
            buf = new StringBuffer();
        }

        /**
         * Create a new string writer using the specified initial string-buffer
         * size.
         *
         * @param initialSize The number of <tt>char</tt> values that will fit into this buffer
         *                    before it is automatically expanded
         * @throws IllegalArgumentException If <tt>initialSize</tt> is negative
         */
        public StringWriter(int initialSize) {
            buf = new StringBuffer(initialSize);
        }

        /**
         * Write a single character.
         */
        public void write(int c) {
            buf.append((char) c);
        }

        /**
         * Write a portion of an array of characters.
         *
         * @param cbuf Array of characters
         * @param off  Offset from which to start writing characters
         * @param len  Number of characters to write
         */
        public void write(char cbuf[], int off, int len) {
//        if ((off < 0) || (off > cbuf.length) || (len < 0) ||
//                ((off + len) > cbuf.length) || ((off + len) < 0)) {
//            throw new IndexOutOfBoundsException();
//        } else
            if (len == 0) {
                return;
            }
            buf.append(cbuf, off, len);
        }

        /**
         * Write a string.
         */
        public void write(String str) {
            buf.append(str);
        }

        /**
         * Write a portion of a string.
         *
         * @param str String to be written
         * @param off Offset from which to start writing characters
         * @param len Number of characters to write
         */
        public void write(String str, int off, int len) {
            buf.append(str.substring(off, off + len));
        }

        /**
         * Appends the specified character sequence to this writer.
         *
         * <p> An invocation of this method of the form <tt>out.append(csq)</tt>
         * behaves in exactly the same way as the invocation
         *
         * <pre>
         *     out.write(csq.toString()) </pre>
         *
         * <p> Depending on the specification of <tt>toString</tt> for the
         * character sequence <tt>csq</tt>, the entire sequence may not be
         * appended. For instance, invoking the <tt>toString</tt> method of a
         * character buffer will return a subsequence whose content depends upon
         * the buffer's position and limit.
         *
         * @param csq The character sequence to append.  If <tt>csq</tt> is
         *            <tt>null</tt>, then the four characters <tt>"null"</tt> are
         *            appended to this writer.
         * @return This writer
         * @since 1.5
         */
        public StringWriter append(CharSequence csq) {
            if (csq == null)
                write("null");
            else
                write(csq.toString());
            return this;
        }

        /**
         * Appends a subsequence of the specified character sequence to this writer.
         *
         * <p> An invocation of this method of the form <tt>out.append(csq, start,
         * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
         * exactly the same way as the invocation
         *
         * <pre>
         *     out.write(csq.subSequence(start, end).toString()) </pre>
         *
         * @param csq   The character sequence from which a subsequence will be
         *              appended.  If <tt>csq</tt> is <tt>null</tt>, then characters
         *              will be appended as if <tt>csq</tt> contained the four
         *              characters <tt>"null"</tt>.
         * @param start The index of the first character in the subsequence
         * @param end   The index of the character following the last character in the
         *              subsequence
         * @return This writer
         * @throws IndexOutOfBoundsException If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
         *                                   is greater than <tt>end</tt>, or <tt>end</tt> is greater than
         *                                   <tt>csq.length()</tt>
         * @since 1.5
         */
        public StringWriter append(CharSequence csq, int start, int end) {
            CharSequence cs = (csq == null ? "null" : csq);
            write(cs.subSequence(start, end).toString());
            return this;
        }

        /**
         * Appends the specified character to this writer.
         *
         * <p> An invocation of this method of the form <tt>out.append(c)</tt>
         * behaves in exactly the same way as the invocation
         *
         * <pre>
         *     out.write(c) </pre>
         *
         * @param c The 16-bit character to append
         * @return This writer
         * @since 1.5
         */
        public StringWriter append(char c) {
            write(c);
            return this;
        }

        /**
         * Return the buffer's current value as a string.
         */
        public String toString() {
            return buf.toString();
        }

    }

}
