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

	@Column(name="access_level")
	private int accessLevel;
	
	
	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserTypeName getTypeName() {
		return typeName;
	}

	public void setTypeName(UserTypeName typeName) {
		this.typeName = typeName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
}
