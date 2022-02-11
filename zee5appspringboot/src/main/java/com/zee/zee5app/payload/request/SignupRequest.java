package com.zee.zee5app.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;
@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(min = 3, max = 20)
  private String firstname;
  @NotBlank
  @Size(min = 3, max = 20)
  private String lastname;
  
  
  
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
}
