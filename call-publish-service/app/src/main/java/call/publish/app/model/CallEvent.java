package call.publish.app.model;



import com.google.gson.JsonObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CallEvent {
    @SerializedName("Event-Name")
    private String eventName;

    @SerializedName("Call-ID")
    private String callID;

    @SerializedName("Account-ID")
    private String accountId;

    @SerializedName("Account-Name")
    private String accountName;

    @SerializedName("Call-Interaction-ID")
    private String interactionId;

    @SerializedName("Original-Caller-ID-Number")
    private String originationCallID;

    @SerializedName("Presence-ID")
    private String presenceID;

    @SerializedName("Bridge-ID")
    private String bridgeId;

    @SerializedName("Other-Leg-Call-ID")
    private String otherLegCallID;

    @SerializedName("Other-Leg-Direction")
    private String otherLegDirection;

    @SerializedName("Other-Leg-Destination-Number")
    private String otherLegDestinationNumber;

    @SerializedName("Caller-ID-Name")
    private String callerIDName;

    @SerializedName("Caller-ID-Number")
    private String callerIDNumber;

    @SerializedName("From")
    private String from;

    @SerializedName("From-Uri")
    private String fromUri;

    @SerializedName("To")
    private String to;

    @SerializedName("To-Uri")
    private String toUri;

    @SerializedName("Request")
    private String request;

    @SerializedName("Callee-ID-Number")
    private String calleeIDNumber;

    @SerializedName("Call-Direction")
    private String callDirection;

    @SerializedName("Channel-Created-Time")
    private Long channelCreatedTimeMs;

    @SerializedName("1747580621772")
    private Long unixTimeMs;

    @SerializedName("Owner-ID")
    private String ownerId;

    @SerializedName("Channel-Loopback-Leg")
    private String channelLoopbackLeg;

    @SerializedName("Channel-Loopback-Other-Leg-ID")
    private String channelLoopbackOtherLegID;

    @SerializedName("Custom-Application-Vars")
    private JsonObject cavs; 

    @SerializedName("Custom-SIP-Headers")
    private JsonObject cshs;

    @SerializedName("Node")
    private String node;

    @SerializedName("Sip-Hangup-Disposition")
    private String sipHangupDisposition;

    @SerializedName("Hangup-Code")
    private String hangupCode;

    @SerializedName("Hangup-Cause")
    private String hangupCause;

    @SerializedName("Switch-Nodename")
    private String switchNodename;


    private boolean smartRouting = false;
    private boolean smartRoutingExit = false;

    @SerializedName("P-IVR-Call-ID")
    private String IVRCallId;

    @SerializedName("P-IVR-Call-Request")
    private String IVRCallRequestNumber;

    @SerializedName("IPCC-Custom-Vars")
    private JsonObject icvs;

    @SerializedName("Custom-Channel-Vars")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CustomChannelVars ccvs; // Assuming this is a class that holds custom channel variables
    public boolean isSmartRouting() {
        return this.smartRouting;
    }
    public boolean isSmartRoutingExit() {
        return this.smartRoutingExit;
    }
    public boolean isCreateEvent() {
        
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_CREATE");
        
    }
    public boolean isAnswerEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_ANSWER");
    }
    public boolean isBridgeEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_BRIDGE");
    }
    public boolean isUnbridgeEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_UNBRIDGE");
    }
    public boolean isChannelQueueEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_QUEUE");
    }
    public boolean isDestroyEvent() {
        if (this.eventName == null) return false;
        return this.eventName.equals("CHANNEL_DESTROY");
    }
    public boolean isHoldEvent() {
        return false;
    }
    public boolean isUnholdEvent() {
        return false;
    }
    public boolean isTransferorEvent() {
        return false;
    }
    public boolean isTransfereeEvent() {
        return false;
    }

    
}
