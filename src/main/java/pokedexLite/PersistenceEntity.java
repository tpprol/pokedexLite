package pokedexLite;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersistenceEntity {
 
		@Id @GeneratedValue
		private int id;

		public int getId() {
			return id;
		}
		
		
}
