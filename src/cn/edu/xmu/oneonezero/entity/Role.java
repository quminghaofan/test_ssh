package cn.edu.xmu.oneonezero.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
		long id;
		String name;
}
