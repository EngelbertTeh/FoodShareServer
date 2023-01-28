package org.foodshare.backend.entity;

import java.time.ZonedDateTime;

import org.foodshare.backend.validator.NoFunnyNames;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@MappedSuperclass
public abstract class BaseUserModel {

	@NoFunnyNames
	@Email
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9]+\\..+$")
	@Column(unique = true, nullable = false)
	private String Email;
	
	@NotBlank
    @Size(min = 8, max = 30)
	@Column(nullable=false)
    private String password;
	
	
	@NotNull
	@Column(nullable=false)
    private Boolean isDeactivated = false;
	
	@NotNull
	@Setter(AccessLevel.NONE)
    @Column(nullable=false)
    private ZonedDateTime createdAt = ZonedDateTime.now();
	
}
