package call.publish.app.config;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Deserializer;

public class GsonDeserializer<T> implements Deserializer<T> {
    private final Gson gson = new Gson();
    private final Class<T> type;

    public GsonDeserializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return gson.fromJson(new String(data), type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize data for topic: " + topic, e);
        }
    }
}
