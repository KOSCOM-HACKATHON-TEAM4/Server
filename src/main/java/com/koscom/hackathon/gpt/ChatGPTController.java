package com.koscom.hackathon.gpt;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import com.lilittlecat.chatgpt.offical.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatGPTController {

	@Value("${openai.secret-key}")
	private String apikey;

	@PostMapping("/api/chatgpt")
	public ResponseEntity generateResponse(@RequestBody String prompt) {
		ChatGPT chatGPT = new ChatGPT(apikey);
		List<Message> messages = new ArrayList<>();

		messages.add(Message.builder()
				.role("system")
				.content("You are a instance of a Java API Wrapper for the Open AI API")
				.build());

		messages.add(Message.builder()
				.role("user")
				.content(prompt)
				.build());

		return ResponseEntity.ok(chatGPT.ask(messages));
	}
}