package com.example.trigram;

import com.example.exception.FileOperationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static com.example.utils.TestUtil.*;
import static org.junit.Assert.*;

public class TrigramGeneratorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void noFileProvidedThenFail() throws FileOperationException {
        expectedException.expect(FileOperationException.class);
        expectedException.expectMessage(ERROR_WHILE_FETCHING_FILE);
        TrigramGenerator trigramGenerator = new TrigramGenerator(FILE_PATH_INVALID, TOM_SWIFT_NEW_VERSION_FILE_PATH);
    }

    @Test
    public void fileWithSingleWordThenFail() throws FileOperationException {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(ERROR_MESSAGE_ATLEAST_THREE_WORDS);
        TrigramGenerator trigramGenerator = new TrigramGenerator(INPUT_SINGLE_LINE_FILE_PATH, TOM_SWIFT_NEW_VERSION_FILE_PATH);
    }

    @Test
    public void generateTrigramsForTomSwiftBookSuccess() throws FileOperationException {
        TrigramGenerator generator = new TrigramGenerator(TOM_SWIFT_FILE_PATH, TOM_SWIFT_NEW_VERSION_FILE_PATH);
        Map<String, Trigram> trigrams = generator.getTrigrams();

        assertEquals(27514, trigrams.keySet().size());

        assertTrue(trigrams.containsKey("the project"));
        assertTrue(trigrams.containsKey("project gutenberg"));
        assertTrue(trigrams.containsKey("tom swift"));
        assertTrue(trigrams.containsKey("his airship"));

        assertEquals("Tom", trigrams.get("ebook of").getNextValue());
        assertEquals(1, trigrams.get("ebook of").values().size());
    }

    @Test
    public void provideTomSwiftFileThenSuccess() throws FileOperationException, IOException {
        TrigramGenerator trigramGenerator = new TrigramGenerator(TOM_SWIFT_FILE_PATH, TOM_SWIFT_NEW_VERSION_FILE_PATH);
        assertNotNull(Files.readString(Path.of(TOM_SWIFT_NEW_VERSION_FILE_PATH)));
    }

    @Test
    public void provideIWishFileThenSuccess() throws FileOperationException, IOException {
        TrigramGenerator trigramGenerator = new TrigramGenerator(IWISH_FILE_PATH, IWISH_NEW_VERSION_FILE_PATH);
        assertNotNull(Files.readString(Path.of(IWISH_NEW_VERSION_FILE_PATH)));
    }

    //Enable to test outofmemory exception
    //@Test
    public void outOfMemoryExceptionFail() throws FileOperationException {
        TrigramGenerator trigramGenerator = new TrigramGenerator(OUTOFMEMORY_ERROR_FILE_PATH, TOM_SWIFT_NEW_VERSION_FILE_PATH);
    }

}
