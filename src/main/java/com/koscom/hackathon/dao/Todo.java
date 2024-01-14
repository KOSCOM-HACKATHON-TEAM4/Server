package com.koscom.hackathon.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Todo {
	private Long id;
	private String title;
	private boolean completed;
}
