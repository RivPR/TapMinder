package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {
	
	@Id
	private int id;
	
	@Column(name="type_name")
	private UserTypeName typeName;

	
	
}
