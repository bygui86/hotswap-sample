package com.rabbitshop.hotswapsample.controllers;

import com.rabbitshop.hotswapsample.data.SampleMsg;
import com.rabbitshop.hotswapsample.services.HotSwapService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/hotswap/sample")
class HotSwapController {

	@Resource(name = "springLoadedService")
	@Getter(value = AccessLevel.PROTECTED)
	@Setter
	HotSwapService hotSwapService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void postMsg(@RequestBody final SampleMsg sampleMsg) {

		if (sampleMsg != null) {
			// TODO this comment is part of HotSwap test, please do not commit it uncommented
						log.info("Post message {} from {}", sampleMsg.getMessage(), sampleMsg.getAuthor());
			this.getHotSwapService().postMessage(sampleMsg);
		} else {
			log.error("MessageObject is NULL or EMPTY, not posting...");
		}
	}

	@GetMapping
	public Map<String, List<String>> getAllMessages() {

		// TODO this comment is part of HotSwap test, please do not commit it uncommented
					log.info("Get all messages");
		return this.getHotSwapService().getAllMessages();
	}

	// TODO this comment is part of HotSwap test, please do not commit it uncommented
//	@GetMapping("/{author}")
//	public int getMessagesFromAuthor(@PathVariable final String author) {
//
//		log.info("Get messages count from author {}", author);
//		return getSpringLoadedService().countMessages(author);
//	}

}