package com.koscom.hackathon.summary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/summary")
public class SummaryController {
	private final SummaryService summaryService;

	@Autowired
	public SummaryController(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	@GetMapping("/{id}")
	public Optional<Summary> getMemoById(@PathVariable Long id) {
		return summaryService.getMemoById(id);
	}

	@PostMapping
	public Summary saveMemo(@RequestBody Summary summary) {
		return summaryService.saveMemo(summary);
	}
}
