package org.pieuler;

import java.io.PrintStream;

public class HexTextViewerBuffer {
    private final PrintStream out;
    private String offset;
    private StringBuffer hexBuffer;
    private StringBuffer charBuffer;

    public HexTextViewerBuffer(PrintStream out) {
        this.out = out;
        this.offset = "";
        this.hexBuffer = new StringBuffer();
        this.charBuffer = new StringBuffer();
    }

    public void updateOffset(int offset) {
        this.offset = String.format("%010X", offset);
    }
    public void appendHex(byte hex) {
        hexBuffer.append(String.format(" %02X", hex));
    }
    public void appendChar(char c) {
        charBuffer.append(c);
    }

    public void flushStringBuffer() {
        out.println(offset + "  " + hexBuffer + "  " + charBuffer);
        clearBuffers();
    }

    private void clearBuffers() {
        offset = "";
        hexBuffer.setLength(0);
        charBuffer.setLength(0);
    }
}