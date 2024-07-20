package com.example.project.post.Component;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StripeClient {

    StripeClient() {
        Stripe.apiKey = "sk_test_51PeDP52LcKsxHXVFPwnjslhsL1PAIsZxyFm58djXnCRXT38EohFSNKOjZBDp9pI975R8Hn8FYitbLfAQD89MsPdM00dmxxbaOA";
    }

    public Charge chargeCreditCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount*100));
        chargeParams.put("currency", "EUR");
            chargeParams.put("source", token);
        return Charge.create(chargeParams);
    }
}
