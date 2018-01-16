package test.com.taboola.backstage.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taboola.backstage.internal.SynchronousCallAdapterFactory;
import com.taboola.backstage.model.media.campaigns.Campaign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.CallAdapter;
import test.com.taboola.backstage.BackstageTestBase;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 10:16 PM
 * By Taboola
 */
public class SynchronousCallAdapterFactoryTest extends BackstageTestBase {

    private SynchronousCallAdapterFactory testInstance;

    @Before
    public void beforeTest() {
        testInstance = SynchronousCallAdapterFactory.create(new ObjectMapper());
    }

    @Test
    public void testSynchronousAdapterForNonCallType() {
        CallAdapter<Object, Object> actualAdapter = testInstance.get(Campaign.class, null, null);
        Assert.assertNotNull("Invalid adapter, expecting adapter", actualAdapter);
        Assert.assertEquals("Invalid adapter type", Campaign.class, actualAdapter.responseType());

        actualAdapter = testInstance.get(Object.class, null, null);
        Assert.assertNotNull("Invalid adapter, expecting adapter", actualAdapter);
        Assert.assertEquals("Invalid adapter type", Object.class, actualAdapter.responseType());
    }

    @Test
    public void testSynchronousAdapterForCallType() {
        CallAdapter<Object, Object> actualAdapter = testInstance.get(Call.class, null, null);
        Assert.assertNull("Invalid adapter, expecting no adapter", actualAdapter);
    }

    //TODO add more tests - retrofit2#Response.class is final therefore mockito is not working on it
}
