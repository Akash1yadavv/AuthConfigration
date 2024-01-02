package com.hospital.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hospital.enums.AuthProvider;
import com.hospital.media.MediaResource;
import com.hospital.model.generator.UserIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails{
    /**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@Id
    @GenericGenerator(name = "user_id", type = UserIdGenerator.class)
    @GeneratedValue(generator = "user_id")
    private String id;
    @NotNull
    @NotBlank
    private String name;
    @Email
    @Column(unique = true)
    private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private boolean emailVerified;
    
    @NotNull
    private AuthProvider authProvider;
    private String authProviderId;
    @CreationTimestamp
    private Instant createdOn;	
    @UpdateTimestamp
    private Instant lastUpdatedOn;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "owner")
    private MediaResource image;
    
    private boolean blocked;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Authority> authorities = new ArrayList<>();
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}



}
