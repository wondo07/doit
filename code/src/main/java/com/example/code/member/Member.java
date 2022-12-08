package com.example.code.member;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/v1/members",produces={MediaType.APPLICATION_JSON_VALUE})
public class Member {
    @PostMapping
    public String postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
        System.out.println("# email: " + email);
        System.out.println("# name: " + name);
        System.out.println("# phone: " + phone);

        // 코드 개선이 필요한 부분
        String response =
                "{\"" +
                        "email\":\""+email+"\"," +
                        "\"name\":\""+name+"\",\"" +
                        "phone\":\"" + phone+
                        "\"}";
        return response;
    }

    @GetMapping("/{member-id}")
    public String getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return null;
    }

    @GetMapping
    public String getMembers() {
        System.out.println("# get Members");

        // not implementation
        return null;
    }

}
