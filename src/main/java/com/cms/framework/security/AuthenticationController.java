package com.cms.framework.security;

import com.cms.model.Role;
import com.cms.repository.IRoleDAO;
import com.cms.repository.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * This controller generates the token that must be present in subsequent REST
 * invocations.
 */
@RestController
public class AuthenticationController {
    @Resource
    IUserDAO userDao;
    @Resource
    IRoleDAO roleDao;
    private final TokenUtils tokenUtils = new TokenUtils();
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    @Autowired
    public AuthenticationController(final AuthenticationManager am, final UserDetailsService userDetailsService) {
        authenticationManager = am;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/auth/login", method = POST)
    public UserTransfer authorize(@RequestBody @Valid final Login login) {
        /*
		 * final User user = new User("user@user.com",
		 * "$2a$10$XUAvNW/hY4m2ld.U.s.v0OrLMfH5DXEbOiq1IoGeAoKUPXES.xnsO",
		 * true); user.setStatus(Status.APPROVED); final Role role = new
		 * Role("ROLE_ADMIN");
		 *
		 * final User saved = userDao.save(user); role.setUser(saved);
		 * roleDao.save(role);
		 */
        final UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        final Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails details = userDetailsService.loadUserByUsername(login.getUsername());
        final Set<Role> roless = userDao.retrieveByName(details.getUsername()).getRoles();

        final List<String> roles = new ArrayList<String>();
        for (final Role role : roless) {
            roles.add(role.getRole());

        }
        return new UserTransfer(details.getUsername(), roles, tokenUtils.createToken(details));
    }

    @RequestMapping(value="auth/logout", method = RequestMethod.GET)
    public void logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }


    static class UserTransfer {

        private final String username;
        private final List<String> roles;
        private final String token;

        public String getUsername() {
            return username;
        }

        public List<String> getRoles() {
            return roles;
        }

        public String getToken() {
            return token;
        }


        public UserTransfer(final String username, final List<String> roles,
                            final String token) {
            this.username = username;
            this.roles = roles;
            this.token = token;
        }
    }
}
