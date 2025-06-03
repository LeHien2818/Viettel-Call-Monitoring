# Viettel mini project: Call Monitoring System
## Presequites:
- Java version 21
- Docker
- Nodejs version 18+

## Installation
Install Kafka through docker in kafka folder:
```
/kafka
```
Before run frontend, install neccessary dependencies first:
```
npm install
```

## Usage
Access kafka container, create 2 default topics:
- input-call-topic
- output-call-topic 

After that, run 3 services on backend, Triggered simulation scenario by send GET request to http://localhost:8082/push-call