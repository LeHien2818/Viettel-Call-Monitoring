// package call.publish.app.config;

// import java.util.HashMap;
// import java.util.Map;

// import org.apache.kafka.common.serialization.Serdes;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafkaStreams;
// import org.springframework.kafka.config.KafkaStreamsConfiguration;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.ProducerFactory;
// import org.apache.kafka.clients.producer.ProducerConfig;

// @Configuration
// public class KafkaStreamConfig {
//     public ProducerFactory kafkaStreamsConfiguration() {
//         final Map<String, Object> props = new HashMap<>();
//         props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.17.0.1:9092");
//         props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//         props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class);

//         return new DefaultKafkaProducerFactory<>(props);
//     }
// }