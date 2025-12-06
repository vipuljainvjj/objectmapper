import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Amount {

    @JsonDeserialize(using = BigDecimal2JsonDeserializer.class)
    BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

class BigDecimal2JsonDeserializer extends NumberDeserializers.BigDecimalDeserializer {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        System.out.println(p);
        System.out.println(p.currentTokenId());
        BigDecimal value = super.deserialize(p, ctxt);
        value = value.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(value);
        return value;
    }
}
