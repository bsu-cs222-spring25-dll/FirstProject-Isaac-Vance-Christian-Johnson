package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class RevisionPrinterTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    public void printingRevisionsTest() {
        RevisionGetter testPrinter = new RevisionGetter("{\"continue\":{\"rvcontinue\":\"20240105072531|1193716233\",\"continue\":\"||\"},\"query\":{\"normalized\":[{\"from\":\"zappa\",\"to\":\"Zappa\"}],\"redirects\":[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}],\"pages\":{\"10672\":{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"24.143.118.36\",\"Anonymous User\":\"\",\"timestamp\":\"2024-02-04T18:19:33Z\"}]}}}}\n");
        testPrinter.createAndFormatArray();
        testPrinter.printRevisions();
        Assertions.assertNotNull(outputStream.toString());
    }

    @Test
    public void checkRedirectsTest() {
        RevisionGetter testRedirect = new RevisionGetter("sample.json");
        testRedirect.checkRedirects();
        Assertions.assertFalse(outputStream.toString().contains("Redirected"));
    }
}
