package com.koscom.hackathon.gpt;

import com.koscom.hackathon.gpt.dto.ChatCompletionDto;
import com.koscom.hackathon.gpt.dto.CompletionDto;
import com.koscom.hackathon.gpt.dto.CompletionRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/chatGpt")
public class ChatGPTController {

	private final ChatGPTService chatGPTService;

	public ChatGPTController(ChatGPTService chatGPTService) {
		this.chatGPTService = chatGPTService;
	}

	/**
	 * [API] ChatGPT 모델 리스트를 조회합니다.
	 */
//	@GetMapping("/modelList")
//	public ResponseEntity<List<Map<String, Object>>> selectModelList() {
//		List<Map<String, Object>> result = chatGPTService.modelList();
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
//
//	/**
//	 * [API] ChatGPT 유효한 모델인지 조회합니다.
//	 *
//	 * @param modelName
//	 * @return
//	 */
//	@GetMapping("/model")
//	public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
//		Map<String, Object> result = chatGPTService.isValidModel(modelName);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}

	/**
	 * [API] ChatGPT 모델 리스트를 조회합니다.
	 */
//	@PostMapping("/prompt")
//	public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody ChatCompletionDto chatCompletionDto) {
//		Map<String, Object> result = chatGPTService.prompt(chatCompletionDto);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}

	@PostMapping("/prompt")
	public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody CompletionDto completionDto) {
		Map<String, Object> result = chatGPTService.legacyPrompt(completionDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}