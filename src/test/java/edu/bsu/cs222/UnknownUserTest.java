package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnknownUserTest {

    @Test
    public void unknownUserTest() {
        UnknownUser testFormatting = new UnknownUser();
        String JSONstring = "{\"continue\":{\"rvcontinue\":\"20240105005539|1193670101\",\"continue\":\"||\"},\"query\":{\"pages\":{\"10672\":{\"pageid\":10672,\"ns\":0,\"title\":\"Frank Zappa\",\"revisions\":[{\"user\":\"24.143.118.36\",\"Anonymous\":\"\",\"timestamp\":\"2024-02-04T18:19:33Z\"}]}}}}\n";
        JSONArrayCreator arrayCreatorTest = new JSONArrayCreator(JSONstring);
        JSONArray JSONArray = arrayCreatorTest.createArray("$..revisions..user");
        JSONArray result = testFormatting.formatUnknownUsers(JSONArray);
        Assertions.assertEquals("Anonymous User",testFormatting.formatUnknownUsers(result).get(0).toString());
    }
}
