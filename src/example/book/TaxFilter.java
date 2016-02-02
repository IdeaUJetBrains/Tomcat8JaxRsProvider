package example.book;

import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Olga Pavlova on 2/2/2016.
 */
@ConstrainedTo(RuntimeType.SERVER)
public class TaxFilter implements ClientRequestFilter {
        public static final BigDecimal TAX_RATE = new BigDecimal("2.5");

        @Override
        public void filter(final ClientRequestContext rc) throws IOException
        {
            String method = rc.getMethod();
            if ("POST".equals(method) && rc.hasEntity()) {
                Book book = (Book) rc.getEntity();
                BigDecimal priceWithTaxes = book.getPrice().multiply(TAX_RATE);
                book.setPrice(priceWithTaxes);
                rc.setEntity(book);
            }
        }
}
