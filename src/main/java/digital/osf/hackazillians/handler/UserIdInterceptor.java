package digital.osf.hackazillians.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

@AllArgsConstructor
public class UserIdInterceptor implements HandlerInterceptor {
    private final UserInterceptor user;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("user-id");
        if (userId != null && !userId.isEmpty()) {
            user.setUserId(Integer.valueOf(userId));
        }

        return true;
    }
}
