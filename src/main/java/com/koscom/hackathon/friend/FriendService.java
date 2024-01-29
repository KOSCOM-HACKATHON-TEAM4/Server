package com.koscom.hackathon.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
	private final FriendRepository friendRepository;

	@Autowired
	public FriendService(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}

	public List<Friend> getAllFriends() {
		return friendRepository.findAll();
	}

	public Optional<Friend> getFriendById(Long id) {
		return friendRepository.findById(id);
	}

	public Friend saveFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	public void deleteFriend(Long id) {
		friendRepository.deleteById(id);
	}
}
