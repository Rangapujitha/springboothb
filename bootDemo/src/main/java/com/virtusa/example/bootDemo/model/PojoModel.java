package com.virtusa.example.bootDemo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="emp11")
public class PojoModel {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column
		private Long id;
		@Column
		private String name;
		@Column
		private String email;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
					
		}
		

	}


