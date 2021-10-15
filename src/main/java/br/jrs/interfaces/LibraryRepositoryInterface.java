package br.jrs.interfaces;

import br.jrs.entities.Library;

public interface LibraryRepositoryInterface {
	public Library findById(long id);
}
