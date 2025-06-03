package call.publish.app.model;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomChannelVars {

    @SerializedName("Username")
    private String username;

    @SerializedName("Account-ID")
    private String accountID;

    @SerializedName("Account-Name")
    private String accountName;

    @SerializedName("Call-Interaction-ID")
    private String callInteractionID;

    @SerializedName("Presence-ID")
    private String presenceID;

    @SerializedName("Bridge-ID")
    private String bridgeID;

    @SerializedName("Owner-ID")
    private String ownerID;

    @SerializedName("Resource-Type")
    private String resourceType;

    @SerializedName("Queue-ID")
    private String queueID;

    @SerializedName("Overflow-ID")
    private String overflowID;

    @SerializedName("Member-Call-ID")
    private String memberCallID;

    @SerializedName("Voice-Channel-Group")
    private String vcGroup;

    @SerializedName("Voice-Channel-Number")
    private String vcNumber;

    @SerializedName("Application-Zone")
    private String applicationZone;

    @SerializedName("Zone-With-Acdc")
    private Boolean zoneWithAcdc;

    @SerializedName("member_customer_level")
    private String CustomerLevel;

    private String serviceVipCode;


    private Boolean expertFlag;
    private String expertGroup;
    private Boolean outboundFlags;
    private String referredBy;
    private String referredTo;
    private String mediaNames;
    private String mediaRecordings;

    public CustomChannelVars(String accountId){
        this.accountID = accountId;
    }




}
