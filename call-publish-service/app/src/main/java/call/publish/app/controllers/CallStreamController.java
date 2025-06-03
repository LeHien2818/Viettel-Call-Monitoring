package call.publish.app.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import call.publish.app.model.CallEvent;
import call.publish.app.model.CustomChannelVars;

@RestController
@RequestMapping("/push-call")

public class CallStreamController {

    private final KafkaTemplate<String, CallEvent> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public CallStreamController(KafkaTemplate<String, CallEvent> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    // Simulate a real-time call
    @GetMapping
    public ResponseEntity simulateRealTime() {
        int callNumbers = 100;
        int agentNumbers = 10;
        int queueNumbers = agentNumbers;
        // CallSequence seedCallSequence = new CallSequence();
        try {
            // Gson gson = new Gson();
            // CallEvent callEventCreateIn = gson.fromJson(seedCallSequence.channelCreateIn.toString(), CallEvent.class);
            // CallEvent callEventQueue = gson.fromJson(seedCallSequence.channelQueue.toString(), CallEvent.class);
            // CallEvent callEventCreateOut = gson.fromJson(seedCallSequence.channelCreateOut.toString(), CallEvent.class);
            // CallEvent callEventAnsIn = gson.fromJson(seedCallSequence.channelCreateAnswerIn.toString(), CallEvent.class);
            // CallEvent callEventAnsOut = gson.fromJson(seedCallSequence.channelCreateAnswerOut.toString(), CallEvent.class);
            // CallEvent callEventBridge = gson.fromJson(seedCallSequence.channelBridge.toString(), CallEvent.class);
            // CallEvent callEventDestroyIn = gson.fromJson(seedCallSequence.channelDestroyIn.toString(), CallEvent.class);
            // CallEvent callEventUnbridge = gson.fromJson(seedCallSequence.channelUnbridge.toString(), CallEvent.class);
            // CallEvent callEventDestroyOut = gson.fromJson(seedCallSequence.channelDestroyOut.toString(), CallEvent.class);

            // System.out.println("CallEvent Queue: " + callEventDestroyOut.toString());
            

            long unixTimeMs = java.time.Instant.now().toEpochMilli();

            // Simulate agents
            ArrayList<String> agentIds = new ArrayList<>();
            for(int i = 0; i < agentNumbers; i++){
                String agentId = "agent-" + (i + 1);
                agentIds.add(agentId);
            }

            // Simulate process in one queue

            // Simulate call queues
            ArrayList<Queue<CallEvent>> callQueues = new ArrayList<>();
            for(int i = 0; i < queueNumbers; i++){
                Queue<CallEvent> callQueue = new LinkedList<>();
                String agentId = "agent-" + (i + 1);
                int startIndex = i * (callNumbers / queueNumbers);
                int endIndex = (i + 1) * (callNumbers / queueNumbers);

                ArrayList<Queue<CallEvent>> callQueueList = new ArrayList<>();
                for(int j = startIndex; j < endIndex; j++){
                    long randomPhoneNumber = ThreadLocalRandom.current().nextLong(100000000L, 999999999L);
                    String accountId = "account-" + (j + 1);

                    Queue<CallEvent> callQueueItem = new LinkedList<>();

                    // Create In event
                    CallEvent createIn = new CallEvent();
                    createIn.setEventName("CHANNEL_CREATE");
                    createIn.setCallID("call-" + (j + 1));
                    createIn.setPresenceID("392975086@10.51.9.7");
                    createIn.setCallerIDNumber("0" + randomPhoneNumber);
                    createIn.setCallerIDName("0"+ randomPhoneNumber);
                    createIn.setFrom(randomPhoneNumber + "@" + "10.51.9.7");
                    createIn.setFromUri(randomPhoneNumber + "@" + "10.51.9.7");
                    createIn.setTo("1068@10.52.125.35");
                    createIn.setToUri("1068@10.52.125.35");
                    createIn.setCallDirection("inbound");
                    createIn.setChannelCreatedTimeMs(unixTimeMs);
                    createIn.setRequest("1068@10.52.125.35");
                    createIn.setCavs(new JsonObject());
                    createIn.setCshs(JsonParser.parseString(
                    "{\"X-AUTH-PORT\":\"5060\",\"X-AUTH-IP\":\"10.51.9.7\",\"P-Early-Media\":\"supported\",\"P-Charging-Vector\":\"icid-value=SIkgAAW7Cdfee2CyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"}"
                ).getAsJsonObject());
                    createIn.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    createIn.setCcvs(new CustomChannelVars(accountId));

                    callQueueItem.add(createIn);

                    // Queue event
                    CallEvent queueEvent = new CallEvent();
                    queueEvent.setEventName("CHANNEL_QUEUE");
                    queueEvent.setCallID("call-" + (j + 1));
                    queueEvent.setAccountId(accountId);
                    queueEvent.setCallerIDName("0" + randomPhoneNumber);
                    queueEvent.setCallerIDNumber("0" + randomPhoneNumber);
                    queueEvent.setFrom(randomPhoneNumber + "@" + "10.51.9.7");
                    queueEvent.setTo("1068@" + "10.52.125.35");
                    queueEvent.setRequest("1068@" + "10.52.125.35");
                    queueEvent.setCalleeIDNumber("1068");
                    queueEvent.setCallDirection("inbound");
                    queueEvent.setChannelCreatedTimeMs(unixTimeMs);
                    queueEvent.setCavs(JsonParser.parseString("{\"voiceChannelNumber\":\"1068\",\"cf_route_request\":\"1068@10.52.125.35\",\"cf_route_id\":\"1747580617706-d6096a3f\",\"distribute\":\"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\"channel\":\"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\"IPCCBLACKLIST_1068\":\"0\",\"member_customer_level\":\"0\",\"originalVoiceChannelNumber\":\"1068\"}").getAsJsonObject());
                    queueEvent.setCshs(JsonParser.parseString("{\"X-AUTH-PORT\":\"5060\",\"X-AUTH-IP\":\"10.51.9.7\",\"P-Early-Media\":\"supported\",\"P-Charging-Vector\":\"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"}").getAsJsonObject());
                    queueEvent.setSwitchNodename("fs8621@ipcc-02.local");
                    queueEvent.setIcvs(JsonParser.parseString("{\"CHANNEL_QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\"}").getAsJsonObject());
                    
                    CustomChannelVars ccvs = new CustomChannelVars();
                    ccvs.setAccountID(accountId);
                    ccvs.setAccountName("cc");
                    ccvs.setCallInteractionID("63914799817-4c9864f4");
                    ccvs.setResourceType("offnet-origination");
                    ccvs.setOverflowID("1747580617834-8d4093c9");
                    ccvs.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvs.setVcNumber("1068");
                    ccvs.setApplicationZone("hni6");
                    ccvs.setZoneWithAcdc(true);
                    ccvs.setCustomerLevel("0");

                    queueEvent.setCcvs(ccvs);
                    callQueueItem.add(queueEvent);

                    // Create Out event
                    CallEvent createOut = new CallEvent();
                    createOut.setEventName("CHANNEL_CREATE");
                    createOut.setCallID("other-call-" + (j + 1));
                    createOut.setPresenceID("161704@cc.ipcc.vn");
                    createOut.setOtherLegCallID("0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439");
                    createOut.setCallerIDName("0" + randomPhoneNumber);
                    createOut.setCallerIDNumber("0" + randomPhoneNumber);
                    createOut.setFrom("nouser@cc.ipcc.vn");
                    createOut.setTo("161704@cc.ipcc.vn");
                    createOut.setRequest(agentId+"@cc.ipcc.vn");
                    createOut.setCalleeIDNumber("+841068");
                    createOut.setCallDirection("outbound");
                    createOut.setChannelCreatedTimeMs(unixTimeMs);
                    createOut.setCavs(new JsonObject());
                    createOut.setCshs(JsonParser.parseString("{\"X-KAZOO-INVITE-FORMAT\":\"contact\",\"X-KAZOO-AOR\":\"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\"MYCC-VIDEO\":\"false\",\"MYCC-QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\",\"MYCC-MEMBER-CALL-ID\":\"BACAA2C7283C4151C4F2B897@3470ffffffff\",\"MYCC-HIDE-CALLER-ID\":\"false\"}").getAsJsonObject());
                    createOut.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    createOut.setSwitchNodename("fs8621@ipcc-02.local");
                    createOut.setSmartRouting(false);
                    createOut.setSmartRoutingExit(false);

                    CustomChannelVars ccvsOut = new CustomChannelVars();
                    ccvsOut.setUsername(agentId);
                    ccvsOut.setAccountID(accountId);
                    ccvsOut.setAccountName("cc");
                    ccvsOut.setCallInteractionID("63914799818-7dc3edc1");
                    ccvsOut.setOwnerID("52412226da14f0de88bba67077a69bc6");
                    ccvsOut.setQueueID("Queue-" + (i + 1));
                    ccvsOut.setOverflowID("1747580617834-8d4093c9");
                    ccvsOut.setMemberCallID("BACAA2C7283C4151C4F2B897@3470ffffffff");
                    ccvsOut.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsOut.setVcNumber("1068");

                    createOut.setCcvs(ccvsOut);
                    callQueueItem.add(createOut);


                    // Answer In event
                    CallEvent answerIn = new CallEvent();
                    answerIn.setEventName("CHANNEL_ANSWER");
                    answerIn.setCallID("call-" + (j + 1));
                    answerIn.setCallerIDName("0" + randomPhoneNumber);
                    answerIn.setCallerIDNumber("0" + randomPhoneNumber);
                    answerIn.setFrom(randomPhoneNumber + "@" + "10.51.9.7");
                    answerIn.setFromUri(randomPhoneNumber + "@" + "10.51.9.7");
                    answerIn.setTo("1068@10.52.125.35");
                    answerIn.setToUri("1068@10.52.125.35");
                    answerIn.setRequest("1068@10.52.125.35");
                    answerIn.setCallDirection("inbound");
                    answerIn.setChannelCreatedTimeMs(unixTimeMs);
                    answerIn.setCavs(JsonParser.parseString("{\"IPCCBLACKLIST_1068\":\"0\",\"cf_route_id\":\"1747580617706-d6096a3f\",\"cf_route_request\":\"1068@10.52.125.35\",\"channel\":\"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\"distribute\":\"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\"member_customer_level\":\"0\",\"originalVoiceChannelNumber\":\"1068\",\"voiceChannelNumber\":\"1068\"}").getAsJsonObject());
                    answerIn.setCshs(JsonParser.parseString("{\"P-Early-Media\":\"supported\",\"P-Charging-Vector\":\"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"}").getAsJsonObject());
                    answerIn.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    answerIn.setSwitchNodename("fs8621@ipcc-02.local");
                    answerIn.setSmartRouting(false);
                    answerIn.setSmartRoutingExit(false);

                    CustomChannelVars ccvsAnsIn = new CustomChannelVars();
                    ccvsAnsIn.setAccountID(accountId);
                    ccvsAnsIn.setAccountName("cc");
                    ccvsAnsIn.setCallInteractionID("63914799817-4c9864f4");
                    ccvsAnsIn.setBridgeID("da92390c8c96b7cdebc9f5a6d8963710");
                    ccvsAnsIn.setResourceType("offnet-origination");
                    ccvsAnsIn.setQueueID("Queue-" + (i + 1));
                    ccvsAnsIn.setOverflowID("1747580617834-8d4093c9");
                    ccvsAnsIn.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsAnsIn.setVcNumber("1068");
                    ccvsAnsIn.setApplicationZone("hni6");
                    ccvsAnsIn.setZoneWithAcdc(true);
                    ccvsAnsIn.setCustomerLevel("0");
                    
                    answerIn.setCcvs(ccvsAnsIn);
                    callQueueItem.add(answerIn);

                    // Answer Out event
                    CallEvent answerOut = new CallEvent();
                    answerOut.setEventName("CHANNEL_ANSWER");
                    answerOut.setCallID("other-call-" + (j + 1));
                    answerOut.setPresenceID("161704@cc.ipcc.vn");
                    answerOut.setOtherLegCallID("other-call-" + (j + 1));
                    answerOut.setCallerIDName("0" + randomPhoneNumber);
                    answerOut.setCallerIDNumber("0" + randomPhoneNumber);
                    answerOut.setFrom("0" + randomPhoneNumber + "@cc.ipcc.vn");
                    answerOut.setFromUri("0" + randomPhoneNumber + "@cc.ipcc.vn");
                    answerOut.setTo(agentId + "@cc.ipcc.vn");
                    answerOut.setToUri(agentId + "@cc.ipcc.vn");
                    answerOut.setRequest(agentId + "@cc.ipcc.vn");
                    answerOut.setCalleeIDNumber("+841068");
                    answerOut.setCallDirection("outbound");
                    answerOut.setChannelCreatedTimeMs(unixTimeMs);
                    answerOut.setCavs(new JsonObject());
                    answerOut.setCshs(JsonParser.parseString("{\"X-KAZOO-INVITE-FORMAT\":\"contact\",\"X-KAZOO-AOR\":\"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\"MYCC-VIDEO\":\"false\",\"MYCC-QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\",\"MYCC-MEMBER-CALL-ID\":\"BACAA2C7283C4151C4F2B897@3470ffffffff\",\"MYCC-HIDE-CALLER-ID\":\"false\"}").getAsJsonObject());
                    answerOut.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    answerOut.setSwitchNodename("fs8621@ipcc-02.local");
                    answerOut.setSmartRouting(false);
                    answerOut.setSmartRoutingExit(false);
                    CustomChannelVars ccvsAnsOut = new CustomChannelVars();
                    ccvsAnsOut.setUsername(agentId);
                    ccvsAnsOut.setAccountID(accountId);
                    ccvsAnsOut.setAccountName("cc");
                    ccvsAnsOut.setCallInteractionID("63914799818-7dc3edc1");
                    ccvsAnsOut.setOwnerID("52412226da14f0de88bba67077a69bc6");
                    ccvsAnsOut.setQueueID("Queue-" + (i + 1));
                    ccvsAnsOut.setOverflowID("1747580617834-8d4093c9");
                    ccvsAnsOut.setMemberCallID("BACAA2C7283C4151C4F2B897@3470ffffffff");
                    ccvsAnsOut.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsAnsOut.setVcNumber("1068");
                    answerOut.setCcvs(ccvsAnsOut);

                    callQueueItem.add(answerOut);

                    // Bridge event
                    CallEvent bridgeEvent = new CallEvent();
                    bridgeEvent.setEventName("CHANNEL_BRIDGE");
                    bridgeEvent.setCallID("other-call-" + (j + 1));
                    bridgeEvent.setPresenceID(agentId + "@cc.ipcc.vn");
                    bridgeEvent.setOtherLegCallID("call-" + (j + 1));
                    bridgeEvent.setOtherLegDirection("inbound");
                    bridgeEvent.setOtherLegDestinationNumber("1068");
                    bridgeEvent.setCallerIDName("0" + randomPhoneNumber);
                    bridgeEvent.setCallerIDNumber("0" + randomPhoneNumber);
                    bridgeEvent.setCallerIDName("0" + randomPhoneNumber);
                    bridgeEvent.setCalleeIDNumber("+841068");
                    bridgeEvent.setCallDirection("outbound");
                    bridgeEvent.setChannelCreatedTimeMs(unixTimeMs);
                    bridgeEvent.setCavs(new JsonObject());
                    bridgeEvent.setCshs(JsonParser.parseString("{\"X-KAZOO-INVITE-FORMAT\":\"contact\",\"X-KAZOO-AOR\":\"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\"MYCC-VIDEO\":\"false\",\"MYCC-QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\",\"MYCC-MEMBER-CALL-ID\":\"BACAA2C7283C4151C4F2B897@3470ffffffff\",\"MYCC-HIDE-CALLER-ID\":\"false\"}").getAsJsonObject());
                    bridgeEvent.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    bridgeEvent.setSwitchNodename("fs8621@ipcc-02.local");
                    bridgeEvent.setSmartRouting(false);
                    bridgeEvent.setSmartRoutingExit(false);
                    CustomChannelVars ccvsBridge = new CustomChannelVars();
                    ccvsBridge.setUsername(agentId);
                    ccvsBridge.setAccountID(accountId);
                    ccvsBridge.setAccountName("cc");
                    ccvsBridge.setCallInteractionID("63914799818-7dc3edc1");
                    ccvsBridge.setOwnerID("52412226da14f0de88bba67077a69bc6");
                    ccvsBridge.setQueueID("Queue-" + (i + 1));
                    ccvsBridge.setOverflowID("1747580617834-8d4093c9");
                    ccvsBridge.setMemberCallID("call-" + (j + 1));
                    ccvsBridge.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsBridge.setVcNumber("1068");
                    bridgeEvent.setCcvs(ccvsBridge);
                    callQueueItem.add(bridgeEvent);

                    // Destroy in event
                    CallEvent destroyIn = new CallEvent();
                    destroyIn.setEventName("CHANNEL_DESTROY");
                    destroyIn.setCallID("call-" + (j + 1));
                    destroyIn.setPresenceID("392975086@10.51.9.7");
                    destroyIn.setOtherLegCallID("other-call-" + (j + 1));
                    destroyIn.setOtherLegDirection("outbound");
                    destroyIn.setOtherLegDestinationNumber(agentId);
                    destroyIn.setCallerIDName("0" + randomPhoneNumber);
                    destroyIn.setCallerIDNumber("0" + randomPhoneNumber);
                    destroyIn.setFrom(randomPhoneNumber + "@" + "392975086@10.51.9.7");
                    destroyIn.setFromUri(randomPhoneNumber + "@" + "392975086@10.51.9.7");
                    destroyIn.setTo("1068@10.52.125.35");
                    destroyIn.setToUri("1068@10.52.125.35");
                    destroyIn.setRequest("1068@10.52.125.35");
                    destroyIn.setCalleeIDNumber("0" + randomPhoneNumber);
                    destroyIn.setCallDirection("inbound");
                    destroyIn.setChannelCreatedTimeMs(unixTimeMs);
                    destroyIn.setCavs(JsonParser.parseString("{\"IPCCBLACKLIST_1068\":\"0\",\"cf_route_id\":\"1747580617706-d6096a3f\",\"cf_route_request\":\"1068@10.52.125.35\",\"channel\":\"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\"distribute\":\"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\"member_customer_level\":\"0\",\"originalVoiceChannelNumber\":\"1068\",\"voiceChannelNumber\":\"1068\"}").getAsJsonObject());
                    destroyIn.setCshs(JsonParser.parseString("{\"P-Early-Media\":\"supported\",\"P-Charging-Vector\":\"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"}").getAsJsonObject());

                    destroyIn.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    destroyIn.setSwitchNodename("fs8621@ipcc-02.local");
                    destroyIn.setSmartRouting(false);
                    destroyIn.setSmartRoutingExit(false);
                    CustomChannelVars ccvsDestroyIn = new CustomChannelVars();
                    ccvsDestroyIn.setAccountID(accountId);
                    ccvsDestroyIn.setAccountName("cc");
                    ccvsDestroyIn.setCallInteractionID("63914799817-4c9864f4");
                    ccvsDestroyIn.setBridgeID("call-" + (j + 1));
                    ccvsDestroyIn.setResourceType("offnet-origination");
                    ccvsDestroyIn.setQueueID("Queue-" + (i + 1));
                    ccvsDestroyIn.setOverflowID("1747580617834-8d4093c9");
                    ccvsDestroyIn.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsDestroyIn.setVcNumber("1068");
                    ccvsDestroyIn.setApplicationZone("hni6");
                    ccvsDestroyIn.setZoneWithAcdc(true);
                    ccvsDestroyIn.setCustomerLevel("0");
                    destroyIn.setCcvs(ccvsDestroyIn);
                    callQueueItem.add(destroyIn);

                    // Unbridge event
                    CallEvent unbridgeEvent = new CallEvent();
                    unbridgeEvent.setEventName("CHANNEL_UNBRIDGE");
                    unbridgeEvent.setCallID("other-call-" + (j + 1));
                    unbridgeEvent.setPresenceID(agentId + "@cc.ipcc.vn");
                    unbridgeEvent.setOtherLegCallID("call-" + (j + 1));
                    unbridgeEvent.setOtherLegDirection("inbound");
                    unbridgeEvent.setOtherLegDestinationNumber("1068");
                    unbridgeEvent.setCallerIDName("0" + randomPhoneNumber);
                    unbridgeEvent.setCallerIDNumber("0" + randomPhoneNumber);
                    unbridgeEvent.setCalleeIDNumber("+841068");
                    unbridgeEvent.setCallDirection("outbound");
                    unbridgeEvent.setChannelCreatedTimeMs(unixTimeMs);
                    unbridgeEvent.setCavs(new JsonObject());
                    
                    unbridgeEvent.setCshs(JsonParser.parseString("{\"X-KAZOO-INVITE-FORMAT\":\"contact\",\"X-KAZOO-AOR\":\"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\"MYCC-VIDEO\":\"false\",\"MYCC-QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\",\"MYCC-MEMBER-CALL-ID\":\"BACAA2C7283C4151C4F2B897@3470ffffffff\",\"MYCC-HIDE-CALLER-ID\":\"false\"}").getAsJsonObject());
                    unbridgeEvent.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    unbridgeEvent.setSwitchNodename("fs8621@ipcc-02.local");
                    unbridgeEvent.setSmartRouting(false);
                    unbridgeEvent.setSmartRoutingExit(false);
                    unbridgeEvent.setHangupCause("NORMAL_CLEARING");
                    unbridgeEvent.setHangupCode("sip:200");

                    CustomChannelVars ccvsUnbridge = new CustomChannelVars();
                    ccvsUnbridge.setUsername(agentId);
                    ccvsUnbridge.setAccountID(accountId);
                    ccvsUnbridge.setAccountName("cc");
                    ccvsUnbridge.setCallInteractionID("63914799818-7dc3edc1");
                    ccvsUnbridge.setOwnerID("52412226da14f0de88bba67077a69bc6");
                    ccvsUnbridge.setQueueID("Queue-" + (i + 1));
                    ccvsUnbridge.setOverflowID("1747580617834-8d4093c9");
                    ccvsUnbridge.setMemberCallID("call-" + (j + 1));
                    ccvsUnbridge.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsUnbridge.setVcNumber("1068");
                    unbridgeEvent.setCcvs(ccvsUnbridge);
                    callQueueItem.add(unbridgeEvent);

                    // Destroy Out event
                    CallEvent destroyOut = new CallEvent();
                    destroyOut.setEventName("CHANNEL_DESTROY");
                    destroyOut.setCallID("other-call-" + (j + 1));
                    destroyOut.setPresenceID(agentId + "@cc.ipcc.vn");
                    destroyOut.setOtherLegCallID("call-" + (j + 1));
                    destroyOut.setOtherLegDirection("inbound");
                    destroyOut.setOtherLegDestinationNumber("1068");
                    destroyOut.setCallerIDName("0" + randomPhoneNumber);
                    destroyOut.setCallerIDNumber("0" + randomPhoneNumber);
                    destroyOut.setFrom("Unknown@cc.ipcc.vn");
                    destroyOut.setFromUri("392975086@cc.ipcc.vn");
                    destroyOut.setTo(agentId + "@cc.ipcc.vn");
                    destroyOut.setToUri(agentId + "@cc.ipcc.vn");
                    destroyOut.setRequest(agentId + "@cc.ipcc.vn");
                    destroyOut.setCalleeIDNumber("+841068");
                    destroyOut.setCallDirection("outbound");
                    destroyOut.setChannelCreatedTimeMs(unixTimeMs);
                    destroyOut.setCavs(new JsonObject());
                    destroyOut.setCshs(JsonParser.parseString("{\"X-KAZOO-INVITE-FORMAT\":\"contact\",\"X-KAZOO-AOR\":\"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\"MYCC-VIDEO\":\"false\",\"MYCC-QUEUE\":\"da92390c8c96b7cdebc9f5a6d8963710\",\"MYCC-MEMBER-CALL-ID\":\"BACAA2C7283C4151C4F2B897@3470ffffffff\",\"MYCC-HIDE-CALLER-ID\":\"false\"}").getAsJsonObject());
                    destroyOut.setNode("kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local");
                    destroyOut.setSwitchNodename("fs8621@ipcc-02.local");
                    destroyOut.setSmartRouting(false);
                    destroyOut.setSmartRoutingExit(false);
                    destroyOut.setSipHangupDisposition("send_bye");
                    destroyOut.setHangupCause("NORMAL_CLEARING");
                    destroyOut.setHangupCode("sip:200");

                    CustomChannelVars ccvsDestroyOut = new CustomChannelVars();
                    ccvsDestroyOut.setUsername(agentId);
                    ccvsDestroyOut.setAccountID(accountId);
                    ccvsDestroyOut.setAccountName("cc");
                    ccvsDestroyOut.setCallInteractionID("63914799818-7dc3edc1");
                    ccvsDestroyOut.setOwnerID("52412226da14f0de88bba67077a69bc6");
                    ccvsDestroyOut.setQueueID("Queue-" + (i + 1));
                    ccvsDestroyOut.setOverflowID("1747580617834-8d4093c9");
                    ccvsDestroyOut.setMemberCallID("call-" + (j + 1));
                    ccvsDestroyOut.setVcGroup("52913b5b-2ca1-4430-8011-9b57da21618d");
                    ccvsDestroyOut.setVcNumber("1068");
                    destroyOut.setCcvs(ccvsDestroyOut);
                    callQueueItem.add(destroyOut);

                    // Add the callQueueItem to the callQueue
                    callQueueList.add(callQueueItem);
                }

                // Handle logic for simulating call events in 1 queue

                // Ensure all the calls event in the queue are initialized at the same time
                for (Queue<CallEvent> callQueueItem : callQueueList) {
                    // Send each call event in the queue to Kafka
                    callQueue.add(callQueueItem.poll());
                }

                for (Queue<CallEvent> callQueueItem : callQueueList) {
                    while(callQueueItem.size() > 0) {
                        CallEvent callEvent = callQueueItem.poll();
                        if (callEvent != null) {
                            callQueue.add(callEvent);
                        }
                    }
                }
                // Add the callQueue to the list of callQueues
                callQueues.add(callQueue);
            }
            // try(java.io.FileWriter writer = new java.io.FileWriter("call_event_"+".json", true)) {
            try{
                for (int j = 0; j < (9 * (callNumbers / queueNumbers)); j++){
                
                    for(int i = 0; i < callQueues.size(); i++){
                        int index = i;
                        // CallEvent event = callQueues.get(index).peek();
                        // if (event != null) {
                        //     String prettyJson = new Gson().newBuilder().setPrettyPrinting().create().toJson(event);
                        //     Thread.sleep(600);
                        //     writer.write(prettyJson + System.lineSeparator());
                            
                        // }
                        Thread.sleep(300);
                        System.out.println("Call event in queue " + (index + 1) + ": " + '\n' + callQueues.get(index).peek().getEventName());
                        // callQueues.get(index).poll();
                        kafkaTemplate.send("input-call-topic", callQueues.get(index).peek().getCallerIDName(), callQueues.get(index).poll());
                    }
                    
                }
                return ResponseEntity.ok("Call sequence 1st phase sent to Kafka hehe");
            } catch (Exception e) {
                e.printStackTrace();
            }
            

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return ResponseEntity.ok("Call sequence 1st phase sent to Kafka hehe");
    }

    public static void main(String[] args) {}
    
    
}
