package bootcamp.microservices.app.creditcardclients.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.creditcardclients.documents.ClientCreditCard;
import bootcamp.microservices.app.creditcardclients.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.creditcardclients.repository.ClientCreditCardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientCreditCardServiceImpl implements ClientCreditCardService {

	private static final Logger log = LoggerFactory.getLogger(ClientCreditCardServiceImpl.class);

	@Autowired
	private ClientCreditCardRepository clientCreditCardRepository;

	@Override
	public Flux<ClientCreditCard> findAll() {
		return clientCreditCardRepository.findAll()
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<ClientCreditCard> findById(String id) {
		return clientCreditCardRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("ClientCreditCard not found")));
	}

	@Override
	public Mono<ClientCreditCard> update(ClientCreditCard clientCreditCard) {
		return clientCreditCardRepository.findById(clientCreditCard.getId()).flatMap(c -> {
			clientCreditCard.setModifyUser(clientCreditCard.getModifyUser());
			clientCreditCard.setModifyDate(new Date());
			return clientCreditCardRepository.save(clientCreditCard);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("ClientCreditCard not found")));
	}

	@Override
	public Mono<ClientCreditCard> save(ClientCreditCard clientCreditCard) {
		return clientCreditCardRepository.save(clientCreditCard);
	}

	@Override
	public Mono<Void> deleteNonLogic(ClientCreditCard clientCreditCard) {
		return clientCreditCardRepository.findById(clientCreditCard.getId()).flatMap(c -> {
			return clientCreditCardRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("ClientCreditCard not found")));
	}

	@Override
	public Mono<ClientCreditCard> deleteLogic(ClientCreditCard clientCreditCard) {
		return clientCreditCardRepository.findById(clientCreditCard.getId()).flatMap(c -> {
			c.setModifyUser(clientCreditCard.getModifyUser());
			c.setModifyDate(new Date());
			return clientCreditCardRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("ClientCreditCard not found")));
	}

}
