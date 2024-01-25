package Ejercicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidad.Author;
import Entidad.Book;

public class InsertBook {
	public static void main(String[] args) {
		// crea sessionFactory y session
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					    .configure( "hibernate.cfg.xml" )
					    .build();

				Metadata metadata = new MetadataSources( standardRegistry )
					    .addAnnotatedClass( Author.class )
					    .addAnnotatedClass( Book.class )
					    .getMetadataBuilder()
					    .build();

				SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
					    .build();    
				
				Session session = sessionFactory.openSession();
				
				
				try {			
					// crea un objeto Author
					// crea un objeto Student y University
					System.out.println("Creando un nuevo author...");
				
				
					 Author author = session.find(Author.class, 1);
					Book book= createBook();
					
					author.getBooks().add(book);
					book.setAuthor(author);	
										
					// comienza la transacci n
					session.beginTransaction();
					
					// guarda el objeto University
					System.out.println("Guardando el ciclista...");
					session.persist(author);
					
					// hace commit de la transaccion
					session.getTransaction().commit();
					
					// prueba para acceder a la entidad source desde de la entidad target
					session.beginTransaction();
					System.out.println("Hecho!");
				}
				catch ( Exception e ) {
					// rollback ante alguna excepci n
					System.out.println("Realizando Rollback");
					session.getTransaction().rollback();
					e.printStackTrace();
				}
				finally {
					session.close();
					sessionFactory.close();
				}
			}
			private static Author createBook() {
				Book tempBook= new Book();
				
				tempBook.setTitle("Naruto");
				tempBook.setPubdate("1995-2-5");
				tempBook.setGenre("china");
				
				return tempBook;		
			}

	
}
