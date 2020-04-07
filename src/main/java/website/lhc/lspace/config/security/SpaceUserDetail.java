package website.lhc.lspace.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.config.security
 * @ClassName: SpaceUserDetail
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/5 下午 06:36
 */
public class SpaceUserDetail implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String userAccount;

    private String password;

    private Integer status;

    private Collection<? extends GrantedAuthority> authorities;


    public SpaceUserDetail(String userAccount, String password, Integer status, Collection<? extends GrantedAuthority> authorities) {
        this.userAccount = userAccount;
        this.password = password;
        this.status = status;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userAccount;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return status == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == 0;
    }

    public String getUserAccount() {
        return userAccount;
    }
}
