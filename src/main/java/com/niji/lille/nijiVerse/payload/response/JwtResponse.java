package com.niji.lille.nijiVerse.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.SimpleTimeZone;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String type="Bearer";

    private Long id;

    private String username;

    private String email;

    private List<String> roles;

}
