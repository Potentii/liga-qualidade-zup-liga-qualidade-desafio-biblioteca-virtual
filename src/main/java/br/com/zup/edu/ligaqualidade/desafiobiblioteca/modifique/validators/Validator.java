package br.com.zup.edu.ligaqualidade.desafiobiblioteca.modifique.validators;

public interface Validator<T> {
    boolean isValid(T t);
}
