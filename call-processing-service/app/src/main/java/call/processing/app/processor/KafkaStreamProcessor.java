// package call.processing.app.processor;

// import org.apache.kafka.streams.StreamsBuilder;
// import org.apache.kafka.streams.kstream.KStream;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Component;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import call.processing.app.model.CallModel;

// @Component
// public class KafkaStreamProcessor {
//     private final KafkaTemplate<String, String> kafkaTemplate;

//     public KafkaStreamProcessor(KafkaTemplate<String, String> kafkaTemplate) {
//         this.kafkaTemplate = kafkaTemplate;
//     }

//     @Autowired
//     public void process(StreamsBuilder streamsBuilder) {
//         // Define the stream from a topic
//         KStream<String, String> stream = streamsBuilder.stream("call-topic");

//         // Process the stream 
//         stream.foreach((key, value) -> {
//             System.out.println("Key: " + key + ", Value: " + value);

//             ObjectMapper mapper = new ObjectMapper();
//             CallModel callModel = CallParser.parseRawCallData(value);

//             try {
//                 String sentJson = mapper.writeValueAsString(callModel);
                
//                 // Send the processed data to another topic
//                 kafkaTemplate.send("refined-call-topic", callModel.getCallId(), sentJson);

//             } catch (JsonProcessingException e) {
//                 System.err.println("Error processing JSON: " + e.getMessage());
//                 e.printStackTrace();
//             }
//         });

//         // Optionally, transform or filter the stream
//         // KStream<String, String> filteredStream = stream.filter((key, value) -> value != null && !value.isEmpty());

//         // // Send to another topic (optional)
//         // filteredStream.to("output-topic");
//     }
    
// }
