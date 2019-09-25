package edu.mum.interceptor;

import edu.mum.domain.Role;
import edu.mum.domain.Seller;
import edu.mum.domain.Status;
import edu.mum.domain.User;
import edu.mum.domain.view.UserInfo;
import edu.mum.repository.UserRepository;
import edu.mum.service.UserService;
import edu.mum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

        // get current user principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // check if the current user principal is valid.
        if(auth != null && modelAndView != null && !modelAndView.getModelMap().containsKey("userInfo")){
            User user = userRepository.findByEmail(auth.getName());
            if(user != null){
                // inject user details into the current view
                UserInfo userInfo = new UserInfo();
                userInfo.setAvatarUrl(user.getAvatar());
                userInfo.setFullName(user.getFirstName() + " " + user.getLastName());
                userInfo.setJoinedDate(user.getRegisterDate().toString());
                modelAndView.addObject("userInfo", userInfo);

                // check if the seller and the seller status is un-approved, then disable manager product features
                if(user.getRole() == Role.SELLER) {
                    Seller seller = user.getSeller();
                    if(seller != null && seller.getStatus() != Status.APPROVED){
                        modelAndView.addObject("allowUpdateProduct", false);
                    }else{
                        modelAndView.addObject("allowUpdateProduct", true);
                    }
                }
            }
        }
    }
}
