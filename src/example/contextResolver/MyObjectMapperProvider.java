package example.contextResolver;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


    @Provider
    @ConstrainedTo(RuntimeType.SERVER)
    public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {

        final ObjectMapper defaultObjectMapper;

        public MyObjectMapperProvider() {
            defaultObjectMapper = createDefaultMapper();
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return defaultObjectMapper;
        }

        private static ObjectMapper createDefaultMapper() {
            final ObjectMapper result = new ObjectMapper();
            result.configure(SerializationFeature.INDENT_OUTPUT, true);

            return result;
        }
    }





