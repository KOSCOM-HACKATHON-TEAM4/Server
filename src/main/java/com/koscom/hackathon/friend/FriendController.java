package com.koscom.hackathon.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

	private final FriendService friendService;

	@Autowired
	public FriendController(FriendService friendService) {
		this.friendService = friendService;
	}

	@GetMapping
	public ResponseEntity<List<Friend>> getAllFriends() {
		return ResponseEntity.ok(friendService.getAllFriends());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Friend> getFriendById(@PathVariable Long id) {
		Optional<Friend> friend = friendService.getFriendById(id);
		return friend.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Friend> saveFriend(@RequestBody Friend friend) {
		return ResponseEntity.ok(friendService.saveFriend(friend));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Friend> updateFriend(@PathVariable Long id, @RequestBody Friend updatedFriend) {
		Optional<Friend> existingFriend = friendService.getFriendById(id);
		if (existingFriend.isPresent()) {
			Friend friend = existingFriend.get();
			friend.setName(updatedFriend.getName());
			friend.setMokdon(updatedFriend.getMokdon());
			return ResponseEntity.ok(friendService.saveFriend(friend));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFriend(@PathVariable Long id) {
		friendService.deleteFriend(id);
		return ResponseEntity.ok().build();
	}
}
