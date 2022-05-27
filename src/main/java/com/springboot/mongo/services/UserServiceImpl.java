package com.springboot.mongo.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.mongo.controller.register.UsuarioRegistroDTO;
import com.springboot.mongo.entidades.Rol;
import com.springboot.mongo.entidades.Usuario;
import com.springboot.mongo.repositories.UsuarioRepositorio;

@Service
public class UserServiceImpl implements UsuarioService {

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario addUsuario(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(),
				registroDTO.getAlias(),passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Email o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	

	// public UserDetails loadUserByUsername(String username) throws
	// UsernameNotFoundException {
	/*
	 * Usuario usuario = usuarioRepositorio.findByEmail(username); if(usuario ==
	 * null) { throw new UsernameNotFoundException("Usuario o password inválidos");
	 * } if(database
	 */

	// }

	/*
	 * @Override public UserDetails loadUserByUser(UsuarioLogin usuarioLogin) throws
	 * UsernameNotFoundException { Usuario u =
	 * usuarioRepositorio.findByEmail(usuarioLogin); System.out.println(u);
	 * 
	 * if (u == null) { throw new
	 * UsernameNotFoundException("Usuario o password inválidos"); }
	 * 
	 * BasicDBObject query = new BasicDBObject(); query.put("email", u.getEmail());
	 * query.put("contrasenia", u.getPassword());
	 * 
	 * System.out.println("no funciona"); // return
	 * database.getCollection("Usuario").find(query); return (UserDetails) u; }
	 * public void deleteUser(Long id) throws Exception { Usuario user
	 * =repositorio.findById(id) .orElseThrow(() -> new
	 * Exception("UsernotFound in deleteUser -" + this.getClass().getName()));
	 * 
	 * userRepository.delete(user); }
	 * 
	 * @PostConstruct public void init() { repositorio.addAll( Arrays.asList(new
	 * Usuario(1, "Antonio", " García", "antonio.garcia@openwebinars.net",
	 * "954000000", ""), new Usuario(2, "Maríam", " López",
	 * "maria.lopez@openwebinars.net", "954000000", ""), new Usuario(3, "Ángel",
	 * " Antúnez", "angel.antunez@openwebinars.net", "954000000", ""), new
	 * Usuario(4, "Mario", " Mario", "angel.antunez@openwebinars.net", "mario",
	 * "mario"))); }
	 * 
	 * Document document = new Document(); document.append("nombre",
	 * registroDTO.getNombre()); document.append("apellidos",
	 * registroDTO.getApellido()); document.append("email", registroDTO.getEmail());
	 * document.append("alias", registroDTO.getAlias()); //
	 * passwordEncoder.encode(registroDTO.getPassword());
	 * document.append("contrasenia", registroDTO.getPassword());
	 * 
	 * if (database.getCollection("Usuario").insertOne(document).getInsertedId() !=
	 * null) {
	 * 
	 * } else {
	 * 
	 * }
	 */
}
