package org.pieuler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class HexReader {

    private PrintStream out;

    public HexReader() {
        this.out = System.out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void read(String fileName) throws IOException {
        HexTextViewerBuffer buffer = new HexTextViewerBuffer(out);
        try (FileInputStream fis = new FileInputStream(fileName)) {
            int index = 0;
            for (byte b : fis.readAllBytes()) {
                boolean isNewLine = index % 0x10 == 0;
                if (isNewLine) {
                    buffer.flushStringBuffer();
                    buffer.updateOffset(index);
                }
                buffer.appendHex(b);
                buffer.appendChar(0x20 <= b ? (char) b : '.');
                index++;
            }
        }
    }

}
