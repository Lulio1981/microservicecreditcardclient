package bootcamp.microservices.app.creditcardclients.services;

import bootcamp.microservices.app.creditcardclients.documents.ClientCreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientCreditCardService {

	public Flux<ClientCreditCard> findAll();

	public Mono<ClientCreditCard> findById(String id);

	public Mono<ClientCreditCard> save(ClientCreditCard clientCreditCard);

	public Mono<ClientCreditCard> update(ClientCreditCard clientCreditCard);

	public Mono<Void> deleteNonLogic(ClientCreditCard clientCreditCard);

	public Mono<ClientCreditCard> deleteLogic(ClientCreditCard clientCreditCard);

	public Mono<ClientCreditCard> findByIdClient(String id);

}
