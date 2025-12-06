import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperDeserialize {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        String str = "{\"value\": 50.897878}";
        Amount amount = null;
        try {
            amount = mapper.readValue(str, Amount.class);
        } catch (Exception exp) {}

        System.out.println(amount.getValue());

    }
}
