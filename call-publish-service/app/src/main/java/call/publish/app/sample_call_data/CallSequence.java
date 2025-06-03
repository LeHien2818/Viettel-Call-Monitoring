package call.publish.app.sample_call_data;

public class CallSequence {
    public StringBuilder channelCreateIn = new StringBuilder();
    public StringBuilder channelQueue = new StringBuilder();
    public StringBuilder channelCreateOut = new StringBuilder();
    public StringBuilder channelCreateAnswerIn = new StringBuilder();
    public StringBuilder channelCreateAnswerOut = new StringBuilder();
    public StringBuilder channelBridge = new StringBuilder();
    public StringBuilder channelDestroyIn = new StringBuilder();
    public StringBuilder channelUnbridge = new StringBuilder();
    public StringBuilder channelDestroyOut = new StringBuilder();

    public CallSequence() {
        // Initialize the StringBuilder objects with empty strings
        channelCreateIn.append("{\n" + //
                        "  \"To-Uri\": \"1068@10.52.125.35\",\n" + //
                        "  \"To\": \"1068@10.52.125.35\",\n" + //
                        "  \"Unix-Time-Us\": 1747580617653455,\n" + //
                        "  \"Unix-Time-Ms\": 1747580617653,\n" + //
                        "  \"Timestamp\": 63914799817,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Request\": \"1068@10.52.125.35\",\n" + //
                        "  \"Presence-ID\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"From-Uri\": \"392975086@10.51.9.7\",\n" + //
                        "  \"From-Tag\": \"6.U4.Y7AeB2i1U_5\",\n" + //
                        "  \"From\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Disposition\": \"DELAYED NEGOTIATION\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-AUTH-PORT\": \"5060\",\n" + //
                        "    \"X-AUTH-IP\": \"10.51.9.7\",\n" + //
                        "    \"P-Early-Media\": \"supported\",\n" + //
                        "    \"P-Charging-Vector\": \"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"INIT\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_mpbn/392975086@10.51.9.7\",\n" + //
                        "  \"Channel-Created-Time\": 1747580617653455,\n" + //
                        "  \"Channel-Call-State\": \"DOWN\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Call-Direction\": \"inbound\",\n" + //
                        "  \"Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580617653455\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_CREATE\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelQueue.append("{\n" + //
                        "  \"Key-Value-Store\": {\n" + //
                        "    \"caller_disable_lcar_key\": \"0\",\n" + //
                        "    \"caller_exit_key\": \"#\",\n" + //
                        "    \"cf_answer_call\": false,\n" + //
                        "    \"cf_capture_groups\": {},\n" + //
                        "    \"cf_critical_call\": true,\n" + //
                        "    \"cf_flow\": {\n" + //
                        "      \"module\": \"branch_variable\",\n" + //
                        "      \"data\": {\n" + //
                        "        \"variable\": \"zone_with_acdc\",\n" + //
                        "        \"scope\": \"custom_channel_vars\"\n" + //
                        "      },\n" + //
                        "      \"children\": {\n" + //
                        "        \"true\": {\n" + //
                        "          \"module\": \"branch_variable\",\n" + //
                        "          \"data\": {\n" + //
                        "            \"variable\": \"application_zone\",\n" + //
                        "            \"scope\": \"custom_channel_vars\"\n" + //
                        "          },\n" + //
                        "          \"children\": {\n" + //
                        "            \"hni6\": {\n" + //
                        "              \"module\": \"temporal_route\",\n" + //
                        "              \"data\": {\n" + //
                        "                \"rules\": []\n" + //
                        "              },\n" + //
                        "              \"children\": {\n" + //
                        "                \"_\": {\n" + //
                        "                  \"module\": \"pivot\",\n" + //
                        "                  \"data\": {\n" + //
                        "                    \"voice_url\": \"http://pivot-service:9999/api/v1/pivot/voice_channel/1068/group/52913b5b-2ca1-4430-8011-9b57da21618d/distribute/9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "                    \"req_format\": \"kazoo\",\n" + //
                        "                    \"req_body_format\": \"json\",\n" + //
                        "                    \"method\": \"post\",\n" + //
                        "                    \"debug\": false\n" + //
                        "                  },\n" + //
                        "                  \"children\": {\n" + //
                        "                    \"_\": {\n" + //
                        "                      \"module\": \"set_variables\",\n" + //
                        "                      \"data\": {\n" + //
                        "                        \"custom_application_vars\": {\n" + //
                        "                          \"auto_transfer_from\": \"1068\"\n" + //
                        "                        }\n" + //
                        "                      },\n" + //
                        "                      \"children\": {\n" + //
                        "                        \"_\": {\n" + //
                        "                          \"module\": \"transfer\",\n" + //
                        "                          \"data\": {\n" + //
                        "                            \"transfer_type\": \"blind\",\n" + //
                        "                            \"target\": \"106x_default_routing\",\n" + //
                        "                            \"captures\": [\n" + //
                        "                              \"no_match\"\n" + //
                        "                            ]\n" + //
                        "                          },\n" + //
                        "                          \"children\": {}\n" + //
                        "                        }\n" + //
                        "                      }\n" + //
                        "                    }\n" + //
                        "                  }\n" + //
                        "                }\n" + //
                        "              }\n" + //
                        "            }\n" + //
                        "          }\n" + //
                        "        },\n" + //
                        "        \"_\": {\n" + //
                        "          \"module\": \"resources\",\n" + //
                        "          \"data\": {\n" + //
                        "            \"use_local_resources\": true,\n" + //
                        "            \"to_did\": \"1068\",\n" + //
                        "            \"outbound_flags\": [],\n" + //
                        "            \"ignore_early_media\": false,\n" + //
                        "            \"dynamic_flags\": [\n" + //
                        "              \"zone\"\n" + //
                        "            ],\n" + //
                        "            \"custom_sip_headers\": {\n" + //
                        "              \"P-IVR-Call-Request\": \"{sip_req_user}\",\n" + //
                        "              \"P-IVR-Call-ID\": \"{sip_call_id}\"\n" + //
                        "            },\n" + //
                        "            \"caller_id_type\": \"external\"\n" + //
                        "          },\n" + //
                        "          \"children\": {}\n" + //
                        "        }\n" + //
                        "      }\n" + //
                        "    },\n" + //
                        "    \"cf_flow_id\": \"6d26421b5e762b8e052b764ed9dfb5d8\",\n" + //
                        "    \"cf_flow_name\": \"Kênh 1068\",\n" + //
                        "    \"cf_last_action\": \"cf_set_variables\",\n" + //
                        "    \"cf_metaflow\": false,\n" + //
                        "    \"cf_no_match\": false,\n" + //
                        "    \"cf_old_action\": \"cf_pivot\",\n" + //
                        "    \"overflow\": {\n" + //
                        "      \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "      \"Overflowing\": false,\n" + //
                        "      \"First-Time-Acd\": true,\n" + //
                        "      \"Queue-Unix-Time-Ms\": 1747580617834\n" + //
                        "    }\n" + //
                        "  },\n" + //
                        "  \"Account-DB\": \"account%2F2b%2Fab%2F475dd0ee591598ef370f113e7075\",\n" + //
                        "  \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "  \"Call-Bridged\": false,\n" + //
                        "  \"Call-Direction\": \"inbound\",\n" + //
                        "  \"Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Callee-ID-Number\": \"1068\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Control-Queue\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local-ecallmgr_call_control-<0.1030.861>-ef05bf49\",\n" + //
                        "  \"Controller-Queue\": \"kazoo_apps@hni6-kapps-0.hni6-nodes.ipcc.svc.cluster.local-cf_exe-<0.4437.2781>-a346c324\",\n" + //
                        "  \"Custom-Application-Vars\": {\n" + //
                        "    \"voiceChannelNumber\": \"1068\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Zone-With-Acdc\": \"true\",\n" + //
                        "    \"Resource-Type\": \"offnet-origination\",\n" + //
                        "    \"Privacy-Hide-Number\": false,\n" + //
                        "    \"Privacy-Hide-Name\": false,\n" + //
                        "    \"Inception\": \"1068@10.52.125.35\",\n" + //
                        "    \"Ignore-Display-Updates\": \"true\",\n" + //
                        "    \"Fetch-ID\": \"9779e801-d8a7-48a5-bc6a-465147d69ee6\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"CallFlow-ID\": \"6d26421b5e762b8e052b764ed9dfb5d8\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799817-4c9864f4\",\n" + //
                        "    \"Application-Zone\": \"hni6\",\n" + //
                        "    \"Application-Node\": \"kazoo_apps@hni6-kapps-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Application-Name\": \"callflow\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\",\n" + //
                        "    \"voiceChannelNumber\": \"1068\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"Overflowing\": false,\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-AUTH-PORT\": \"5060\",\n" + //
                        "    \"X-AUTH-IP\": \"10.51.9.7\",\n" + //
                        "    \"P-Early-Media\": \"supported\",\n" + //
                        "    \"P-Charging-Vector\": \"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"\n" + //
                        "  },\n" + //
                        "  \"Fetch-ID\": \"9779e801-d8a7-48a5-bc6a-465147d69ee6\",\n" + //
                        "  \"From\": \"392975086@10.51.9.7\",\n" + //
                        "  \"From-Realm\": \"10.51.9.7\",\n" + //
                        "  \"From-Tag\": \"6.U4.Y7AeB2i1U_5\",\n" + //
                        "  \"From-User\": \"392975086\",\n" + //
                        "  \"Inception\": \"1068@10.52.125.35\",\n" + //
                        "  \"Is-Recording\": false,\n" + //
                        "  \"Is-Call-Forward\": false,\n" + //
                        "  \"Language\": \"en-us\",\n" + //
                        "  \"Message-Left\": false,\n" + //
                        "  \"Request\": \"1068@10.52.125.35\",\n" + //
                        "  \"Request-Realm\": \"10.52.125.35\",\n" + //
                        "  \"Request-User\": \"+841068\",\n" + //
                        "  \"Resource-Type\": \"audio\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"To\": \"1068@10.52.125.35\",\n" + //
                        "  \"To-Realm\": \"10.52.125.35\",\n" + //
                        "  \"To-User\": \"1068\",\n" + //
                        "  \"Channel-Created-Time\": 1747580617653455,\n" + //
                        "  \"Event-Name\": \"CHANNEL_QUEUE\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"Unix-Time-Ms\": 1747580617834,\n" + //
                        "  \"IPCC-Custom-Vars\": {\n" + //
                        "    \"CHANNEL_QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\"\n" + //
                        "  }\n" + //
                        "}");

        channelCreateOut.append("{\n" + //
                        "  \"To\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Unix-Time-Us\": 1747580618052829,\n" + //
                        "  \"Unix-Time-Ms\": 1747580618052,\n" + //
                        "  \"Timestamp\": 63914799818,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Request\": \"vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Presence-ID\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"From\": \"nouser@cc.ipcc.vn\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-KAZOO-INVITE-FORMAT\": \"contact\",\n" + //
                        "    \"X-KAZOO-AOR\": \"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "    \"MYCC-VIDEO\": \"false\",\n" + //
                        "    \"MYCC-QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"MYCC-MEMBER-CALL-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"MYCC-HIDE-CALLER-ID\": \"false\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Agent-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Authorizing-ID\": \"d8de23a162ec82a6a6faf92413617f0a\",\n" + //
                        "    \"Authorizing-Type\": \"device\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799818-7dc3edc1\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Fetch-ID\": \"69b528360a21dccf0388e9aac3896d6e\",\n" + //
                        "    \"Member-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Original-Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"Original-Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Owner-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Realm\": \"cc.ipcc.vn\",\n" + //
                        "    \"Request-ID\": \"c3becf7e3309\",\n" + //
                        "    \"Retain-CID\": \"true\",\n" + //
                        "    \"Username\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"INIT\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_dcn/vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Channel-Created-Time\": 1747580618032847,\n" + //
                        "  \"Channel-Call-State\": \"DOWN\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"+841068\",\n" + //
                        "  \"Callee-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Call-Direction\": \"outbound\",\n" + //
                        "  \"Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580618052829\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_CREATE\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelCreateAnswerIn.append("{\n" + //
                        "  \"To-Uri\": \"1068@10.52.125.35\",\n" + //
                        "  \"To\": \"1068@10.52.125.35\",\n" + //
                        "  \"Unix-Time-Us\": 1747580621772773,\n" + //
                        "  \"Unix-Time-Ms\": 1747580621772,\n" + //
                        "  \"Timestamp\": 63914799821,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Request\": \"1068@10.52.125.35\",\n" + //
                        "  \"Presence-ID\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"From-Uri\": \"392975086@10.51.9.7\",\n" + //
                        "  \"From-Tag\": \"6.U4.Y7AeB2i1U_5\",\n" + //
                        "  \"From\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Disposition\": \"EARLY MEDIA\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"P-Early-Media\": \"supported\",\n" + //
                        "    \"P-Charging-Vector\": \"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Application-Name\": \"callflow\",\n" + //
                        "    \"Application-Node\": \"kazoo_apps@hni6-kapps-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Application-Zone\": \"hni6\",\n" + //
                        "    \"Bridge-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799817-4c9864f4\",\n" + //
                        "    \"CallFlow-ID\": \"6d26421b5e762b8e052b764ed9dfb5d8\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Ecallmgr-Zone\": \"hni6\",\n" + //
                        "    \"Fetch-ID\": \"9779e801-d8a7-48a5-bc6a-465147d69ee6\",\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"Inception\": \"1068@10.52.125.35\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Overflowing\": \"false\",\n" + //
                        "    \"Privacy-Hide-Name\": \"false\",\n" + //
                        "    \"Privacy-Hide-Number\": \"false\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Resource-Type\": \"offnet-origination\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\",\n" + //
                        "    \"Zone-With-Acdc\": \"true\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\",\n" + //
                        "    \"voiceChannelNumber\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\",\n" + //
                        "    \"voiceChannelNumber\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Channel-State\": \"EXECUTE\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_mpbn/392975086@10.51.9.7\",\n" + //
                        "  \"Channel-Created-Time\": 1747580617653455,\n" + //
                        "  \"Channel-Call-State\": \"EARLY\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Call-Direction\": \"inbound\",\n" + //
                        "  \"Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580621772773\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_ANSWER\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelCreateAnswerOut.append("{\n" + //
                        "  \"To-Uri\": \"vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"To-Tag\": \"ik038rf00r\",\n" + //
                        "  \"To\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Unix-Time-Us\": 1747580621772773,\n" + //
                        "  \"Unix-Time-Ms\": 1747580621772,\n" + //
                        "  \"Timestamp\": 63914799821,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Request\": \"vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Presence-ID\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"From-Uri\": \"392975086@cc.ipcc.vn\",\n" + //
                        "  \"From-Tag\": \"tQH74F6H03B3c\",\n" + //
                        "  \"From\": \"392975086@cc.ipcc.vn\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-KAZOO-INVITE-FORMAT\": \"contact\",\n" + //
                        "    \"X-KAZOO-AOR\": \"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "    \"MYCC-VIDEO\": \"false\",\n" + //
                        "    \"MYCC-QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"MYCC-MEMBER-CALL-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"MYCC-HIDE-CALLER-ID\": \"false\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Agent-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Authorizing-ID\": \"d8de23a162ec82a6a6faf92413617f0a\",\n" + //
                        "    \"Authorizing-Type\": \"device\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799818-7dc3edc1\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Fetch-ID\": \"69b528360a21dccf0388e9aac3896d6e\",\n" + //
                        "    \"Global-Resource\": \"false\",\n" + //
                        "    \"Member-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Original-Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"Original-Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Owner-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Realm\": \"cc.ipcc.vn\",\n" + //
                        "    \"Request-ID\": \"c3becf7e3309\",\n" + //
                        "    \"Retain-CID\": \"true\",\n" + //
                        "    \"Username\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"CONSUME_MEDIA\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_dcn/vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Channel-Created-Time\": 1747580618032847,\n" + //
                        "  \"Channel-Call-State\": \"RINGING\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"+841068\",\n" + //
                        "  \"Callee-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Call-Direction\": \"outbound\",\n" + //
                        "  \"Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580621772773\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_ANSWER\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelBridge.append("{\n" + //
                        "  \"Transfer-History\": {\n" + //
                        "    \"1747580621\": {\n" + //
                        "      \"Call-ID\": \"4461ba89-749f-43ac-9632-f9b08a179e13\",\n" + //
                        "      \"Type\": \"bridge\",\n" + //
                        "      \"Other-Leg\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\"\n" + //
                        "    }\n" + //
                        "  },\n" + //
                        "  \"To-Tag\": \"ik038rf00r\",\n" + //
                        "  \"Unix-Time-Us\": 1747580621832775,\n" + //
                        "  \"Unix-Time-Ms\": 1747580621832,\n" + //
                        "  \"Timestamp\": 63914799821,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Presence-ID\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Other-Leg-Direction\": \"inbound\",\n" + //
                        "  \"Other-Leg-Destination-Number\": \"1068\",\n" + //
                        "  \"Other-Leg-Caller-ID-Number\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Caller-ID-Name\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"From-Tag\": \"tQH74F6H03B3c\",\n" + //
                        "  \"Disposition\": \"ANSWER\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-KAZOO-INVITE-FORMAT\": \"contact\",\n" + //
                        "    \"X-KAZOO-AOR\": \"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "    \"MYCC-VIDEO\": \"false\",\n" + //
                        "    \"MYCC-QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"MYCC-MEMBER-CALL-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"MYCC-HIDE-CALLER-ID\": \"false\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Agent-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Authorizing-ID\": \"d8de23a162ec82a6a6faf92413617f0a\",\n" + //
                        "    \"Authorizing-Type\": \"device\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799818-7dc3edc1\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Fetch-ID\": \"69b528360a21dccf0388e9aac3896d6e\",\n" + //
                        "    \"Global-Resource\": \"false\",\n" + //
                        "    \"Member-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Original-Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"Original-Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Owner-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Realm\": \"cc.ipcc.vn\",\n" + //
                        "    \"Request-ID\": \"c3becf7e3309\",\n" + //
                        "    \"Retain-CID\": \"true\",\n" + //
                        "    \"Username\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"SOFT_EXECUTE\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_dcn/vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Channel-Created-Time\": 1747580618032847,\n" + //
                        "  \"Channel-Call-State\": \"ACTIVE\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"+841068\",\n" + //
                        "  \"Callee-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Call-Direction\": \"outbound\",\n" + //
                        "  \"Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580621832775\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_BRIDGE\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelDestroyIn.append("{\n" + //
                        "  \"Sip-Hangup-Disposition\": \"recv_bye\",\n" + //
                        "  \"Transfer-History\": {\n" + //
                        "    \"1747580621\": {\n" + //
                        "      \"Call-ID\": \"88de1fe4-35a2-4dbe-a9dc-e7688854d164\",\n" + //
                        "      \"Type\": \"bridge\",\n" + //
                        "      \"Other-Leg\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\"\n" + //
                        "    }\n" + //
                        "  },\n" + //
                        "  \"To-Uri\": \"1068@10.52.125.35\",\n" + //
                        "  \"To-Tag\": \"3mp036248B6SF\",\n" + //
                        "  \"To\": \"1068@10.52.125.35\",\n" + //
                        "  \"Unix-Time-Us\": 1747580668072757,\n" + //
                        "  \"Unix-Time-Ms\": 1747580668072,\n" + //
                        "  \"Timestamp\": 63914799868,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Ringing-Seconds\": 4,\n" + //
                        "  \"Request\": \"1068@10.52.125.35\",\n" + //
                        "  \"Remote-SDP\": \"v=0\\r\\n" + //
                        "o=- 0 0 IN IP4 10.51.9.76\\r\\n" + //
                        "s=-\\r\\n" + //
                        "c=IN IP4 10.51.9.76\\r\\n" + //
                        "t=0 0\\r\\n" + //
                        "m=audio 23608 RTP/AVP 8 18\\r\\n" + //
                        "b=AS:80\\r\\n" + //
                        "a=rtpmap:8 PCMA/8000\\r\\n" + //
                        "a=rtpmap:18 G729/8000\\r\\n" + //
                        "a=fmtp:18 annexb=no\\r\\n" + //
                        "a=ptime:20\\r\\n" + //
                        "a=maxptime:30\\r\\n" + //
                        "\",\n" + //
                        "  \"Presence-ID\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Other-Leg-Direction\": \"outbound\",\n" + //
                        "  \"Other-Leg-Destination-Number\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "  \"Other-Leg-Caller-ID-Number\": \"+841068\",\n" + //
                        "  \"Other-Leg-Caller-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"Local-SDP\": \"v=0\\r\\n" + //
                        "o=FreeSWITCH 1747539763 1747539765 IN IP4 10.52.125.39\\r\\n" + //
                        "s=FreeSWITCH\\r\\n" + //
                        "c=IN IP4 10.52.125.39\\r\\n" + //
                        "t=0 0\\r\\n" + //
                        "m=audio 40854 RTP/AVP 8\\r\\n" + //
                        "a=rtpmap:8 PCMA/8000\\r\\n" + //
                        "a=ptime:20\\r\\n" + //
                        "a=sendrecv\\r\\n" + //
                        "\",\n" + //
                        "  \"Hangup-Code\": \"sip:200\",\n" + //
                        "  \"Hangup-Cause\": \"NORMAL_CLEARING\",\n" + //
                        "  \"From-Uri\": \"392975086@10.51.9.7\",\n" + //
                        "  \"From-Tag\": \"6.U4.Y7AeB2i1U_5\",\n" + //
                        "  \"From\": \"392975086@10.51.9.7\",\n" + //
                        "  \"Duration-Seconds\": 51,\n" + //
                        "  \"Disposition\": \"ANSWER\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"P-Early-Media\": \"supported\",\n" + //
                        "    \"P-Charging-Vector\": \"icid-value=SIkgAAW7crCyPcE0cMwFTwA-;icid-generated-at=10.51.9.7;orig-ioi=10.51.9.7\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Application-Name\": \"callflow\",\n" + //
                        "    \"Application-Node\": \"kazoo_apps@hni6-kapps-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Application-Zone\": \"hni6\",\n" + //
                        "    \"Bridge-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799817-4c9864f4\",\n" + //
                        "    \"CallFlow-ID\": \"6d26421b5e762b8e052b764ed9dfb5d8\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Ecallmgr-Zone\": \"hni6\",\n" + //
                        "    \"Fetch-ID\": \"9779e801-d8a7-48a5-bc6a-465147d69ee6\",\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"Inception\": \"1068@10.52.125.35\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Overflowing\": \"false\",\n" + //
                        "    \"Privacy-Hide-Name\": \"false\",\n" + //
                        "    \"Privacy-Hide-Number\": \"false\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Resource-Type\": \"offnet-origination\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\",\n" + //
                        "    \"Zone-With-Acdc\": \"true\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\",\n" + //
                        "    \"voiceChannelNumber\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {\n" + //
                        "    \"IPCCBLACKLIST_1068\": \"0\",\n" + //
                        "    \"cf_route_id\": \"1747580617706-d6096a3f\",\n" + //
                        "    \"cf_route_request\": \"1068@10.52.125.35\",\n" + //
                        "    \"channel\": \"fbbb2ae8-783e-459e-bdad-4e77b74649fa\",\n" + //
                        "    \"distribute\": \"9e1ee9f1-ad6e-437a-98af-2447d141e110\",\n" + //
                        "    \"member_customer_level\": \"0\",\n" + //
                        "    \"originalVoiceChannelNumber\": \"1068\",\n" + //
                        "    \"voiceChannelNumber\": \"1068\"\n" + //
                        "  },\n" + //
                        "  \"Channel-State\": \"REPORTING\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_mpbn/392975086@10.51.9.7\",\n" + //
                        "  \"Channel-Created-Time\": 1747580617653455,\n" + //
                        "  \"Channel-Call-State\": \"HANGUP\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"392975086\",\n" + //
                        "  \"Callee-ID-Name\": \"392975086\",\n" + //
                        "  \"Call-Direction\": \"inbound\",\n" + //
                        "  \"Billing-Seconds\": 47,\n" + //
                        "  \"Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580668072757\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_DESTROY\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelUnbridge.append("{\n" + //
                        "  \"Transfer-History\": {\n" + //
                        "    \"1747580621\": {\n" + //
                        "      \"Call-ID\": \"4461ba89-749f-43ac-9632-f9b08a179e13\",\n" + //
                        "      \"Type\": \"bridge\",\n" + //
                        "      \"Other-Leg\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\"\n" + //
                        "    }\n" + //
                        "  },\n" + //
                        "  \"To-Tag\": \"ik038rf00r\",\n" + //
                        "  \"Unix-Time-Us\": 1747580668072757,\n" + //
                        "  \"Unix-Time-Ms\": 1747580668072,\n" + //
                        "  \"Timestamp\": 63914799868,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Presence-ID\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Other-Leg-Direction\": \"inbound\",\n" + //
                        "  \"Other-Leg-Destination-Number\": \"1068\",\n" + //
                        "  \"Other-Leg-Caller-ID-Number\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Caller-ID-Name\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"Hangup-Code\": \"sip:200\",\n" + //
                        "  \"Hangup-Cause\": \"NORMAL_CLEARING\",\n" + //
                        "  \"From-Tag\": \"tQH74F6H03B3c\",\n" + //
                        "  \"Disposition\": \"ANSWER\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-KAZOO-INVITE-FORMAT\": \"contact\",\n" + //
                        "    \"X-KAZOO-AOR\": \"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "    \"MYCC-VIDEO\": \"false\",\n" + //
                        "    \"MYCC-QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"MYCC-MEMBER-CALL-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"MYCC-HIDE-CALLER-ID\": \"false\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Agent-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Authorizing-ID\": \"d8de23a162ec82a6a6faf92413617f0a\",\n" + //
                        "    \"Authorizing-Type\": \"device\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799818-7dc3edc1\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Fetch-ID\": \"69b528360a21dccf0388e9aac3896d6e\",\n" + //
                        "    \"Global-Resource\": \"false\",\n" + //
                        "    \"Media-Name\": \"1f8f4cf7e6aa247f088f9b160a6da1e3.mp3\",\n" + //
                        "    \"Media-Recorder\": \"kz_media_recording\",\n" + //
                        "    \"Media-Recording-ID\": \"202505-ef3c279cdfcf1b79ee9c368d637db4c4\",\n" + //
                        "    \"Member-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Original-Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"Original-Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Owner-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Realm\": \"cc.ipcc.vn\",\n" + //
                        "    \"Request-ID\": \"c3becf7e3309\",\n" + //
                        "    \"Retain-CID\": \"true\",\n" + //
                        "    \"Username\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\",\n" + //
                        "    \"Media-Recordings\": [\n" + //
                        "      \"202505-ef3c279cdfcf1b79ee9c368d637db4c4\"\n" + //
                        "    ],\n" + //
                        "    \"Media-Names\": [\n" + //
                        "      \"1f8f4cf7e6aa247f088f9b160a6da1e3.mp3\"\n" + //
                        "    ]\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"SOFT_EXECUTE\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_dcn/vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Channel-Created-Time\": 1747580618032847,\n" + //
                        "  \"Channel-Call-State\": \"ACTIVE\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"+841068\",\n" + //
                        "  \"Callee-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Call-Direction\": \"outbound\",\n" + //
                        "  \"Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580668072757\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_UNBRIDGE\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");

        channelDestroyOut.append("{\n" + //
                        "  \"Sip-Hangup-Disposition\": \"send_bye\",\n" + //
                        "  \"User-Agent\": \"SIP.js/0.11.3\",\n" + //
                        "  \"Transfer-History\": {\n" + //
                        "    \"1747580621\": {\n" + //
                        "      \"Call-ID\": \"4461ba89-749f-43ac-9632-f9b08a179e13\",\n" + //
                        "      \"Type\": \"bridge\",\n" + //
                        "      \"Other-Leg\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\"\n" + //
                        "    }\n" + //
                        "  },\n" + //
                        "  \"To-Uri\": \"vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"To-Tag\": \"ik038rf00r\",\n" + //
                        "  \"To\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Unix-Time-Us\": 1747580668072757,\n" + //
                        "  \"Unix-Time-Ms\": 1747580668072,\n" + //
                        "  \"Timestamp\": 63914799868,\n" + //
                        "  \"Switch-URL\": \"sip:mod_sofia@171.229.16.93:11601\",\n" + //
                        "  \"Switch-URI\": \"sip:171.229.16.93:11601\",\n" + //
                        "  \"Switch-Nodename\": \"fs8621@ipcc-02.local\",\n" + //
                        "  \"Switch-Hostname\": \"ipcc-02.local\",\n" + //
                        "  \"Ringing-Seconds\": 3,\n" + //
                        "  \"Request\": \"vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Remote-SDP\": \"v=0\\r\\n" + //
                        "o=- 3225690639938203252 2 IN IP4 192.168.73.2\\r\\n" + //
                        "s=-\\r\\n" + //
                        "t=0 0\\r\\n" + //
                        "a=msid-semantic: WMS 1ace904c-ba24-409c-9da6-4cc9e03b263e\\r\\n" + //
                        "m=audio 64480 RTP/SAVPF 8 101 13\\r\\n" + //
                        "c=IN IP4 192.168.73.2\\r\\n" + //
                        "a=rtpmap:8 PCMA/8000\\r\\n" + //
                        "a=rtpmap:101 telephone-event/8000\\r\\n" + //
                        "a=rtpmap:13 CN/8000\\r\\n" + //
                        "a=rtcp:9 IN IP4 0.0.0.0\\r\\n" + //
                        "a=candidate:3341591360 1 udp 2122260223 192.168.73.2 64480 typ host generation 0 network-id 1\\r\\n" + //
                        "a=candidate:3118678488 1 tcp 1518280447 192.168.73.2 9 typ host tcptype active generation 0 network-id 1\\r\\n" + //
                        "a=ice-ufrag:jCkm\\r\\n" + //
                        "a=ice-pwd:h8nK5uo4puvUn6TOz+Cvc8EN\\r\\n" + //
                        "a=ice-options:trickle\\r\\n" + //
                        "a=fingerprint:sha-256 C4:7F:94:8F:78:30:15:FF:34:53:3C:1F:AF:7F:DC:43:95:63:65:83:2F:CD:3A:06:A8:20:CC:C0:95:18:7E:DE\\r\\n" + //
                        "a=setup:active\\r\\n" + //
                        "a=mid:0\\r\\n" + //
                        "a=rtcp-mux\\r\\n" + //
                        "a=ssrc:4005800924 cname:kK1m9GvcLXFjU8OH\\r\\n" + //
                        "a=ssrc:4005800924 msid:1ace904c-ba24-409c-9da6-4cc9e03b263e a1960796-3b19-42ad-8cad-7f8b8fc80ae3\\r\\n" + //
                        "a=oldmediaip:127.0.0.1\\r\\n" + //
                        "\",\n" + //
                        "  \"Presence-ID\": \"161704@cc.ipcc.vn\",\n" + //
                        "  \"Other-Leg-Direction\": \"inbound\",\n" + //
                        "  \"Other-Leg-Destination-Number\": \"1068\",\n" + //
                        "  \"Other-Leg-Caller-ID-Number\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Caller-ID-Name\": \"Unknown\",\n" + //
                        "  \"Other-Leg-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "  \"Media-Server\": \"ipcc-02.local\",\n" + //
                        "  \"Local-SDP\": \"v=0\\r\\n" + //
                        "o=FreeSWITCH 1747540024 1747540025 IN IP4 10.207.189.137\\r\\n" + //
                        "s=FreeSWITCH\\r\\n" + //
                        "c=IN IP4 10.207.189.137\\r\\n" + //
                        "t=0 0\\r\\n" + //
                        "a=msid-semantic: WMS YyGgSV8D8dfcsAG3JXiAzFmCWXnm9sRY\\r\\n" + //
                        "m=audio 40594 RTP/SAVPF 8 101 13\\r\\n" + //
                        "a=rtpmap:8 PCMA/8000\\r\\n" + //
                        "a=rtpmap:101 telephone-event/8000\\r\\n" + //
                        "a=fingerprint:sha-256 C2:29:5C:86:91:00:3E:B1:4C:07:9D:83:C0:16:7F:83:1E:DE:8D:8D:D0:80:55:16:BC:10:98:82:D4:19:A2:AD\\r\\n" + //
                        "a=setup:actpass\\r\\n" + //
                        "a=rtcp-mux\\r\\n" + //
                        "a=rtcp:40594 IN IP4 10.207.189.137\\r\\n" + //
                        "a=ssrc:2627052610 cname:Rn5z932778aqyHk7\\r\\n" + //
                        "a=ssrc:2627052610 msid:YyGgSV8D8dfcsAG3JXiAzFmCWXnm9sRY a0\\r\\n" + //
                        "a=ssrc:2627052610 mslabel:YyGgSV8D8dfcsAG3JXiAzFmCWXnm9sRY\\r\\n" + //
                        "a=ssrc:2627052610 label:YyGgSV8D8dfcsAG3JXiAzFmCWXnm9sRYa0\\r\\n" + //
                        "a=ice-ufrag:vsyUXKmKxAWxTDmA\\r\\n" + //
                        "a=ice-pwd:Qh0QbSN8ROpfmzdHRBrFcEfA\\r\\n" + //
                        "a=candidate:7163130341 1 udp 2130706431 10.207.189.137 40594 typ host generation 0\\r\\n" + //
                        "a=candidate:7163130341 2 udp 2130706431 10.207.189.137 40594 typ host generation 0\\r\\n" + //
                        "a=rtpmap:13 CN/8000\\r\\n" + //
                        "a=ptime:20\\r\\n" + //
                        "a=sendrecv\\r\\n" + //
                        "\",\n" + //
                        "  \"Hangup-Code\": \"sip:200\",\n" + //
                        "  \"Hangup-Cause\": \"NORMAL_CLEARING\",\n" + //
                        "  \"From-Uri\": \"392975086@cc.ipcc.vn\",\n" + //
                        "  \"From-Tag\": \"tQH74F6H03B3c\",\n" + //
                        "  \"From\": \"Unknown@cc.ipcc.vn\",\n" + //
                        "  \"Duration-Seconds\": 50,\n" + //
                        "  \"Disposition\": \"ANSWER\",\n" + //
                        "  \"Custom-SIP-Headers\": {\n" + //
                        "    \"X-KAZOO-INVITE-FORMAT\": \"contact\",\n" + //
                        "    \"X-KAZOO-AOR\": \"sip:vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "    \"MYCC-VIDEO\": \"false\",\n" + //
                        "    \"MYCC-QUEUE\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"MYCC-MEMBER-CALL-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"MYCC-HIDE-CALLER-ID\": \"false\"\n" + //
                        "  },\n" + //
                        "  \"Custom-Channel-Vars\": {\n" + //
                        "    \"Account-ID\": \"2bab475dd0ee591598ef370f113e7075\",\n" + //
                        "    \"Account-Name\": \"cc\",\n" + //
                        "    \"Agent-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Authorizing-ID\": \"d8de23a162ec82a6a6faf92413617f0a\",\n" + //
                        "    \"Authorizing-Type\": \"device\",\n" + //
                        "    \"Call-Interaction-ID\": \"63914799818-7dc3edc1\",\n" + //
                        "    \"Channel-Authorized\": \"true\",\n" + //
                        "    \"Ecallmgr-Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "    \"Fetch-ID\": \"69b528360a21dccf0388e9aac3896d6e\",\n" + //
                        "    \"Global-Resource\": \"false\",\n" + //
                        "    \"Media-Name\": \"1f8f4cf7e6aa247f088f9b160a6da1e3.mp3\",\n" + //
                        "    \"Media-Recorder\": \"kz_media_recording\",\n" + //
                        "    \"Media-Recording-ID\": \"202505-ef3c279cdfcf1b79ee9c368d637db4c4\",\n" + //
                        "    \"Member-Call-ID\": \"BACAA2C7283C4151C4F2B897@3470ffffffff\",\n" + //
                        "    \"Original-Caller-ID-Name\": \"392975086\",\n" + //
                        "    \"Original-Caller-ID-Number\": \"392975086\",\n" + //
                        "    \"Overflow-ID\": \"1747580617834-8d4093c9\",\n" + //
                        "    \"Owner-ID\": \"52412226da14f0de88bba67077a69bc6\",\n" + //
                        "    \"Queue-ID\": \"da92390c8c96b7cdebc9f5a6d8963710\",\n" + //
                        "    \"Realm\": \"cc.ipcc.vn\",\n" + //
                        "    \"Request-ID\": \"c3becf7e3309\",\n" + //
                        "    \"Retain-CID\": \"true\",\n" + //
                        "    \"Username\": \"vt_dvkh_kcanh465_cc2\",\n" + //
                        "    \"Voice-Channel-Group\": \"52913b5b-2ca1-4430-8011-9b57da21618d\",\n" + //
                        "    \"Voice-Channel-Number\": \"1068\",\n" + //
                        "    \"Media-Recordings\": [\n" + //
                        "      \"202505-ef3c279cdfcf1b79ee9c368d637db4c4\"\n" + //
                        "    ],\n" + //
                        "    \"Media-Names\": [\n" + //
                        "      \"1f8f4cf7e6aa247f088f9b160a6da1e3.mp3\"\n" + //
                        "    ]\n" + //
                        "  },\n" + //
                        "  \"Custom-Application-Vars\": {},\n" + //
                        "  \"Channel-State\": \"REPORTING\",\n" + //
                        "  \"Channel-Name\": \"sofia/sipinterface_dcn/vt_dvkh_kcanh465_cc2@cc.ipcc.vn\",\n" + //
                        "  \"Channel-Created-Time\": 1747580618032847,\n" + //
                        "  \"Channel-Call-State\": \"HANGUP\",\n" + //
                        "  \"Caller-ID-Number\": \"392975086\",\n" + //
                        "  \"Caller-ID-Name\": \"392975086\",\n" + //
                        "  \"Callee-ID-Number\": \"+841068\",\n" + //
                        "  \"Callee-ID-Name\": \"lê hoàng anh none\",\n" + //
                        "  \"Call-Direction\": \"outbound\",\n" + //
                        "  \"Billing-Seconds\": 47,\n" + //
                        "  \"Call-ID\": \"0a466f774301acce9f7f4324b04248f3-52412226da14f0de88bba67077a69bc6-8d81f439\",\n" + //
                        "  \"Node\": \"kazoo_apps@hni6-ecallmgr-0.hni6-nodes.ipcc.svc.cluster.local\",\n" + //
                        "  \"Msg-ID\": \"1747580668072757\",\n" + //
                        "  \"Event-Name\": \"CHANNEL_DESTROY\",\n" + //
                        "  \"Event-Category\": \"call_event\",\n" + //
                        "  \"App-Version\": \"4.0.0\",\n" + //
                        "  \"App-Name\": \"ecallmgr\"\n" + //
                        "}");
    }

    public void changeAgent(String agent){
        String markStr = "Callee-ID-Name\": \"";

        int index = this.channelCreateAnswerOut.indexOf("Callee-ID-Name");
        String[] split = this.channelCreateAnswerOut.substring(index).split(",");
        String oldAgent = split[0].split(":")[1].replace("\"", "");
        int agentIndex = this.channelCreateAnswerOut.indexOf(split[0]) + markStr.length();
        if (agentIndex != -1) {
            this.channelCreateAnswerOut.replace(agentIndex, agentIndex + oldAgent.length(), agent + "\"");
        }
        // System.out.println(this.channelCreateAnswerOut.substring(index).split(",")[0]);

        int index2 = this.channelUnbridge.indexOf("Callee-ID-Name");
        String[] split2 = this.channelUnbridge.substring(index2).split(",");
        String oldAgent2 = split2[0].split(":")[1].replace("\"", "");
        int agentIndex2 = this.channelUnbridge.indexOf(split2[0]) + markStr.length();
        if (agentIndex2 != -1) {
            this.channelUnbridge.replace(agentIndex2, agentIndex2 + oldAgent2.length(), agent+"\"");
        }
        // System.out.println(this.channelUnbridge.substring(index2).split(",")[0]);

        int index3 = this.channelDestroyOut.indexOf("Callee-ID-Name");
        String[] split3 = this.channelDestroyOut.substring(index3).split(",");
        String oldAgent3 = split3[0].split(":")[1].replace("\"", "");
        int agentIndex3 = this.channelDestroyOut.indexOf(split3[0]) + markStr.length();
        if (agentIndex3 != -1) {
            this.channelDestroyOut.replace(agentIndex3, agentIndex3 + oldAgent3.length(), agent + "\"");
        }

        // System.out.println(this.channelDestroyOut.substring(index3).split(",")[0]);

        int index4 = this.channelCreateOut.indexOf("Callee-ID-Name");
        String[] split4 = this.channelCreateOut.substring(index4).split(",");
        String oldAgent4 = split4[0].split(":")[1].replace("\"", "");
        int agentIndex4 = this.channelCreateOut.indexOf(split4[0]) + markStr.length();
        if (agentIndex4 != -1) {
            this.channelCreateOut.replace(agentIndex4, agentIndex4 + oldAgent4.length(), agent + "\"");
        }

        // System.out.println(this.channelCreateOut.substring(index4).split(",")[0]);

        
        int index5 = this.channelBridge.indexOf("Callee-ID-Name");
        String[] split5 = this.channelBridge.substring(index5).split(",");
        String oldAgent5 = split5[0].split(":")[1].replace("\"", "");
        int agentIndex5 = this.channelBridge.indexOf(split5[0]) + markStr.length();
        if (agentIndex5 != -1) {
            this.channelBridge.replace(agentIndex5, agentIndex5 + oldAgent5.length(), agent + "\"");
        }

        // System.out.println(this.channelBridge.substring(index5).split(",")[0]);

        int index6 = this.channelDestroyIn.indexOf("Callee-ID-Name");
        String[] split6 = this.channelDestroyIn.substring(index6).split(",");
        String oldAgent6 = split6[0].split(":")[1].replace("\"", "");
        int agentIndex6 = this.channelDestroyIn.indexOf(split6[0]) + markStr.length();
        if (agentIndex6 != -1) {
            this.channelDestroyIn.replace(agentIndex6, agentIndex6 + oldAgent6.length(), agent + "\"");
        }

        // System.out.println(this.channelDestroyIn.substring(index6).split(",")[0]);

    }

    public void chageCallerNumber(String callerNumber){
        String markStr = "Caller-ID-Number\": \"";
        StringBuilder[] infomation = {this.channelCreateIn, this.channelQueue, this.channelCreateOut ,this.channelCreateAnswerOut, this.channelUnbridge, this.channelDestroyOut, this.channelCreateOut, this.channelBridge, this.channelDestroyIn};
        for (StringBuilder channel : infomation) {
            int index = channel.indexOf("\"Caller-ID-Number\":");
            if (index == -1) {
                continue;
            }
            String[] split = channel.substring(index).split(",");
            String oldCallerNumber = split[0].split(":")[1].replace("\"", "");
            int callerIndex = channel.indexOf(split[0]) + markStr.length();
            if (callerIndex != -1) {
                channel.replace(callerIndex, callerIndex + oldCallerNumber.length(), "\""+callerNumber);
            }
            // System.out.println(channel.substring(index).split(",")[0]);
            // System.out.println("oldCallerNumber: " + oldCallerNumber);
            // System.out.println("newCallerNumber: " + callerNumber);
        }
        
    }

    public void changeQueue(String queue){
        String markStr = "Queue-ID\": \"";
        StringBuilder[] infomation = {this.channelCreateIn, this.channelQueue, this.channelCreateOut ,this.channelCreateAnswerOut,
                this.channelUnbridge, this.channelDestroyOut,
                this.channelCreateOut, this.channelBridge, this.channelDestroyIn};
        for (StringBuilder channel : infomation) {
            int index = channel.indexOf("\"Queue-ID\":");
            if (index == -1) {
                continue;
            }
            String[] split = channel.substring(index).split(",");
            String oldQueue = split[0].split(":")[1].replace("\"", "");
            int queueIndex = channel.indexOf(split[0]) + markStr.length();
            if (queueIndex != -1) {
                channel.replace(queueIndex, queueIndex + oldQueue.length(), "\""+queue);
            }
            // System.out.println(channel.substring(index).split(",")[0]);
        }
        
    }

    public void changeTimeUnix(String time){
        String markStr = "Unix-Time-Ms\": ";
        
        StringBuilder[] infomation = {this.channelCreateIn, this.channelQueue, this.channelCreateOut ,this.channelCreateAnswerOut,
                this.channelUnbridge, this.channelDestroyOut,
                this.channelCreateOut, this.channelBridge, this.channelDestroyIn};
        for (StringBuilder channel : infomation) {
            int index = channel.indexOf("\"Unix-Time-Ms\":");
            if (index == -1) {
                continue;
            }
            String[] split = channel.substring(index).split(",");
            String oldTime = split[0].split(":")[1].replace("\"", "");
            int timeIndex = channel.indexOf(split[0]) + markStr.length();
            if (timeIndex != -1) {
                channel.replace(timeIndex, timeIndex + oldTime.length(), time.substring(0, time.length()-1));
            }
            // System.out.println(channel.substring(index).split(",")[0]);
        }
        
    }

    public static void main(String[] args) {
        CallSequence testSequence = new CallSequence();
        testSequence.changeAgent("test agent");;
    }
}
