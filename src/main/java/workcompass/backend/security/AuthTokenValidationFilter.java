package workcompass.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.lang.NonNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthTokenValidationFilter extends OncePerRequestFilter {
    private final Cache revokedTokensCache;

    public AuthTokenValidationFilter(Cache cache) {
        this.revokedTokensCache = cache;
    }
    public AuthTokenValidationFilter(CacheManager cacheManager) {
        this.revokedTokensCache = cacheManager.getCache("revokedTokens");
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        String requestUrl = request.getRequestURL().toString();
        if(requestUrl.endsWith("/register") || requestUrl.endsWith("/authenticate"))
            filterChain.doFilter(request, response);
        else{
            String token  = request.getHeader("Authorization");
            if(token==null || !token.startsWith("Bearer "))
                filterChain.doFilter(request, response);
            else{
                token = token.substring(7);
                if (revokedTokensCache.get(token) != null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                }
                else {
                    filterChain.doFilter(request, response);
                }
            }
        }
    }
}
