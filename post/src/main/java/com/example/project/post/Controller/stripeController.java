package com.example.project.post.Controller;

import com.example.project.post.Component.StripeClient;
import com.stripe.model.Charge;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:4200")
    public class stripeController {

    private final StripeClient stripeClient;

    @Autowired
    public stripeController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        return stripeClient.chargeCreditCard(token, amount);
    }
}
