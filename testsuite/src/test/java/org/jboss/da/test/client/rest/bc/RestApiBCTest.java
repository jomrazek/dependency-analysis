package org.jboss.da.test.client.rest.bc;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.jboss.da.test.client.rest.AbstractRestBCTest;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.JSONException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class RestApiBCTest extends AbstractRestBCTest {

    private static final String PATH_BC_START = "/build-configuration/generate/product/start-process";

    private static final String PATH_BC_ITERATE = "/build-configuration/generate/product/analyse-next-level";

    private static final String PATH_BC_FINISH = "/build-configuration/generate/product/finish-process";

    @Test
    public void testStartDAParent() throws IOException, Exception {
        ClientResponse<String> response = assertResponseForRequest(PATH_BC_START, "da-parent");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testIterateDAApplication() throws IOException, Exception {
        ClientResponse<String> response = assertResponseForRequest(PATH_BC_ITERATE,
                "da-application-1");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testStartDACommon() throws IOException, Exception {
        ClientResponse<String> response = assertResponseForRequest(PATH_BC_START, "da-common");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testIterateDACommon() throws IOException, Exception {
        ClientResponse<String> response = assertResponseForRequest(PATH_BC_ITERATE, "da-common-1");
        assertEquals(200, response.getStatus());
    }

    @Test
    @Ignore
    public void testFinishDAParent() throws IOException, Exception {
        File jsonRequestFile = getJsonRequestFile(PATH_BC_FINISH, "da-parent");
        String input = FileUtils.readFileToString(jsonRequestFile, "utf-8");
        String number = Integer.toString(new Random().nextInt());
        ClientRequest request = createClientRequest(PATH_BC_FINISH,
                input.replace("PLACEHOLDER", number));
        ClientResponse<String> response = request.post(String.class);
        System.out.println("Response: " + response.getEntity());
    }

    @Override
    protected void assertEqualsJson(String expected, String actual) {
        try {
            JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
        } catch (JSONException ex) {
            fail("The test wasn't able to compare JSON strings" + ex);
        }
    }

}
