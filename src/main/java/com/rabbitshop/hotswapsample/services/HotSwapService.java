package com.rabbitshop.hotswapsample.services;


import com.rabbitshop.hotswapsample.data.SampleMsg;

import java.util.List;
import java.util.Map;

public interface HotSwapService {

	void postMessage(final SampleMsg sampleMsg);

	Map<String, List<String>> getAllMessages();

	int countMessages(final String author);

}
