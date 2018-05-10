package com.rabbitshop.hotswapsample.services.impl;

import com.rabbitshop.hotswapsample.data.SampleMsg;
import com.rabbitshop.hotswapsample.services.HotSwapService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter(value = AccessLevel.PROTECTED)
@Service("springLoadedService")
public class HotSwapServiceImpl implements HotSwapService {

	Map<String, List<String>> messages = new HashMap<>();

	@Override
	public void postMessage(final SampleMsg sampleMsg) {

		String author = sampleMsg.getAuthor();
		String msg = sampleMsg.getMessage();

		List<String> messages = getMessages().get(author);
		if(messages == null) {
			messages = new ArrayList<>();
		}
		messages.add(msg);

		getMessages().put(author, messages);
	}

	@Override
	public Map<String, List<String>> getAllMessages() {

		return getMessages();
	}

	@Override
	public int countMessages(String author) {

		List<String> messages = getMessages().get(author);
		if(messages != null) {
			return messages.size();
		}
		return 0;
	}

}
