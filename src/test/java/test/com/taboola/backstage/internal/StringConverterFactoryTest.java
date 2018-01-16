package test.com.taboola.backstage.internal;

import com.taboola.backstage.internal.StringConverterFactory;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Converter;
import test.com.taboola.backstage.BackstageTestBase;

/**
 * Created by vladi
 * Date: 1/16/2018
 * Time: 10:11 PM
 * By Taboola
 */
public class StringConverterFactoryTest extends BackstageTestBase {

    @Test
    public void testResponseBodyConverter() {
        StringConverterFactory testInstance = StringConverterFactory.create();

        Converter<ResponseBody, ?> responseConverter = testInstance.responseBodyConverter(String.class, null, null);
        Assert.assertNotNull("Invalid converter, expecting converter", responseConverter);

        responseConverter = testInstance.responseBodyConverter(Object.class, null, null);
        Assert.assertNull("Invalid converter, expecting no converter", responseConverter);
    }
}
