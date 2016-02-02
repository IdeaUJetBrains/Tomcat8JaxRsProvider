package example.dynamicFeature;

import example.Empty;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.annotation.Priority;
import javax.ws.rs.GET;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;


@Provider
public class MyDynamicFeature implements DynamicFeature {
 
    @Override
    @Email
    public void configure(final ResourceInfo resourceInfo,
                          final FeatureContext context) {

        final String resourcePackage = resourceInfo.getResourceClass()
                .getPackage().getName();
        final Method resourceMethod = resourceInfo.getResourceMethod();
 
        if ("example.dynamicFeature".equals(resourcePackage)
                && resourceMethod.getAnnotation(GET.class) != null) {
            context.register(LoggingFilter.class);
            context.register(EmptyDyn.class);
            context.register(IEmptyDyn.class);
            context.register(MyBeanMessageBodyWriter.class);


        }
        System.out.print("MyDynamicFeature with LoggingFilter works!");
    }
}