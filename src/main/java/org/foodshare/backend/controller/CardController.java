package org.foodshare.backend.controller;

import org.foodshare.backend.entity.Card;
import org.foodshare.backend.record.CardResponse;
import org.foodshare.backend.record.IssueCardRequest;
import org.foodshare.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
	@Autowired
	private CardService cardService;

	@PostMapping
	public CardResponse issueNewCard(@RequestBody IssueCardRequest request) {
		Card card = new Card(request.card(), request.description());
		Card savedCard = this.cardService.issueNewCard(card);
		return new CardResponse(savedCard.getId(), savedCard.getCard(), savedCard.getDescription());
	}
	
	@GetMapping("/count")
	public long count() {
		return this.cardService.count();
	}
	

}