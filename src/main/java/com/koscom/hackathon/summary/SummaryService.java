package com.koscom.hackathon.summary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SummaryService {
	private final SummaryRepository summaryRepository;

	@Autowired
	public SummaryService(SummaryRepository memoRepository) {
		this.summaryRepository = memoRepository;
	}

	public Optional<Summary> getMemoById(Long id) {
		return summaryRepository.findById(id);
	}

	public Summary saveMemo(Summary memo) {
		return summaryRepository.save(memo);
	}
}
