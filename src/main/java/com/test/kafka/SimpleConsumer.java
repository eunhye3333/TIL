package com.test.kafka;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class SimpleConsumer {
    private static KafkaConsumer<String, String> consumer;
    private final Properties props = new Properties();

    public SimpleConsumer(){
        props.put("bootstrap.servers", "localhost:9092"); // kafka server host 및 port
        props.put("session.timeout.ms", "10000"); // session 설정
        props.put("group.id", "quickstart-events"); // topic 설정
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // key deserializer
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // value deserializer

        consumer = new KafkaConsumer<String, String>(props); // consumer 생성

        consumer.subscribe(Arrays.asList("quickstart-events")); // topic 설정
    }

    public static void main(String[] args) {
        SimpleConsumer sc = new SimpleConsumer();

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(500);

            for(ConsumerRecord<String, String> record : records){
                String input = record.topic();
                if("quickstart-events".equals(input)){
                    System.out.println(record.value());
                } else {
                    throw new IllegalStateException("get message on topic" + record.topic());
                }
            }
        }
    }

}
