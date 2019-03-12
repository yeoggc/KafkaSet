package com.ggc.kafka.stream;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;
import org.apache.kafka.streams.processor.TopologyBuilder;

public class Application {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "filter");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop-senior01.itguigu.com:9092");

		StreamsConfig config = new StreamsConfig(props);

		TopologyBuilder builder = new TopologyBuilder();
		builder.addSource("source", "first").addProcessor("processor", new ProcessorSupplier<byte[], byte[]>() {

			@Override
			public Processor<byte[], byte[]> get() {
				return new LogProcessor();
			}
		}, "source").addSink("sink", "second", "processor");

		KafkaStreams kafkaStreams = new KafkaStreams(builder, config);
		kafkaStreams.start();

	}

}
