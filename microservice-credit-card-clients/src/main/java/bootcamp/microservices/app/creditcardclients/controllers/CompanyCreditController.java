package bootcamp.microservices.app.creditcardclients.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.app.creditcardclients.documents.ClientCreditCard;
import bootcamp.microservices.app.creditcardclients.services.ClientCreditCardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CompanyCreditController {

	@Autowired
	private ClientCreditCardService clientCreditCardService;

	@PostMapping
	public Mono<ClientCreditCard> createClient(@Valid @RequestBody ClientCreditCard clientCreditCard) {
		return clientCreditCardService.save(clientCreditCard);
	}

	@GetMapping("/all")
	public Flux<ClientCreditCard> searchAll() {
		return clientCreditCardService.findAll();
	}

	@GetMapping("/id/{id}")
	public Mono<ClientCreditCard> searchById(@PathVariable String id) {
		return clientCreditCardService.findById(id);
	}

	@PutMapping
	public Mono<ClientCreditCard> updateClientCredit(@RequestBody ClientCreditCard clientCreditCard) {
		return clientCreditCardService.update(clientCreditCard);
	}

	@DeleteMapping
	public Mono<ClientCreditCard> deleteClientCredit(@Valid @RequestBody ClientCreditCard clientCreditCard) {
		return clientCreditCardService.deleteLogic(clientCreditCard);
	}

}
