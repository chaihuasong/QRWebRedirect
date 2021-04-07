package cn.org.htz.qrweb.controller;

import cn.org.htz.qrweb.util.IpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class Mainland {
    @GetMapping("/isMainland")
    public boolean isMainland(HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        boolean isMainland = IpUtil.isMainLand(ip);
        System.out.println(isMainland);
        return isMainland;
    }
}
