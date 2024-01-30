package com.koscom.hackathon.gpt.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompletionDto {

	// 사용할 모델
	private String model="babbage-002";

	// 사용할 프롬프트 명령어
	private String prompt;

	// 프롬프트의 다양성을 조절할 명령어(default : 1)
	private float temperature = (float)(0.7);

	// 최대 사용할 토큰(default : 16)
	private int max_tokens = 100;

	@Builder
	public CompletionDto(String model, String prompt, float temperature, int max_tokens) {
		this.model = model;
		this.prompt = prompt;
		this.temperature = temperature;
		this.max_tokens = max_tokens;
	}
}