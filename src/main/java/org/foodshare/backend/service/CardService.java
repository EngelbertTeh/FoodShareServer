package org.foodshare.backend.service;

import org.foodshare.backend.entity.Card;
import org.foodshare.backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {
	@Autowired
	private  CardRepository cardRepository;

	public Card issueNewCard(Card card) {
		return this.cardRepository.save(card);
	}

	public long count() {
		return this.cardRepository.count();
	}

}