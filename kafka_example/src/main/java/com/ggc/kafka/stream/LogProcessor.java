package com.ggc.kafka.stream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

public class LogProcessor implements Processor<byte[], byte[]> {

	private ProcessorContext context;

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(ProcessorContext context) {
		this.context = context;
	}

	@Override
	public void process(byte[] key, byte[] value) {

		String input = new String(value);

		if (input.contains(">>>")) {

			input = input.split(">>>")[1].trim();
			context.forward(key, input.getBytes());
		} else {
			context.forward(key, value);
		}

	}

	@Override
	public void punctuate(long arg0) {
		// TODO Auto-generated method stub

	}

}
