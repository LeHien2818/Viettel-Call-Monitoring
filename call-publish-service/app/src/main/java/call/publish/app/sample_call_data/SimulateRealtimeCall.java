package call.publish.app.sample_call_data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class SimulateRealtimeCall {
    public ArrayList<CallSequence> callSequences = new ArrayList<>();
    public ArrayList<String> agents = new ArrayList<>();
    public ArrayList<String> queues = new ArrayList<>();
    public ArrayList<String> phoneNumbers = new ArrayList<>();
    int simulatedSize = 10;
    public SimulateRealtimeCall() {
        // Initialize agents
        for (int i = 0; i < 20; i++) {
            agents.add("Agent_" + i + 1);
        }
        // Initialize queues
        for (int i = 0; i < 20; i++) {
            queues.add("Queue_" + i + 1);
        }
        // Initialize phone numbers
        for (int i = 0; i < simulatedSize; i++) {
            int phoneNumber = ThreadLocalRandom.current().nextInt(10000000, 100000000);
            phoneNumbers.add("0" + phoneNumber);
        }

        for (int i = 0; i < simulatedSize; i++) {
            int agentsSize = agents.size();
            int queuesSize = queues.size();
            int randomAgentIndex = ThreadLocalRandom.current().nextInt(0, agentsSize);
            int randomQueueIndex = ThreadLocalRandom.current().nextInt(0, queuesSize);
            String randomAgent = agents.get(randomAgentIndex);
            String randomQueue = queues.get(randomQueueIndex);
            CallSequence callSequence = new CallSequence();
            callSequence.changeAgent(randomAgent);
            callSequence.changeQueue(randomQueue);  
            callSequence.chageCallerNumber(phoneNumbers.get(i));
            callSequences.add(callSequence);
        }
    }
}
