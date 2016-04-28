package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entityData.UserTypeName;

@Entity
@Table(name="user_type")
public class UserType {
	
	@Id
	private int id;
	
	@Column(name="type_name")
	@Enumerated(EnumType.STRING)
	private UserTypeName typeName;

	@OneToMany(mappedBy="usertype")
	private List<User> users;
	
	
}
