package com.ggc.kafka.producter;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class CustomPartition implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {

	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		return 1;
	}

	@Override
	public void close() {
	}

}
