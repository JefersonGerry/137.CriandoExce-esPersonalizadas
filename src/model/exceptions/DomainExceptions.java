package model.exceptions;

public class DomainExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	
	// se cria esse construtor para que se possa instanciar a excessão personalizada
	// passando uma messangem para ela, para que fique armazenada dentro dela.
	public DomainExceptions(String msg) {
		super(msg);
		}

}
