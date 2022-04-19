package bootcamp.microservices.app.creditcardclients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.creditcardclients.documents.Client;
import bootcamp.microservices.app.creditcardclients.documents.ClientCreditCard;
import reactor.core.publisher.Mono;

public interface ClientCreditCardRepository extends ReactiveMongoRepository<ClientCreditCard, String> {

	public Mono<ClientCreditCard> findByCompany(Client client);
}
