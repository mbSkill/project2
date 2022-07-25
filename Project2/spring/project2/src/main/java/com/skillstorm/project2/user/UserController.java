package com.skillstorm.project2.user;

import com.skillstorm.project2.device.Device;
import com.skillstorm.project2.device.DeviceService;
import com.skillstorm.project2.security.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DeviceService deviceService;

    //We use the Security Context to get the correct user information. No param passing necessary.
    @GetMapping()
    public ResponseEntity<Map<String,Object>> getUser(@CurrentSecurityContext(expression="authentication?.name")
                            String username){

        Optional<User> user = userService.findByUsername(username).stream().findFirst();
        List<Device> devices = deviceService.findAllByUser(user.get().getId());
        Map<String, Object> result = new HashMap<String,Object>();
        result.put("user", user);
        result.put("devices", devices);
        return new ResponseEntity<>( result, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> setPassword(
            @CurrentSecurityContext(expression = "authentication?.name") String username, @RequestBody String password) {
        if(password.length() < 5){
            return new ResponseEntity<>("Password did not meet requirements", HttpStatus.BAD_REQUEST);
        }
         User user = userService.findByUsername(username).get(0);
         user.setPassword(password);
         return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
