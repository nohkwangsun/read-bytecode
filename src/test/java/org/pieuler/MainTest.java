package org.pieuler;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainTest {

    @Test
    void readClass() throws IOException {
        HexReader reader = new HexReader();
        String fileName = "target/classes/org/example/HexReader.class";
        System.out.printf("[%s]", fileName);
        reader.read(fileName);
    }
}