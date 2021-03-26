package Uz.market.UzMarket.web.rest;

import Uz.market.UzMarket.domain.User;
import Uz.market.UzMarket.security.SecurityUtils;
import Uz.market.UzMarket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountResource {
    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
     public ResponseEntity<?> getAccount(){
        String logon = SecurityUtils.getCurrentUserName().get();
        User user = userService.findByUser(logon);
        return ResponseEntity.ok(user);
    }
}
