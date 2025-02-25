package Generics.repositoryDemo;

public interface IEntityRepository<T extends IEntity> { //IEntity ile kısıt koyduk.Sadece IEntity tarafınfan implemente edilimiş classlar kullanılabilir.

	void add(T entity);

	void delete(T entity);

	void update(T entity);
}
