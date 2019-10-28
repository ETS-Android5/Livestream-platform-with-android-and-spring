module.exports = {
    kafka: {
        kafkaHost: '192.168.1.4:9092',
        groupId: 'ExampleTestGroup',
        sessionTimeout: 15000,
        fromOffset: 'latest',
        commitOffsetsOnFirstJoin: true, 
        outOfRangeOffset: 'latest',
    },
    server: {
        port: 3000,
        socketCheckTime: 10000
    },
    producer: {
        kafka_topic: 'M_EVENT',
        kafka_server: 'localhost:2181',
    }
};